package es.curso.gestorfacturas;

public class Articulo {
	
	private int id;
	private String descripcion;
	private double importe;
	
	public Articulo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Articulo(int id, String descripcion, double importe) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.importe = importe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Articulo [id=" + id + ", descripcion=" + descripcion + ", importe=" + importe + "]";
	}

}
