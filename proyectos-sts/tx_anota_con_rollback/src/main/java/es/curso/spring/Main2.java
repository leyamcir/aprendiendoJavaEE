package es.curso.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.curso.modelo.beans.Trabajador;
import es.curso.modelo.dao.ITrabajadorDAO;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext contexto;
		
		contexto = new ClassPathXmlApplicationContext("contexto2.xml");
		ITrabajadorDAO dao = (ITrabajadorDAO) contexto.getBean("dao");
		
		//Trabajador t = dao.get(34);
		//System.out.println(t);
		
//		dao.insert(new Trabajador("114","Gema","informatica",0));
//		Trabajador t = new Trabajador(null, "A", "Contabilidad", 0);
//		List<Trabajador> trabajadores = dao.getAll(t);
//		for (Trabajador tr : trabajadores){
//			System.out.println(tr);
//		}
//		
		((ClassPathXmlApplicationContext)contexto).close();
	}

}
