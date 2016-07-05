package es.curso.gestorfacturas;

public class LineaDePedido {
	
	private int cantidad;
	private Articulo articulo;
	
	public LineaDePedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LineaDePedido(int cantidad, Articulo articulo) {
		super();
		this.cantidad = cantidad;
		this.articulo = articulo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	
	public double getTotal(){
		return cantidad * articulo.getImporte();
	}

	@Override
	public String toString() {
		return "LineaDeFactura [cantidad=" + cantidad + ", articulo=" + articulo + ", getTotal()=" + getTotal() + "]";
	}

	
	

}
