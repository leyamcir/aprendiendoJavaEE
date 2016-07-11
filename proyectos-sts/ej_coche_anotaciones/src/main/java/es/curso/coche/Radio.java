package es.curso.coche;

public class Radio {
	
	private String marca;

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "Radio [marca=" + marca + "]";
	}
	
}
