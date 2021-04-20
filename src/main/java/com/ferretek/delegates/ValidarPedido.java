package com.ferretek.delegates;

import com.ferretek.dto.Producto;
import com.ferretek.repositorios.ProductoRepositorio;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.ferretek.utils.Util.mapPedido;

@Component
public class ValidarPedido implements JavaDelegate {
    @Autowired
    private ProductoRepositorio servicioProducto;

    public void execute(DelegateExecution execution) {
        Map<Integer, Integer> stockProductos = new HashMap<>();
        //Vuelvo a listar los productos en caso de que se haya actualizado el stock
        Iterable<Producto> productos = servicioProducto.findAll();
        productos.forEach(s -> stockProductos.put(s.getProdId(), s.getProdStock()));
        Map<Integer, String> nombreProductos = new HashMap<>();
        productos.forEach(s -> nombreProductos.put(s.getProdId(), s.getProdNombre()));
        String stockActual = "Stock Actual de cada Producto\n";
        var bandera = true;
        for (Integer key : mapPedido.keySet()) {
            if (mapPedido.get(key) >= stockProductos.get(key)) {
                bandera = false;
                stockActual += nombreProductos.get(key) + " Stock: " + stockProductos.get(key) +
                        " Cantidad Solicitada: " + mapPedido.get(key) + " \nSe necesitan: " +
                        (mapPedido.get(key) - stockProductos.get(key)) + " extras\n";
            }
        }
        execution.setVariable("hayStock", bandera);
        execution.setVariable("stockActual", stockActual);


    }
}
