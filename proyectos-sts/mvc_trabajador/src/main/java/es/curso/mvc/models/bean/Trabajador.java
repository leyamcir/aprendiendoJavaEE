package es.curso.mvc.models.bean;

public class Trabajador {

	private int numeroTrabajador;
	private String id;
	private String nombre;
	private String departamento;
	
	
	public Trabajador() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Trabajador(int numeroTrabajador, String id, String nombre, String departamento) {
		super();
		this.numeroTrabajador = numeroTrabajador;
		this.id = id;
		this.nombre = nombre;
		this.departamento = departamento;
	}


	public int getNumeroTrabajador() {
		return numeroTrabajador;
	}


	public void setNumeroTrabajador(int numeroTrabajador) {
		this.numeroTrabajador = numeroTrabajador;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDepartamento() {
		return departamento;
	}


	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}


	@Override
	public String toString() {
		return "Trabajador [numeroTrabajador=" + numeroTrabajador + ", id=" + id + ", nombre=" + nombre
				+ ", departamento=" + departamento + "]";
	}
	
	
}
