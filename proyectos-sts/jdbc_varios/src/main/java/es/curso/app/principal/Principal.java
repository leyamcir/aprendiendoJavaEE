package es.curso.app.principal;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.object.SqlFunction;

import es.curso.app.modelo.beans.Trabajador;

public class Principal {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		DataSource ds = context.getBean("ds", DataSource.class);
		
		String sql = "SELECT * FROM trabajadores";
		SelectTrabajador selectTrabajador = new SelectTrabajador(ds, sql);
		
		List<Trabajador> trabajadores = selectTrabajador.execute();
		
		for (Trabajador t: trabajadores) {
			System.out.println(t);
		}
		
		// Llamada a funciones
		// Aquí no se puede usar ?
		
		sql = "SELECT calcularIVA(100,21)";
		SqlFunction f = new SqlFunction(ds, sql);
		
		System.out.println(f.runGeneric());
		
		((ClassPathXmlApplicationContext) context).close();
	}

}
