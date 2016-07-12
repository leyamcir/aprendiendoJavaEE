package modelo.beans;

public class User {

	private String nombre;
	private String carpetaRaiz;
			
	public User(String nombre, String carpetaRaiz) {
		super();
		this.nombre = nombre;
		this.carpetaRaiz = carpetaRaiz;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCarpetaRaiz() {
		return carpetaRaiz;
	}
	public void setCarpetaRaiz(String carpetaRaiz) {
		this.carpetaRaiz = carpetaRaiz;
	}
	@Override
	public String toString() {
		return "User [nombre=" + nombre + ", carpetaRaiz=" + carpetaRaiz + "]";
	}
	public String getPath() {
		// TODO Auto-generated method stub
		return nombre + "/" + carpetaRaiz + "/";
	}
	
	
}
