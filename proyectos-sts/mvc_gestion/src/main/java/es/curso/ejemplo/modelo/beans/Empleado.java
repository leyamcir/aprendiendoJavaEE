package es.curso.ejemplo.modelo.beans;

public class Empleado {
	
	private int idEmpleado;
	private String nombre;
	private String cargo;
	
	
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Empleado(int idEmpleado, String nombre, String cargo) {
		super();
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.cargo = cargo;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", nombre=" + nombre
				+ ", cargo=" + cargo + "]";
	}
}
