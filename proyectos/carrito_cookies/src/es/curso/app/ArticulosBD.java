package es.curso.app;

import java.util.ArrayList;
import java.util.List;

public class ArticulosBD {

	private List<Articulo> articulos;
	
	
	
	public ArticulosBD() {
		super();
		articulos = new ArrayList<Articulo>();
		articulos.add(new Articulo(1, "HP", 800.0));
		articulos.add(new Articulo(2, "Toshoba", 500.0));
		articulos.add(new Articulo(3, "Inves", 1800.0));
	}



	public List<Articulo> getArticulos(){
		return articulos;
	}
}
