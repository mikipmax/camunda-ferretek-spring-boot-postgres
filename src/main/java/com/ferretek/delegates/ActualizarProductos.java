package com.ferretek.delegates;

import com.ferretek.dto.Cliente;
import com.ferretek.dto.Producto;
import com.ferretek.repositorios.ClienteRepositorio;
import com.ferretek.repositorios.ProductoRepositorio;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.ferretek.utils.Util.mapPedido;


@Component
public class ActualizarProductos implements JavaDelegate {

    @Autowired
    private ProductoRepositorio servicioProducto;

    public void execute(DelegateExecution execution) {
        int prodId = Integer.parseInt(execution.getVariable("producto").toString());
        int stock = (Integer) execution.getVariable("stock");

        Map<Integer, Producto> anterioresStocks = new HashMap<>();
        Iterable<Producto> productos = servicioProducto.findAll();
        productos.forEach(s -> anterioresStocks.put(s.getProdId(), s));
        Producto productoAux = anterioresStocks.get(prodId);
        productoAux.setProdStock(productoAux.getProdStock() + stock);
        servicioProducto.save(productoAux);


    }
}
