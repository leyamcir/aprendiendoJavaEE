package es.curso.concierto;

import org.springframework.stereotype.Component;

@Component
public class Guitarra implements Instrumento {

	public void tocar() {
		System.out.println("Suena la guitarra");
	}

}
