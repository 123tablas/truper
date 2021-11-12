package com.truper.pedidos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.truper.pedidos.model.Pedido;
import com.truper.pedidos.response.PedidoResponseRest;
import com.truper.pedidos.service.IPedido;

@RestController
@RequestMapping("/v1")
public class ResControlerPedidos {

	@Autowired
	private IPedido iPedido;

	@PostMapping("/pedido")
	public ResponseEntity<PedidoResponseRest> creaPeredido(@RequestBody Pedido request) {

		ResponseEntity<PedidoResponseRest> response = iPedido.crearPedido(request);

		return response;

	}

	@GetMapping("/pedido")
	public ResponseEntity<?> consultaCategoria() {

		ResponseEntity<PedidoResponseRest> response = iPedido.consultaPedido();

		return response;

	}

	@GetMapping("/pedido/{id}")
	public ResponseEntity<PedidoResponseRest> consultaPedidoId(@PathVariable Long id) {

		ResponseEntity<PedidoResponseRest> response = iPedido.pedidoPorId(id);

		return response;

	}

}
