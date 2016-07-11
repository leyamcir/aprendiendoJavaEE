package es.curso.coche;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class Motor {
	
	@Value("Diesel")
	private String tipo;
	@Value("2500")
	private int potencia;
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getPotencia() {
		return potencia;
	}
	
	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}
	
	@Override
	public String toString() {
		return "Motor [tipo=" + tipo + ", potencia=" + potencia + "]";
	}
	
	
}
