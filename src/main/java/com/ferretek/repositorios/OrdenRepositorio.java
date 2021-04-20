package com.ferretek.repositorios;

import com.ferretek.dto.Orden;
import com.ferretek.dto.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenRepositorio extends CrudRepository<Orden,Integer> {

}
