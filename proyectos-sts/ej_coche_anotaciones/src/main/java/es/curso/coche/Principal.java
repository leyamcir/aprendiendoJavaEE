package es.curso.coche;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Principal {

	public static void main(String[] args) {
		
		ApplicationContext context;
		
		// Cargar el contexto de Spring
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Recuperar un bean del contexto de Spring
		Coche c1 = (Coche) context.getBean("coche");
		System.out.println(c1);
	
		
		// Cerrar el contexto
		((ClassPathXmlApplicationContext)context).close();

	}

}
