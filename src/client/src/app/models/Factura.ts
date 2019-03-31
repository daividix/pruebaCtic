import { Cliente } from './Cliente';
import { DetalleFactura } from './DetalleFactura';

export class Factura {
    id: Number;
    fecha: Date;
    cliente: Cliente;
    detalleFactura: Array<DetalleFactura>;

    constructor(cliente?, detalleFactura?) {
        this.cliente = cliente;
        this.detalleFactura = detalleFactura;
    }
}
