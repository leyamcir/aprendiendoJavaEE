package es.cursos.figuras;

public class Triangulo extends Figura {
	
	private double base;
	private double altura;

	public Triangulo() {
		super();
	}

	public Triangulo(String nombre, double base, double altura) {
		super(nombre);
		this.base = base;
		this.altura = altura;
	}
	
	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	

	@Override
	public double area() {
		return base * altura / 2.0;
	}

	@Override
	public String toString() {
		return "Triangulo [nombre=" + nombre + "base=" + base + ", altura=" + altura + 
				" ,area=" + area() + "]";
	}



}
