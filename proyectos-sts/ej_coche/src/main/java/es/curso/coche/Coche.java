package es.curso.coche;


public class Coche {
	
	private Motor motor;
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

	@Override
	public String toString() {
		return "Coche [motor=" + motor + ", radio=" + radio + "]";
	}
	
	
}
