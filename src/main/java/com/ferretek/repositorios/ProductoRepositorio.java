package com.ferretek.repositorios;

import com.ferretek.dto.Cliente;
import com.ferretek.dto.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends CrudRepository<Producto,Integer > {

}
