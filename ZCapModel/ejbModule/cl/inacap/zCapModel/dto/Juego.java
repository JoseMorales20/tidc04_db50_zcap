package cl.inacap.zCapModel.dto;

import java.time.LocalDate;

public class Juego {
	private String nombre;
	private String descripccion;
	private boolean aptoNinios;
	private LocalDate fechaLanza;
	private Consola consola;
	
	
	public Consola getConsola() {
		return consola;
	}
	public void setConsola(Consola consola) {
		this.consola = consola;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripccion() {
		return descripccion;
	}
	public void setDescripccion(String descripccion) {
		this.descripccion = descripccion;
	}
	public boolean isAptoNinios() {
		return aptoNinios;
	}
	public void setAptoNinios(boolean aptoNinios) {
		this.aptoNinios = aptoNinios;
	}
	public LocalDate getFechaLanza() {
		return fechaLanza;
	}
	public void setFechaLanza(LocalDate fechaLanza) {
		this.fechaLanza = fechaLanza;
	}

}
