package es.curso.modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import es.curso.modelo.beans.Trabajador;

public class TrabajadorDAO extends JdbcDaoSupport implements ITrabajadorDAO, RowMapper<Trabajador> {

	@Override
	public Trabajador mapRow(ResultSet r, int n) throws SQLException {
		Trabajador t = new Trabajador();
		
		t.setId(r.getString("id"));
		t.setNombre(r.getString("nombre"));
		t.setDepartamento(r.getString("departamento"));
		t.setNumeroTrabajador(r.getInt("numero_trabajador"));
		return t;
	}

	@Override
	public void insert(Trabajador t) {
		// TODO Auto-generated method stub
		String sql = "insert into trabajadores(id,nombre,departamento) values(?,?,?)";
		Object []param = new Object[]{t.getId(), t.getNombre(), t.getDepartamento()};
		getJdbcTemplate().update(sql, param);
		sql = "select numero_trabajador from trabajadores where id=? and nombre=? and departamento=?";
		System.out.println(getJdbcTemplate().queryForInt(sql,param));
	}

	@Override
	public void delete(int numeroTrabajador) {
		// TODO Auto-generated method stub
		String sql = "delete from trabajadores where numero_trabajador = ?";
		Object []param = new Object[]{numeroTrabajador};
		getJdbcTemplate().update(sql, param);
	}

	@Override
	public void update(Trabajador t) {
		String sql = "update trabajadores set id=?,nombre=?,departamento=? where numero_trabajador=?";
		Object []param = new Object[]{t.getId(), t.getNombre(), t.getDepartamento(), t.getNumeroTrabajador()};
		getJdbcTemplate().update(sql, param);		
	}

	@Override
	public Trabajador get(int numeroTrabajador) {
		String sql = "select * from trabajadores where numero_trabajador = ?";
		Object []param = new Object[]{numeroTrabajador};
		return getJdbcTemplate().queryForObject(sql, param, this);
	}

	@Override
	public List<Trabajador> getAll() {
		String sql = "select * from trabajadores";
		return getJdbcTemplate().query(sql, this);
	}

	@Override
	public List<Trabajador> getAll(Trabajador t) {
		String where = "";
		String sql;
		
		if (t == null)
			return getAll();
		
		else {
			if (t.getNombre() != null)
				where = " (nombre like '%" + t.getNombre() + "%') ";
			
			if (t.getDepartamento() != null){
				if (!where.equals(""))
					where = where + " and (departamento = '"+t.getDepartamento()+"') ";
				else
					where = " ('"+t.getDepartamento()+"') ";
			}
		}
		if (!where.equals(""))
			where = " where " + where;
		sql = "select * from trabajadores " + where;
		return getJdbcTemplate().query(sql, this);
	}

}
