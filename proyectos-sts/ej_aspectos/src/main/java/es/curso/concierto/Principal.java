package es.curso.concierto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Principal {

	public static void main(String[] args) {

		ApplicationContext context;
		
		context = new ClassPathXmlApplicationContext("applicationContext2.xml");
		
		Concierto musicoBateria = (Concierto) context.getBean("musicoBateria");
		Concierto musicoGuitarra = (Concierto) context.getBean("musicoGuitarra");
		Concierto musicoBajo = (Concierto) context.getBean("musicoBajo");
		
		try {
			musicoBateria.actuar();
			musicoGuitarra.actuar();
			musicoBajo.actuar();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		((ClassPathXmlApplicationContext) context).close();

	}

}
