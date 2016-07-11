package es.cursos.figuras;

public class Circulo extends Figura {
	
	private double radio;
	

	public Circulo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Circulo(String nombre, double radio) {
		super(nombre);
		this.radio = radio;
	}


	@Override
	public double area() {
		return Math.pow(radio, 2.0) * Math.PI;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	@Override
	public String toString() {
		return "Circulo [radio=" + radio + ", nombre=" + nombre + 
				" ,area=" + area() + "]";
	}
	
	

}
