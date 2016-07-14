package es.curso.spring;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {

	public static void main(String[] args) {
		ApplicationContext contexto = new ClassPathXmlApplicationContext("contexto.xml");
		
		DataSource ds = contexto.getBean("ds", DataSource.class);		
		ExecProcedure proc = new ExecProcedure(ds, "NumeroTrabajadores");
		int resultado = proc.execute();
		System.out.println("Resultado: " + resultado);
		
		((ClassPathXmlApplicationContext) contexto).close();
	}
}
