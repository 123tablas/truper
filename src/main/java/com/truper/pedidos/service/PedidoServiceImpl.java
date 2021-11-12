package com.truper.pedidos.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.truper.pedidos.dao.IPedidoDao;
import com.truper.pedidos.model.Pedido;
import com.truper.pedidos.response.PedidoResponseRest;

@Service
public class PedidoServiceImpl implements IPedido {

	private static final Logger log = LoggerFactory.getLogger(PedidoServiceImpl.class);

	@Autowired
	private IPedidoDao iPedidoDao;

	@Transactional
	@Override
	public ResponseEntity<PedidoResponseRest> crearPedido(Pedido pedido) {

		log.info("Inicia metodo crea Pedido ");

		PedidoResponseRest response = new PedidoResponseRest();
		Date fecha = new Date();
		List<Pedido> list = new ArrayList();

		try {
			 double total = pedido.getCantidad()*pedido.getPrecio();
			pedido.setFecha(fecha);
			pedido.setTotal(total);
			Pedido pedidoSave = iPedidoDao.save(pedido);
			if (pedidoSave != null) {
				list.add(pedido);
				response.getPedidoResponse().setPedido(list);

			} else {
				log.error("Error al generar pedido");
				response.SetMetadata("Error genera pedido", "-1", "pedido no guardado");
				return new ResponseEntity<PedidoResponseRest>(response, HttpStatus.BAD_REQUEST);

			}

		} catch (Exception e) {
			log.error("Error en crear pedido");
			response.SetMetadata("Respuesta NO OK", "-1", "Error al crear pedido");
			return new ResponseEntity<PedidoResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.SetMetadata("Respuesta OK", "200", "pedido Generado Exitoso");
		return new ResponseEntity<PedidoResponseRest>(response, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<PedidoResponseRest> consultaPedido() {

		log.info("Inicia metodo lista Pedidos ");

		PedidoResponseRest respuesta = new PedidoResponseRest();

		try {
			List<Pedido> pedido = (List<Pedido>) iPedidoDao.findAll();
			respuesta.getPedidoResponse().setPedido(pedido);
			respuesta.SetMetadata("Respuesta OK", "200", "Respuesta Exitosa");

		} catch (Exception e) {
			respuesta.SetMetadata("Respuesta no valida", "-1", "Respuesta Incorrecta");
			log.error("Error al consultar pedidos", e.getMessage());
			e.getStackTrace();
			return new ResponseEntity<PedidoResponseRest>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<PedidoResponseRest>(respuesta, HttpStatus.OK);
	}
	
	
	
	@Override
	@Transactional
	public ResponseEntity<PedidoResponseRest> pedidoPorId(Long id) {
		
		log.info("Inicia metodo pedido buscarPorId");
		
		PedidoResponseRest response = new PedidoResponseRest();
		
		List<Pedido> list = new ArrayList<>();
		
		try {
			
			Optional<Pedido> categoria = iPedidoDao.findById(id);
				
				if(categoria.isPresent()) {
					list.add(categoria.get());
					response.getPedidoResponse().setPedido(list);  
				}else{
					log.error("Error en cuansultar pedido");
					response.SetMetadata("Respuesta NO OK", "-1", "pedido no encontrada");
					return new ResponseEntity<PedidoResponseRest>(response, HttpStatus.NOT_FOUND);
				}
			
		} catch (Exception e) {
			log.error("Error en cuansultar pedido");
			response.SetMetadata("Respuesta NO OK", "-1", "Error al conultar pedido");
			return new ResponseEntity<PedidoResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		response.SetMetadata("Respuesta OK", "200", "Respiuesta Exitosa");
		return new ResponseEntity<PedidoResponseRest>(response, HttpStatus.OK);
	}

}
