package gdd;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Descuento {
	@Id
	private String productoNombre;
	private long descuento;
	public String getProductoNombre() {
		return productoNombre;
	}
	public void setProductoNombre(String productoNombre) {
		this.productoNombre = productoNombre;
	}
	public long getDescuento() {
		return descuento;
	}
	public void setDescuento(long descuento) {
		this.descuento = descuento;
	}
	public Descuento() {}
	@Autowired
	public Descuento(String productoNombre, long descuento) {
		this.productoNombre = productoNombre;
		this.descuento = descuento;
	}

}
