package es.curso.ejemplo.modelo.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import es.curso.ejemplo.modelo.beans.Cliente;

public class ClienteDAO extends JdbcDaoSupport implements IClienteDAO, RowMapper<Cliente>{

	@Override
	public List<Cliente> listarClientes() {
		// TODO Auto-generated method stub
		return getJdbcTemplate().query("select * from clientes;", this);
	}

	@Override
	public Cliente mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		Cliente c = new Cliente();
		c.setIdCliente(rs.getString(1));
		c.setNombre(rs.getString(2));
		c.setPais(rs.getString(3));
		return c;
	}

}
