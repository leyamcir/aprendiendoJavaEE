package es.curso.ejemplo.modelo.daos;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import es.curso.ejemplo.modelo.beans.Empleado;



public class EmpleadoDAO extends JdbcDaoSupport implements IEmpleadoDAO, RowMapper<Empleado>{

	@Override
	public List<Empleado> listarEmpleados() {
		// TODO Auto-generated method stub
		return getJdbcTemplate().query("select * from empleados;", this);
	}

	@Override
	public Empleado mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		Empleado e = new Empleado();
		e.setIdEmpleado(rs.getInt(1));
		e.setNombre(rs.getString(2));
		e.setCargo(rs.getString(3));		
		return e;
	}

}
