package es.cursos.idiomas;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Principal {

	public static void main(String[] args) {
ApplicationContext context;
		
		// Cargar el contexto de Spring
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		String pru = context.getMessage("mensaje", null, Locale.FRANCE);
		String[] param = new String[] {"pepe"};
		pru += "\n "+ context.getMessage("mostrarnombre", param, Locale.FRANCE);
		System.out.println("FRANCE: " + pru);
		
		String pru2 = context.getMessage("mensaje", null, Locale.US);	
		pru2 += "\n "+ context.getMessage("mostrarnombre", param, Locale.US);
		System.out.println("ENGLISH: " + pru2);
		
		Locale esLocale = new Locale.Builder().setLanguage("es").setRegion("ES").build();
		String pru3 = context.getMessage("mensaje", null, esLocale);
		pru3 += "\n "+ context.getMessage("mostrarnombre", param, esLocale);
		System.out.println("ESPAÑOL: " + pru3);
		
		
		// Cerrar el contexto
		((ClassPathXmlApplicationContext)context).close();
	}

}
