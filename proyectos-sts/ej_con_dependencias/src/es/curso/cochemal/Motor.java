package es.curso.cochemal;

public class Motor {
	
	private String tipo;
	private int potencia;
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getPotencia() {
		return potencia;
	}
	
	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}
	
	@Override
	public String toString() {
		return "Motor [tipo=" + tipo + ", potencia=" + potencia + "]";
	}
	
	
}
