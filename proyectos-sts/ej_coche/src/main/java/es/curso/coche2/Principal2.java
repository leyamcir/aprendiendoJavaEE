package es.curso.coche2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.curso.coche.Coche;

public class Principal2 {
	
public static void main(String[] args) {
		
		ApplicationContext context;
		
		// Cargar el contexto de Spring
		context = new ClassPathXmlApplicationContext("applicationContext2.xml");
		
		
		// Otra forma de hacer el casting
		Coche c2 = context.getBean("cocheObj2", Coche.class);
		System.out.println(c2);
		
		// Cerrar el contexto
		((ClassPathXmlApplicationContext)context).close();

	}

}
