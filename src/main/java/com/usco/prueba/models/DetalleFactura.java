package com.usco.prueba.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DetalleFactura {

	@Id
	@GeneratedValue
	@Column
	private Integer id;
	
	@ManyToOne
	private Producto producto;
	
	@Column
	private int cantidad;
	
	@Column
	private int precio;
	
	@Column
	private int iva;

	public DetalleFactura(Producto producto, int cantidad, int precio, int iva) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
		this.iva = iva;
	}
	
	public DetalleFactura() {
		
	}


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}
	

	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", producto='" + getProducto().toString() + "'" +
			", cantidad='" + getCantidad() + "'" +
			", precio='" + getPrecio() + "'" +
			", iva='" + getIva() + "'" +
			"}";
	}

	
}
