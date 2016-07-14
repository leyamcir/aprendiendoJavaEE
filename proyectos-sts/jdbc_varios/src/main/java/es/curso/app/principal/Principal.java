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
		
		// Execute procedure with in & out params
		ApplicationContext context2 = new ClassPathXmlApplicationContext("applicationContext2.xml");
		
		DataSource ds2 = context2.getBean("ds", DataSource.class);
		ExecProcedure proc = new ExecProcedure(ds2, "calcularDetalles");
		double resultado = proc.execute(10248);
		System.out.println("Resultado: "+ resultado);
		
		((ClassPathXmlApplicationContext) context2).close();
	}

}
