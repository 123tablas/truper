package com.truper.pedidos.dao;

import org.springframework.data.repository.CrudRepository;

import com.truper.pedidos.model.Pedido;



public interface IPedidoDao extends CrudRepository<Pedido, Long> {

}

