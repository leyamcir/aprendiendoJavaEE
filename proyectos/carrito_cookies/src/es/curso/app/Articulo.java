package es.curso.app;

public class Articulo {

	private int codigo;
	private String descripcion;
	private double importe;
	
	
	public Articulo(int codigo, String descripcion, double importe) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.importe = importe;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public double getImporte() {
		return importe;
	}


	public void setImporte(double importe) {
		this.importe = importe;
	}
	
	
}
