package es.curso.bd;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductoMapper implements RowMapper<Producto>{

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

}
