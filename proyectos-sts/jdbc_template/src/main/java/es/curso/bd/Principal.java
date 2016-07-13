package es.curso.bd;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Principal {

	public static void main(String[] args) {
		ApplicationContext context;
		JdbcTemplate template;
		String sql;
		int n;
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Get template from context
		template = (JdbcTemplate) context.getBean("jdbcTemplate");
		
		// From here, queries are allowed using template
		
		// Count table rows
		sql = "SELECT COUNT(*) FROM clientes";
		// queryForInt is deprecated, use for Object instead
		n = template.queryForObject(sql, Integer.class);
		
		System.out.println("Num clientes: " + n);
		
		
		((ClassPathXmlApplicationContext) context).close();

	}

}
