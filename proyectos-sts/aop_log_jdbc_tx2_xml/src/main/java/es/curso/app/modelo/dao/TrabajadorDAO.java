package es.curso.app.modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import es.curso.app.modelo.beans.Trabajador;

public class TrabajadorDAO extends JdbcDaoSupport 
	implements ITrabajadorDAO, RowMapper<Trabajador>{

	
	public int save(Trabajador t) {
		String sql = "INSERT INTO trabajadores " +
				"(id, nombre, departamento, numero_trabajador) "
				+ "VALUES (?, ?, ?, ?)";
				 
		int n = getJdbcTemplate().update(sql, new Object[] { t.getId(),
				t.getNombre(), t.getDepartamento(), t.getNumeroTrabajador()});  
		
		return n;
	}

	public int delete(int numero) {
		String sql = "DELETE FROM trabajadores "
				+ "WHERE numero_trabajador=?";
		int n = getJdbcTemplate().update(sql, new Object[] {numero});
		return n;
	}

	public int update(Trabajador t) {
		String sql = "UPDATE trabajadores SET " +
				"id = ?, nombre=?, departamento=? "
				+ "WHERE numero_trabajador=?";
				 
		int n = getJdbcTemplate().update(sql, new Object[] { t.getId(),
				t.getNombre(), t.getDepartamento(), t.getNumeroTrabajador()});  
		
		return n;
	}

	public Trabajador get(int numero) {
		String sql = "SELECT * FROM trabajadores WHERE numero_trabajador=?";
		Trabajador t = getJdbcTemplate().queryForObject(sql, new Object[] {numero}, this);
		
		return t;
	}

	public List<Trabajador> getAll() {
		String sql = "SELECT * FROM trabajadores";
		List<Trabajador> trabajadores = getJdbcTemplate().query(sql, this);
		
		return trabajadores;
	}

	public List<Trabajador> getAll(Trabajador t) {
		String sql = "SELECT * FROM trabajadores ";
		
		List<String> where = new ArrayList<String>();
		List<Object> obj = new ArrayList<Object>();
		
		if(t.getId() != null){
			String filter = "id = ?";
			where.add(filter);
			obj.add(t.getId());
		}
		if(t.getNombre() != null){
			String filter = "nombre LIKE ?";
			where.add(filter);
			obj.add("%"+t.getNombre()+ "%");
		}
		if(t.getDepartamento() != null){
			String filter = "departamento = ?";
			where.add(filter);
			obj.add(t.getDepartamento());
		}
		
		if(where.size() > 0){
			sql += "WHERE " + String.join(" AND ", where);
		}
		System.out.println("SQL: "+ sql);
		
		List<Trabajador> trabajadores = getJdbcTemplate().query(sql, obj.toArray(new Object[obj.size()]), this);
		return trabajadores;
	}

	public int numTrabajadores() {
		String sql = "SELECT COUNT(*) FROM trabajadores";
		int tnum = getJdbcTemplate().queryForObject(sql, Integer.class);
		return tnum;
	}

	public Trabajador mapRow(ResultSet result, int numResult) throws SQLException {
		Trabajador t = new Trabajador();
		
		t.setId(result.getString("id"));
		t.setNombre(result.getString("nombre"));
		t.setDepartamento(result.getString("departamento"));
		t.setNumeroTrabajador(result.getInt("numero_trabajador"));
		
		return t;
	}

}
