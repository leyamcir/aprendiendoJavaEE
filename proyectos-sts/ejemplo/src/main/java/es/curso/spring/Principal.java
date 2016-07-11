package es.curso.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Principal {

	public static void main(String[] args) {
		ApplicationContext context;
		
		// Cargar el contexto de Spring
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Recuperar un bean del contexto de Spring
		Mensaje m = (Mensaje) context.getBean("obj");
		System.out.println(m);
		
		// Otra forma de hacer el casting
		Mensaje m2 = context.getBean("obj", Mensaje.class);
		System.out.println(m2);
		
		// Cerrar el contexto
		((ClassPathXmlApplicationContext)context).close();
	}

}
