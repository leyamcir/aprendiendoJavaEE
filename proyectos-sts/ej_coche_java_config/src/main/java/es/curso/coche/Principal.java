package es.curso.coche;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Principal {

	public static void main(String[] args) {
		
		ApplicationContext context;
		
		// Cargar el contexto de Spring
		context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Radio r = context.getBean(Radio.class);
		System.out.println(r);
		
		Motor m = context.getBean(Motor.class);
		System.out.println(m);
		
		// Recuperar un bean del contexto de Spring
		Coche c1 = (Coche) context.getBean(Coche.class);
		System.out.println(c1);
	
		
		// Cerrar el contexto
		((AnnotationConfigApplicationContext)context).close();

	}

}
