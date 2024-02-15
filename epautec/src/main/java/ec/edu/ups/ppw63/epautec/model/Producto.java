package ec.edu.ups.ppw63.epautec.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUCTOS")
public class Producto {

    @Id
    @Column(name = "ID", unique = true, nullable = false, precision = 10, scale = 0)
    private int id;

    @Column(name = "NOMBRE", unique = false, nullable = false, length = 200)
    private String nombre;

    @Column(name = "DESCRIPCION", unique = false, nullable = true, length = 500)
    private String descripcion;

    @Column(name = "PRECIO",unique = false, nullable = true, length =20) 
    private String precio;
    
    @Column(name = "STOCK", unique = false, nullable = true, precision = 10, scale = 0)
    private int stock;


    // Otros atributos y métodos según tus requerimientos

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
    
    public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
    public String toString() {
        return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio +", Stock| "+ stock+ "]";
    }
}
