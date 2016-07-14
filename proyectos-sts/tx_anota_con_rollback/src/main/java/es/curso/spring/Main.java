package es.curso.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;



public class Main {

	public static void main(String[] args) {
		ApplicationContext contexto;
				
		contexto = new ClassPathXmlApplicationContext("contexto.xml");
		
		// Recuperar la plantilla del contexto:
		JdbcTemplate temp;
		
		temp = (JdbcTemplate) contexto.getBean("jdbcTemplate");
		
		// Version 3.1.2
		int n = temp.queryForInt("select count(*) from clientes");
		System.out.println("Num de clientes: "+ n);
		
		// Versión 3.2.3
		int n2 = temp.queryForObject("select count(*) from clientes", Integer.class);
		System.out.println("Num de clientes: "+ n2);
		
		n = temp.queryForObject("select count(*) from clientes where pais=?",new Object[]{"Francia"}, Integer.class);
		System.out.println("Num de clientes: "+ n);
	
		String nombre = temp.queryForObject("select nombre from clientes where idcliente=?",
				new Object[]{"ALFKI"}, String.class);
		
		System.out.println("Nombre: " + nombre);
		
		// Recuperar un cliente:
		Cliente cli = temp.queryForObject("select idcliente,nombre,pais from clientes where idcliente=?",
				new Object[]{"ALFKI"}, new RowMapper<Cliente>(){

					@Override
					public Cliente mapRow(ResultSet rst, int n)
							throws SQLException {
						Cliente c = new Cliente();
						
						c.setIdCliente(rst.getString("idcliente"));
						c.setNombre(rst.getString("nombre"));
						c.setPais(rst.getString("pais"));
						return c;
					}
			
		});
		System.out.println(cli);
		
		// Recuperar una coleccion de clientes:
		List<Cliente> clientes = temp.query("select idcliente,nombre,pais from clientes",new RowMapper<Cliente>(){

			@Override
			public Cliente mapRow(ResultSet rst, int n)
					throws SQLException {
				Cliente c = new Cliente();
				
				c.setIdCliente(rst.getString("idcliente"));
				c.setNombre(rst.getString("nombre"));
				c.setPais(rst.getString("pais"));
				return c;
			}
	
		});	
		
		for (Cliente c : clientes)
			System.out.println(c);
		
		
		
		((ClassPathXmlApplicationContext)contexto).close();
		


	}

}
