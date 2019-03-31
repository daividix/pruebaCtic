package com.usco.prueba.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cliente {

	@Id
	@GeneratedValue
	@Column
	private Integer id;
	
	@Column
	private String identificacion;
	
	@Column
	private String nombres;
	
	@Column
	private String apellidos;

	public Cliente(String identificacion, String nombres, String apellidos) {
		super();
		this.identificacion = identificacion;
		this.nombres = nombres;
		this.apellidos = apellidos;
	}
	
	public Cliente () {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	

	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", identificacion='" + getIdentificacion() + "'" +
			", nombres='" + getNombres() + "'" +
			", apellidos='" + getApellidos() + "'" +
			"}";
	}

	
}
