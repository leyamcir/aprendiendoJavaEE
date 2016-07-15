package es.curso.coche.modelo;

public class Coche {

	private String matricula;
	private String modelo;
	private int año;
	private int km;
	
	public Coche() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	@Override
	public String toString() {
		return "Coche [matricula=" + matricula + ", modelo=" + modelo + ", año=" + año + ", km=" + km + "]";
	}
	
	
	
}
