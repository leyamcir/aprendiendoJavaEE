package es.curso.coche;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class Radio {
	
	@Value("Sony")
	private String marca;

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "Radio [marca=" + marca + "]";
	}
	
}
