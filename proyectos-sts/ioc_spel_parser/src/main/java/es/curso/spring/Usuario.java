package es.curso.spring;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private String nombre;
	private String apellidos;
	private List<String> telefonos;

	public Usuario() {
		super();

		telefonos = new ArrayList<String>();
	}

	public Usuario(String nombre, String apellidos) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

	

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public List<String> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<String> telefonos) {
		this.telefonos = telefonos;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellidos=" + apellidos + ", telefonos=" + telefonos + "]";
	}
	
	
}
