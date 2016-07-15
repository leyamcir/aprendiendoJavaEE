package es.curso.ejemplo.modelo.beans;

public class EmpresaEnvios {
	
	private int idEmpresa;
	private String nombre;
	
	
	public int getIdEmpresa() {
		return idEmpresa;
	}
	public EmpresaEnvios() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmpresaEnvios(int idEmpresa, String nombre) {
		super();
		this.idEmpresa = idEmpresa;
		this.nombre = nombre;
	}
	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "EmpresaEnvios [idEmpresa=" + idEmpresa + ", nombre=" + nombre
				+ "]";
	}
}
