import { Component, OnInit } from '@angular/core';
import { Producto } from 'src/app/models/Poducto';
import { Cliente } from 'src/app/models/Cliente';
import { AppPruebaService } from 'src/app/services/app-prueba.service';
import { Factura } from 'src/app/models/Factura';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  productos: Producto[];
  clientes: Cliente[];
  infoForm: any;
  facturaGenerada: Boolean = false;

  detallesFactura: any[] = [];

  productosSeleccionados: Array<any>;
  constructor(private service: AppPruebaService) {
    this.service.listarClientes()
    .subscribe(res => {
      console.log(res);
        this.clientes = res;
      this.service.listarProductos()
        .subscribe(res2 => {
            this.productos = res2;
        });
    });
  }

  ngOnInit() {
    this.infoForm = {
      cliente: '',
      producto: '',
      cantidad: 1
    };
    this.productosSeleccionados = new Array();
    this.facturaGenerada = false;
  }

  agregarProducto(event) {
    event.preventDefault();
    let selProducto;
    this.productos.forEach(producto => {
      if (producto.id === Number(this.infoForm.producto)) {
        selProducto = producto;
      }
    });
    this.productosSeleccionados.push({
      nombre: selProducto.nombre,
      precio: selProducto.precio,
      cantidad: this.infoForm.cantidad,
      iva: selProducto.iva
    });

    this.detallesFactura.push({
      producto: selProducto,
      cantidad: this.infoForm.cantidad,
      iva: selProducto.iva
    });
    console.log(this.detallesFactura);

  }

  generarFactura() {
    let clienteSel;
    if (this.productosSeleccionados.length <= 0) {
      return;
    }
    this.clientes.forEach(cliente => {
      if (Number(this.infoForm.cliente) === cliente.id) {
        clienteSel = cliente;
      }
    });
    const newFactura: Factura = new Factura(clienteSel, this.detallesFactura);
    this.service.registrarFactura(newFactura)
    .subscribe(res => {
      console.log(res);
      if (res.isOk) {
        this.ngOnInit();
        this.facturaGenerada = true;
      }
    });
    console.log(newFactura);
  }
}
