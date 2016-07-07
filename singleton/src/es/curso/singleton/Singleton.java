package es.curso.singleton;

import java.util.Date;

public class Singleton {
	
	// Se define un atributo de la propia clase, pero STATIC
	private static Singleton instance = null;
	private Date tiempo;
	
	private Singleton() {
		// Capturar fecha y hora del sistema
		tiempo = new Date();
	}
	
	// Este método puede recibir parámetros
	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

	// Getters & Setters
	public Date getTiempo() {
		return tiempo;
	}

	public void setTiempo(Date tiempo) {
		this.tiempo = tiempo;
	}
	
}
