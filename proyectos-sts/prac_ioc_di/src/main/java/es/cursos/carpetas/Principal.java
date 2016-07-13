package es.cursos.carpetas;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext; 

public class Principal {

	public static void main(String[] args) {
		ApplicationContext context;
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Listas listas = (Listas) context.getBean("lista");
		System.out.println(listas);
		
		listas.recorrer("/PracticaCarpetas/");
		
		((ClassPathXmlApplicationContext) context).close();

	}

}
