import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Factura } from '../models/Factura';
@Injectable({
  providedIn: 'root'
})
export class AppPruebaService {

  domain: String = '/api/v1';
  constructor(private http: HttpClient) { }

  listarClientes(): Observable<any> {
    return this.http.get(`${this.domain}/cliente/listar`);
  }

  listarProductos(): Observable<any> {
    return this.http.get(`${this.domain}/producto/listar`);
  }

  registrarFactura(factura: Factura): Observable<any> {
    return this.http.post(`${this.domain}/factura/crearFactura`, factura);
  }

  verFactura(id): Observable<any> {
    return this.http.get(`${this.domain}/factura/verPorId/${id}`);
  }

  listarFacturas(): Observable<any> {
    return this.http.get(`${this.domain}/factura/listar`);
  }

}
