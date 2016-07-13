package es.curso.app.principal;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.curso.app.modelo.beans.Trabajador;
import es.curso.app.modelo.dao.ITrabajadorDAO;

public class Principal {

	public static void main(String[] args) {
		ApplicationContext context;
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ITrabajadorDAO dao = (ITrabajadorDAO) context.getBean("dao");
		
		// Probar los métodos
		
		// Insert
		Trabajador ti = new Trabajador(0, "460", "Pepa", "Restauración");
		int n = dao.save(ti);
		System.out.println(n);
		
		// Delete
		int deleteTrabajador = 102;
		int numDelete = dao.delete(deleteTrabajador);
		System.out.println("Borrado: "+numDelete);
		
		// SELECT ONE
		int selectTrabajador = 97;
		Trabajador t = dao.get(selectTrabajador);
		System.out.println("Trabajador: "+t);
		
		// Select many
		List<Trabajador> trabajadores = dao.getAll();
		System.out.println("Trabajadores:");
		for (Trabajador trabajador: trabajadores) {
			System.out.println(trabajador);
		}
		
		// COUNT ALL
		int numt = dao.numTrabajadores();
		System.out.println("Num trabajadores: "+ numt);
		
		// Select by fields
		// Departamento informatica
		Trabajador tr = new Trabajador();
		tr.setDepartamento("Informatica");
		
		List<Trabajador> trabajadores2 = dao.getAll(tr);
		System.out.println("Trabajadores en informatica:");
		for (Trabajador trabajador: trabajadores2) {
			System.out.println(trabajador);
		}
		
		// Nombre ant
		Trabajador tr2 = new Trabajador();
		tr2.setNombre("anto");
		
		List<Trabajador> trabajadores3 = dao.getAll(tr2);
		System.out.println("Trabajadores con anton:");
		for (Trabajador trabajador: trabajadores3) {
			System.out.println(trabajador);
		}

		
		((ClassPathXmlApplicationContext) context).close();

	}

}
