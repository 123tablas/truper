package com.truper.pedidos.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {
	
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long numeroTicket;
	
	private String nombre;
	
	private String articulo;
	
	private double precio;
	
	private Integer cantidad;
	
	private Date fecha; 
	
	
	private double total;
	

	
	
	
	public double getTotal() {
		return total;
	}



	public void setTotal(double total) {
		this.total = total;
	}



	public Pedido(){
		
	}
	
	

	public Pedido(Long tickekPedido, String nombre, String articulo, double precio, Integer cantidad, Date fecha,
			double total) {
		super();
		this.numeroTicket = tickekPedido;
		this.nombre = nombre;
		this.articulo = articulo;
		this.precio = precio;
		this.cantidad = cantidad;
		this.fecha = fecha;
	
	}
	
	

	public Long getTickekPedido() {
		return numeroTicket;
	}

	public void setTickekPedido(Long tickekPedido) {
		this.numeroTicket = tickekPedido;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getArticulo() {
		return articulo;
	}

	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	
	
	
	
	
	
	
	

}
