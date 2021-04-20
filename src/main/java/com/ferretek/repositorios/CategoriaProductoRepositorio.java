package com.ferretek.repositorios;

import com.ferretek.dto.CategoriaProducto;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaProductoRepositorio extends CrudRepository< CategoriaProducto,Integer> {

}
