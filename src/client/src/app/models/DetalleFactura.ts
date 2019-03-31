import { Producto } from './Poducto';

export class DetalleFactura {
    id: Number;
    producto: Producto;
    cantidad: Number;
    precio: Number;
    iva: Number;
}
