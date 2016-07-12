package es.cursos.carpetas;

import java.io.File;
import java.util.List;

public class Listas {

	private List<?> carpetas;

	public Listas() {
		super();
	}

	public Listas(List<?> hijas) {
		super();
		this.carpetas = hijas;
	}

	public List<?> getCarpetas() {
		return carpetas;
	}

	public void setCarpetas(List<?> hijas) {
		this.carpetas = hijas;
	}

	@Override
	public String toString() {
		return "Listas [carpetas=" + carpetas + "]";
	}
	
	private void recorrer(List<?> listaCarpetas, String ruta){
		File carpeta = null;
		String aux = new String();
		
		for (Object o : listaCarpetas){
			if (o instanceof String){
				
				aux = ruta + (String) o;
				System.out.println("Crear carpeta: " + aux);
				System.out.println("La ruta es: " + ruta);
				carpeta = new File(aux);
				carpeta.mkdirs();
			} else {
				// Aplicar recursividad
				System.out.println("Llamada recursiva con aux:" + aux);
				recorrer((List<?>)o, aux+ "/");
			}
		}
	}
	
	public void recorrer(String rutaInicio){
		recorrer(carpetas, rutaInicio);
	}
}
