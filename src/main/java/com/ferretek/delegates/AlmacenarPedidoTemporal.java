package com.ferretek.delegates;

import com.ferretek.dto.Producto;
import com.ferretek.repositorios.ProductoRepositorio;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.ferretek.utils.Util.*;

@Component
public class AlmacenarPedidoTemporal implements JavaDelegate {



    public void execute(DelegateExecution execution) {

        int prodId = Integer.valueOf(execution.getVariable("producto").toString());
        int depeCantidad = (Integer) execution.getVariable("depeCantidad");
        mapPedido.put(prodId, depeCantidad);



    }
}
