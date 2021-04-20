package com.ferretek.delegates;

import com.ferretek.dto.Cliente;
import com.ferretek.dto.Producto;
import com.ferretek.repositorios.ClienteRepositorio;
import com.ferretek.repositorios.ProductoRepositorio;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.spin.Spin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class RegistrarCliente implements JavaDelegate {

    @Autowired
    private ClienteRepositorio servicioCliente;


    public void execute(DelegateExecution execution) {

        String clienCedula = execution.getVariable("clienCedula").toString();
        String clienNombres = execution.getVariable("clienNombres").toString();
        String clienApellidos = execution.getVariable("clienApellidos").toString();
        String clienCorreo = execution.getVariable("clienCorreo").toString();
        String clienTelef = execution.getVariable("clienTelef").toString();
        if (!clienCedula.isEmpty())
            servicioCliente.save(new Cliente(clienCedula, clienNombres, clienApellidos, clienCorreo, clienTelef));
        System.out.println("Registro satisfactorio");



    }
}
