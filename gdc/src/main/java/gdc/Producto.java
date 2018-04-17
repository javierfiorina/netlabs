package main.java.gdc;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Producto {

	@Id
	@Column(name="nombre")
	private String nombre;
	private int precio;
	private int stock;
	@Column(name="categoria_nombre")
	private String categoriaNombre;
	
	public Producto() {}
	@Autowired
	public Producto(final String nombre,final int precio, final int stock, final String categoriaNombre) {
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.categoriaNombre = categoriaNombre;
	}	

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
		public String getCategoriaNombre() {
		return categoriaNombre;
	}
	public void setCategoriaNombre(String categoriaNombre) {
		this.categoriaNombre = categoriaNombre;
	}
	
}
