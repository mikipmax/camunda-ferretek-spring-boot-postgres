package com.ferretek.repositorios;

import com.ferretek.dto.Cliente;
import com.ferretek.dto.DetallePedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoRepositorio extends CrudRepository<DetallePedido,Integer> {

}
