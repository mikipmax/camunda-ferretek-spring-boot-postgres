package com.ferretek.bpms;

import com.ferretek.repositorios.ProductoRepositorio;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.spin.Spin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.util.HashMap;

import java.util.Map;

import static com.ferretek.utils.Util.*;

@Component
public class InicioProceso implements ExecutionListener {
    @Autowired
    private ProductoRepositorio servicioProducto;


    public void notify(DelegateExecution execution) {


        Map<Integer, String> cache = new HashMap<>();
        productos=servicioProducto.findAll();
        productos.forEach(s -> cache.put(s.getProdId(), s.getProdNombre() + " Pu: " + s.getProdPrecio()));
        execution.setVariable("productos", Spin.JSON(cache));
        mapPedido = new HashMap<>();
        mapStocks=new HashMap<>();

    }

}
