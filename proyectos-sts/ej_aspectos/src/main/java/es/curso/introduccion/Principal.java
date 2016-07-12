package es.curso.introduccion;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Principal {

	public static void main(String[] args) {
ApplicationContext context;
		
		context = new ClassPathXmlApplicationContext("applicationContext2.xml");
		
		ICoche coche = (ICoche) context.getBean("coche");
		coche.arrancar();
		coche.parar();
		
		((IExtras) coche).abs();
		((IExtras) coche).turbo();
		
		
		((ClassPathXmlApplicationContext) context).close();
	}

}
