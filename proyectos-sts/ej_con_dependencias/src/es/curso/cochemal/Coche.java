package es.curso.cochemal;

public class Coche {

	// La clase Coche DEPENDE DE Motor y de Radio
	// Esta es una relación de composición. El coche se compone de ambos
	private Radio radio;
	private Motor motor;
	
	////////////////////////// MAL //////////////////////////
	
	// Ninguna clase deve ser responsable de crear los objetos de los que depende
	public Coche(){
		motor = new Motor();
		radio = new Radio();
	}

	public Radio getRadio() {
		return radio;
	}

	public void setRadio(Radio radio) {
		this.radio = radio;
	}

	public Motor getMotor() {
		return motor;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
	}
	
	
}
