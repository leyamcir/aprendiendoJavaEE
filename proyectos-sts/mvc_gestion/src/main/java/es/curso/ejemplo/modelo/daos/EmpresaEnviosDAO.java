package es.curso.ejemplo.modelo.daos;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import es.curso.ejemplo.modelo.beans.EmpresaEnvios;

public class EmpresaEnviosDAO extends JdbcDaoSupport implements IEmpresaEnviosDAO, RowMapper<EmpresaEnvios>{

	@Override
	public List<EmpresaEnvios> listarEmpresasEnvios() {
		// TODO Auto-generated method stub
		return getJdbcTemplate().query("select * from empresasenvios;", this);
	}

	@Override
	public EmpresaEnvios mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		EmpresaEnvios ee = new EmpresaEnvios();
		ee.setIdEmpresa(rs.getInt(1));
		ee.setNombre(rs.getString(2));
		return ee;
	}

}
