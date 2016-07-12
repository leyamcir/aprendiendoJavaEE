package es.curso.concierto;

public class Musico implements Concierto {
	
	private Instrumento instrumento;
	
	public Instrumento getInstrumento() {
		return instrumento;
	}

	public void setInstrumento(Instrumento instrumento) {
		this.instrumento = instrumento;
	}

	public void actuar() throws Exception {
		if(instrumento instanceof Guitarra){
			throw new Exception("La guitarra se fue a la pu...");
		}
			
		instrumento.tocar();
	}

	
	
}
