package es.curso.spring;

public class Usuario {

	private String nombre;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + "]";
	}
	
	
}
