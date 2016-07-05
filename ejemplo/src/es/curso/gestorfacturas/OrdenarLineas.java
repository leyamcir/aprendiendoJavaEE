package es.curso.gestorfacturas;

import java.util.Comparator;

public class OrdenarLineas implements Comparator<LineaDePedido> {
	
	public static final int PRECIO=0;
	public static final int NOMBRE=1;
	
	public static final int ASC=1;
	public static final int DESC=-1;
	
	private int tipo;
	private int sentido;
	
	public OrdenarLineas(int tipo, int sentido) {
		super();
		this.tipo = tipo;
		this.sentido = sentido;
	}

	@Override
	public int compare(LineaDePedido o1, LineaDePedido o2) {
		if (tipo == PRECIO){
			Double d1 = o1.getTotal();
			Double d2 = o2.getTotal();
			return d1.compareTo(d2)*sentido;
			
		} else { // Nombre
			return sentido*o1.getArticulo().getDescripcion()
					.compareTo(o2.getArticulo().getDescripcion());
		}
	}

	
}
