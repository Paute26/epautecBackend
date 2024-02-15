package ec.edu.ups.ppw63.epautec.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USUARIOS" )
public class Usuario {
	
	@Id
	@Column(name = "CODIGO", unique = true, nullable= false, precision = 5, scale = 0)
	private int codigo;
	
	@Column(name = "NOMBRE", unique = false, nullable= false, length=200)
	private String nombre;
	
	@Column(name = "CORREO", unique = true, nullable= false, length=200)
	private String correo;
	
	@Column(name = "PASSWORD", unique = false, nullable= false, length=100)
	private String password;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", nombre=" + nombre + ", correo=" + correo + "]";
	}
	
	

}
