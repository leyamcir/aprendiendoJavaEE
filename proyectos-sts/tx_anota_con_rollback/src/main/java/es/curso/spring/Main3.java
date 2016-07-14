package es.curso.spring;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.curso.modelo.beans.Trabajador;

public class Main3 {

	public static void main(String[] args) {
		ApplicationContext contexto;
		
		contexto = new ClassPathXmlApplicationContext("contexto3.xml");
		
		DataSource ds = (DataSource) contexto.getBean("ds");
		String sql = "select * from trabajadores";
		SelectTrabajador st = new SelectTrabajador(ds, sql);
		
		List<Trabajador> trs = st.execute();
		for (Trabajador t : trs)
			System.out.println(t);
		
		((ClassPathXmlApplicationContext)contexto).close();

	}

}
