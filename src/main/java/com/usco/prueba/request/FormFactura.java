package com.usco.prueba.request;

import java.util.List;

import com.usco.prueba.models.Cliente;
import com.usco.prueba.models.DetalleFactura;

public class FormFactura {

    private Cliente cliente;
    
    private List<DetalleFactura> detalleFactura;

    public FormFactura() {

    }
    

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    

    public List<DetalleFactura> getDetalleFactura() {
        return this.detalleFactura;
    }

    public void setDetalleFactura(List<DetalleFactura> detalleFactura) {
        this.detalleFactura = detalleFactura;
    }



    @Override
    public String toString() {
        return "{" +
            " selectCliente='" + getCliente().toString() + "'" +
            ", detalleFactura='" + getDetalleFactura() + "'" +
            "}";
    }

}