package com.ferretek.delegates;

import com.ferretek.dto.Cliente;
import com.ferretek.dto.DetallePedido;
import com.ferretek.dto.Orden;
import com.ferretek.dto.Producto;
import com.ferretek.repositorios.ClienteRepositorio;
import com.ferretek.repositorios.DetallePedidoRepositorio;
import com.ferretek.repositorios.OrdenRepositorio;

import com.ferretek.utils.GenPDFI;
import com.itextpdf.text.DocumentException;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.Variables;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.io.File;
import java.io.FileNotFoundException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

import java.util.Map;

import static com.ferretek.utils.Util.mapPedido;
import static com.ferretek.utils.Util.productos;


@Component
public class GenerarFacturaPDF implements JavaDelegate {

    @Autowired
    private ClienteRepositorio servicioCliente;
    @Autowired
    private OrdenRepositorio servicioOrden;
    @Autowired
    private DetallePedidoRepositorio servicioDepe;
    @Autowired
    private GenPDFI servicioGenPDF;
    private final String resource = getClass().getResource("/detalles.pdf").getPath();

    public void execute(DelegateExecution execution) {

        String clienCedula = execution.getVariable("clienCedula").toString();
        Cliente cliente = servicioCliente.findByClienCedula(clienCedula);
        String ordenDireccionEnv = execution.getVariable("direccion").toString();
        LocalDate ordeFecha = Instant.
                ofEpochMilli(((Date) execution.getVariable("fecha"))
                        .getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        boolean envioGratis = (Boolean) execution.getVariable("envioGratis");
        double ordeCostoEnv = envioGratis ? 0 : ((Double) execution.getVariable("costoEnvio"));
        Map<Integer, Double> productosTemp = new HashMap<>();
        productos.forEach(s -> productosTemp.put(s.getProdId(), s.getProdPrecio()));
        double[] cantidadPrecioYSubtotal = new double[3];
        //Me sirve para imprmir en el PDF, el producto, precio, cantidad y subtotal
        Map<Integer, double[]> cantidadesPreciosYSubtotales = new HashMap<>();


        double total = ordeCostoEnv;
        double subtotal = 0;

        if (cliente != null) {
            Orden orden = servicioOrden.save(new Orden(cliente, ordeFecha, ordenDireccionEnv, ordeCostoEnv));
            for (Integer key : mapPedido.keySet()) {
                servicioDepe.save(new DetallePedido(orden, new Producto(key), mapPedido.get(key)));
                subtotal = productosTemp.get(key) * mapPedido.get(key);
                total += subtotal;
                cantidadPrecioYSubtotal[0] = mapPedido.get(key); //Cantidad
                cantidadPrecioYSubtotal[1] = productosTemp.get(key); //Precio
                cantidadPrecioYSubtotal[2] = subtotal;

                cantidadesPreciosYSubtotales.put(key, cantidadPrecioYSubtotal);
                cantidadPrecioYSubtotal = new double[3];
            }
        }


        //Inicio Proceso de generación de PDF
        try {
            servicioGenPDF.generarPDF(cliente, cantidadesPreciosYSubtotales, ordeCostoEnv, total, resource);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Esto me permite descargar el PDF desde un formulario en Camunda
        execution.setVariable("pdf", Variables.fileValue(new File(resource)));
        execution.setVariable("nombreCompleto", cliente.getClienNombres() + " " + cliente.getClienApellidos());
        execution.setVariable("clienCorreo", cliente.getClienCorreo());
    }


}
