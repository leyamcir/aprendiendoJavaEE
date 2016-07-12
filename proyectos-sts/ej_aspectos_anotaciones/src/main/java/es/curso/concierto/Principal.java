package es.curso.concierto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Principal {

	public static void main(String[] args) {

		ApplicationContext context;
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Concierto musicoBateria = (Concierto) context.getBean("musicoBateria");
		Concierto musicoGuitarra = (Concierto) context.getBean("musicoGuitarra");
		Concierto musicoBajo = (Concierto) context.getBean("musicoBajo");
		
		try {
			musicoBateria.actuar();
			musicoBateria.evaluacion("info: Juan Gomez");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			musicoGuitarra.actuar();
			musicoGuitarra.evaluacion("info: Ana Gomez");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			musicoBajo.actuar();
			musicoBajo.evaluacion("info: Pepe Gomez");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		((ClassPathXmlApplicationContext) context).close();

	}

}
