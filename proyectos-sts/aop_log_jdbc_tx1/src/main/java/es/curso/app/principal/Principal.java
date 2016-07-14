package es.curso.app.principal;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.curso.app.modelo.beans.Trabajador;
import es.curso.app.modelo.bo.ITrabajadorBO;
import es.curso.app.modelo.dao.ITrabajadorDAO;

public class Principal {

	public static void main(String[] args) {
		ApplicationContext context;
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ITrabajadorBO bo = (ITrabajadorBO) context.getBean("trabajadorBO");
		
		// Probar los métodos
		
		// Insert
		Trabajador ti = new Trabajador(0, "462", "Manuel", "Urgente");
		int n = bo.saveBO(ti);
		System.out.println(n);
		
		// Delete
		int deleteTrabajador = 100;
		int numDelete = bo.deleteBO(deleteTrabajador);
		System.out.println("Borrado: "+numDelete);
		
		// SELECT ONE
		int selectTrabajador = 97;
		Trabajador t = bo.getBO(selectTrabajador);
		System.out.println("Trabajador: "+t);
		
		// Select many
		List<Trabajador> trabajadores = bo.getAllBO();
		System.out.println("Trabajadores:");
		for (Trabajador trabajador: trabajadores) {
			System.out.println(trabajador);
		}
		
		// COUNT ALL
		int numt = bo.numTrabajadoresBO();
		System.out.println("Num trabajadores: "+ numt);
		
		// Select by fields
		// Departamento informatica
		Trabajador tr = new Trabajador();
		tr.setDepartamento("Informatica");
		
		List<Trabajador> trabajadores2 = bo.getAllBO(tr);
		System.out.println("Trabajadores en informatica:");
		for (Trabajador trabajador: trabajadores2) {
			System.out.println(trabajador);
		}
		
		// Nombre ant
		Trabajador tr2 = new Trabajador();
		tr2.setNombre("anto");
		
		List<Trabajador> trabajadores3 = bo.getAllBO(tr2);
		System.out.println("Trabajadores con anton:");
		for (Trabajador trabajador: trabajadores3) {
			System.out.println(trabajador);
		}

		
		((ClassPathXmlApplicationContext) context).close();

	}

}
