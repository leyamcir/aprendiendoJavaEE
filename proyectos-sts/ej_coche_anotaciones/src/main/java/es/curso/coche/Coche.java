package es.curso.coche;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class Coche {
	
	@Resource
	private Motor motor;
	
	@Autowired
	@Qualifier("radioObj")
	private Radio radio;
	
	// La clase Coche recibe las dependencias YA CREADAS!!
	
	// DOS formas de inyectar dependencias:
	
	// 1. Por constructor
	public Coche(Motor motor, Radio radio) {
		super();
		this.motor = motor;
		this.radio = radio;
	}
	
	// 2. Por setter

	public Coche() {
		super();
		System.out.println("CREANDO EL COCHE");
	}
	

	public Motor getMotor() {
		return motor;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	public Radio getRadio() {
		return radio;
	}

	public void setRadio(Radio radio) {
		this.radio = radio;
	}
	
	// Método de inicialización
	public void init(){
		System.out.println("Método de inicialización");
	}
	
	// Método de destrucción
	public void destroy(){
		System.out.println("Método de destrucción");
	}

	@Override
	public String toString() {
		return "Coche [motor=" + motor + ", radio=" + radio + "]";
	}
	
	
}
