package es.curso.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.curso.modelo.beans.Trabajador;
import es.curso.modelo.bo2.ITrabajadorBO2;

public class MainBO {

	public static void main(String[] args) {
		ApplicationContext contexto;
		
		contexto = new ClassPathXmlApplicationContext("contexto4.xml");
		
		ITrabajadorBO2 trabajadorBO = (ITrabajadorBO2) contexto.getBean("bo");
		Trabajador t = new Trabajador("160","Gema","informatica",0);
		
		try {
			if (trabajadorBO.insert(t))
				System.out.println("Registro insertado");
			else
				System.out.println("ERROR");
			
			List<Trabajador> trs = trabajadorBO.getAll();
			for (Trabajador tr : trs)
				System.out.println(tr);
			
			t = trabajadorBO.get(120);
			System.out.println(t);
			
		} catch (RuntimeException e){
			System.out.println("ERROR: " + e.getMessage());
		}
		
		((ClassPathXmlApplicationContext)contexto).close();
	}

}
