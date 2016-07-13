package es.curso.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
		
		System.out.println("Num clients: " + n);
		
		// Count table rows with condition
		sql = "SELECT COUNT(*) FROM clientes WHERE pais=?";
		n = template.queryForObject(sql, new Object[]{"Alemania"}, Integer.class);
		
		System.out.println("Num clients in Germany: " + n);
		
		// Get client name
		sql = "SELECT nombre FROM clientes WHERE idcliente=?";
		String nombre = template.queryForObject(sql, new Object[]{"ALFKI"}, String.class);
		
		System.out.println("Nombre cliente: " + nombre);
		
		// Get product from DB whith anonymous class
		sql = "SELECT * FROM productos WHERE id=?";
		Producto prod = template.queryForObject(sql, new Object[]{1}, 
			new RowMapper<Producto>() {
				
				@Override
				public Producto mapRow(ResultSet result, int numResult) throws SQLException {
					Producto p = new Producto();
					
					p.setId(result.getInt("id"));
					p.setNombre(result.getString("nombre"));
					p.setIdCategoria(result.getInt("idcategoria"));
					p.setPrecio(result.getDouble("precio"));						
					p.setExistencias(result.getInt("existencias"));
					
					return p;
				}
			});
		
		System.out.println(prod);
		
		
		// Get products collection
		sql = "SELECT * FROM productos WHERE precio BETWEEN ? AND ?";
		List<Producto> productos = template.query(sql, new Object[] {50, 100}, 
				new RowMapper<Producto>() {
					
					@Override
					public Producto mapRow(ResultSet result, int numResult) throws SQLException {
						Producto p = new Producto();
						
						p.setId(result.getInt("id"));
						p.setNombre(result.getString("nombre"));
						p.setIdCategoria(result.getInt("idcategoria"));
						p.setPrecio(result.getDouble("precio"));						
						p.setExistencias(result.getInt("existencias"));
						
						return p;
					}
				});
		System.out.println("Lista de productos");
		
		for (Producto p: productos) {
			System.out.println(p);
		}
		
		((ClassPathXmlApplicationContext) context).close();

	}

}
