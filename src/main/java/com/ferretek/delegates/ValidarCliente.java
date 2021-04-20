package com.ferretek.delegates;

import com.ferretek.dto.Cliente;
import com.ferretek.repositorios.ClienteRepositorio;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import java.io.Serializable;




@Component
public class ValidarCliente implements JavaDelegate  {

    @Autowired
     ClienteRepositorio servicioCliente;
    public void execute(DelegateExecution execution) throws Exception  {

        String clienCedula = execution.getVariable("clienCedula").toString();

        Cliente cliente = servicioCliente.findByClienCedula(clienCedula);

        //Seteo variables iniciales del proceso
        execution.setVariable("clienteRegistrado", cliente != null ? true : false);

    }
}
