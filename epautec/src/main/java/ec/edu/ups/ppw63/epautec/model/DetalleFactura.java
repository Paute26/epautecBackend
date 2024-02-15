package ec.edu.ups.ppw63.epautec.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "DETALLE_FACTURA")
public class DetalleFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUCTO")
    private Producto producto;

    @Column(name = "CANTIDAD")
    private int cantidad;

    @Column(name = "PRECIO_UNITARIO")
    private double precioUnitario;

    @ManyToOne
    @JoinColumn(name = "ID_ENCABEZADO_FACTURA")
    private EncabezadoFactura encabezadoFactura;

    // Otros atributos y métodos según tus requerimientos

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public EncabezadoFactura getEncabezadoFactura() {
        return encabezadoFactura;
    }

    public void setEncabezadoFactura(EncabezadoFactura encabezadoFactura) {
        this.encabezadoFactura = encabezadoFactura;
    }

    @Override
    public String toString() {
        return "DetalleFactura [id=" + id + ", producto=" + producto + ", cantidad=" + cantidad + ", precioUnitario="
                + precioUnitario + ", encabezadoFactura=" + encabezadoFactura + "]";
    }
}
