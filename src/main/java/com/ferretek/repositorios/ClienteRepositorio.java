package com.ferretek.repositorios;

import com.ferretek.dto.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ClienteRepositorio extends CrudRepository<Cliente, Integer> {

    Cliente findByClienCedula(String cedula);
}
