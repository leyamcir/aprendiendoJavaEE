package es.cursos.figuras;

public abstract class Figura {
	
	protected String nombre;

	
	public Figura() {
		super();
	}
	
	public Figura(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public abstract double area();
	
	
}
