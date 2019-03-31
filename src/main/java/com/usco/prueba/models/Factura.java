package com.usco.prueba.models;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Factura {

	@Id
	@GeneratedValue
	@Column
	private Integer id;
	
	@Column
	private Date fecha;
	
	@ManyToOne
	private Cliente cliente;
	
	@OneToMany(targetEntity= DetalleFactura.class)
	private Set<DetalleFactura> detalleFactura;

	public Factura(Date fecha, Cliente cliente) {
		super();
		this.fecha = fecha;
		this.cliente = cliente;
	}
	
	public Factura() {
		
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<DetalleFactura> getDetalleFactura() {
		return detalleFactura;
	}

	public void setDetalleFactura(Set<DetalleFactura> detalleFactura) {
		this.detalleFactura = detalleFactura;
	}
	
	
	
}
