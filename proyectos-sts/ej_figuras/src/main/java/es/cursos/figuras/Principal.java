package es.cursos.figuras;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Principal {

	public static void main(String[] args) {
ApplicationContext context;
		
		// Cargar el contexto de Spring
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Recuperar un bean del contexto de Spring
		Triangulo c1 = (Triangulo) context.getBean("triangulo");
		System.out.println(c1);
		
		
		// Sólo se volverá a crear si scope="prototype"
		// si no, será un singleton
		Circulo c1a = (Circulo) context.getBean("circulo");
		System.out.println(c1a);
		
		// Cerrar el contexto
		((ClassPathXmlApplicationContext)context).close();

	}

}
