package main.java.gdc;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Categoria {
	@Id
	private String nombre;
	private int umbral;
	
	private Categoria() {}
	
	@Autowired
	public Categoria(String nombre, int umbral) {
		super();
		this.nombre = nombre;
		this.umbral = umbral;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getUmbral() {
		return umbral;
	}
	public void setUmbral(int umbral) {
		this.umbral = umbral;
	}
	
	
}
