package es.curso.ejemplo.modelo.beans;

public class Cliente {
	
	private String idCliente;
	private String nombre;
	private String pais;
	
	public Cliente(String idCliente, String nombre, String pais) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.pais = pais;
	}
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre
				+ ", pais=" + pais + "]";
	} 
}
