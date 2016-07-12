package es.curso.concierto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Musico implements Concierto {
	
	@Autowired
	@Qualifier("bateria")
	private Instrumento instrumento;
	private String info;
	
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

	public void evaluacion(String info) {
		this.info = info;
		
	}

	
	
}
