package es.curso.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Principal2 {

	public static void main(String[] args) {
		ApplicationContext context;
		
		// Cargar el contexto de Spring
		context = new ClassPathXmlApplicationContext("applicationContext2.xml");
		
		// Recuperar un bean del contexto de Spring
		Configuracion m = (Configuracion) context.getBean("config");
		System.out.println(m);
		
		
		// Cerrar el contexto
		((ClassPathXmlApplicationContext)context).close();
	}

}
