package org.ejemplo.principal;

import org.ejemplo.modelo.IExtras;
import org.ejemplo.modelo.IVehiculo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Principal {

	public static void main(String[] args) {
		ApplicationContext contexto = new ClassPathXmlApplicationContext("beans.xml");
		
		IVehiculo coche = (IVehiculo) contexto.getBean("coche");
		coche.arrancar();
				
		// Llamar a los metodos introducidos
		((IExtras)coche).activarAirbag();
		
		((ClassPathXmlApplicationContext) contexto).close();
	}
}
