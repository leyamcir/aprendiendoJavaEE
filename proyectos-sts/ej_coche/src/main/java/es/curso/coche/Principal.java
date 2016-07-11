package es.curso.coche;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Principal {

	public static void main(String[] args) {
		
		ApplicationContext context;
		
		// Cargar el contexto de Spring
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Recuperar un bean del contexto de Spring
		Coche c1 = (Coche) context.getBean("cocheObj");
		System.out.println(c1);
		
		
		// Sólo se volverá a crear si scope="prototype"
		// si no, será un singleton
		Coche c1a = (Coche) context.getBean("cocheObj");
		System.out.println(c1a);
		
		// Otra forma de hacer el casting
		Coche c2 = context.getBean("cocheObj2", Coche.class);
		System.out.println(c2);
		
		// Cerrar el contexto
		((ClassPathXmlApplicationContext)context).close();

	}

}
