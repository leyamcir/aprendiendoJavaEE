package es.curso.concierto;

public class Musico implements Concierto {
	
	private Instrumento instrumento;
	
	public Instrumento getInstrumento() {
		return instrumento;
	}

	public void setInstrumento(Instrumento instrumento) {
		this.instrumento = instrumento;
	}

	public void actuar() {
		instrumento.tocar();
	}

	
	
}
