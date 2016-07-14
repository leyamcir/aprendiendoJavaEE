package es.curso.spring;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {

	public static void main(String[] args) {
		ApplicationContext contexto = new ClassPathXmlApplicationContext("contexto.xml");
		
		DataSource ds = contexto.getBean("ds", DataSource.class);		
		ExecProcedure proc = new ExecProcedure(ds, "calcularPedido2");
		double resultado = proc.execute(10248);
		System.out.println("Resultado: " + resultado);
		
		((ClassPathXmlApplicationContext) contexto).close();
	}
}
