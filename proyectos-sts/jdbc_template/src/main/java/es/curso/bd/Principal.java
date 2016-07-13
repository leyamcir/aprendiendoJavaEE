package es.curso.bd;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Principal {

	public static void main(String[] args) {
		ApplicationContext context;
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		((ClassPathXmlApplicationContext) context).close();

	}

}
