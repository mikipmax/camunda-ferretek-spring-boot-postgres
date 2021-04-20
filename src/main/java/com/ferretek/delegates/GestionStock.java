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
public class GestionStock implements JavaDelegate {

    @Autowired
    private ProductoRepositorio servicioProducto;

    public void execute(DelegateExecution execution) {


        Map<Integer, Producto> anterioresStocks = new HashMap<>();
        Iterable<Producto> productos = servicioProducto.findAll();
        productos.forEach(s -> anterioresStocks.put(s.getProdId(), s));
        Producto productoAux = null;
        for (Integer key : mapPedido.keySet()) {
            productoAux = anterioresStocks.get(key);
            productoAux.setProdStock(productoAux.getProdStock() - mapPedido.get(key));
            servicioProducto.save(productoAux);
        }


    }
}
