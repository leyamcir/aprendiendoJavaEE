package es.curso.bd;

public class Producto {

	private int id;
	private String nombre;
	private int idCategoria;
	private double precio;
	private int existencias;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getExistencias() {
		return existencias;
	}
	public void setExistencias(int existencias) {
		this.existencias = existencias;
	}
	
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", idCategoria=" + idCategoria + ", precio=" + precio
				+ ", existencias=" + existencias + "]";
	}
	
	
}
