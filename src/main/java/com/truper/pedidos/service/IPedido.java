package com.truper.pedidos.service;

import org.springframework.http.ResponseEntity;

import com.truper.pedidos.model.Pedido;
import com.truper.pedidos.response.PedidoResponseRest;

public interface IPedido {
	
	public ResponseEntity<PedidoResponseRest> crearPedido(Pedido pedido);
	
	public ResponseEntity<PedidoResponseRest> consultaPedido();
	
	
	public ResponseEntity<PedidoResponseRest> pedidoPorId(Long id);
	
	

}
