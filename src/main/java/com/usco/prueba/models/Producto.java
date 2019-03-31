package com.usco.prueba.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Producto {

	@Id
	@GeneratedValue
	@Column
	private Integer id;
	
	@Column
	private String nombre;
	
	@Column
	private int precio;
	
	@Column
	private int iva;

	public Producto(String nombre, int precio, int iva) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.iva = iva;
	}
	
	public Producto() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	
}
