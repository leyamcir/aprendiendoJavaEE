package es.curso.app.principal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Principal {

	public static void main(String[] args) {
		ApplicationContext contexto;
		
		contexto = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		JdbcTemplate tmp = (JdbcTemplate) contexto.getBean("tmp");
		String sql = "select count(*) from trabajadores";
		int n = tmp.queryForObject(sql, Integer.class);
		System.out.println(n);
		
		((ClassPathXmlApplicationContext) contexto).close();

	}

}
