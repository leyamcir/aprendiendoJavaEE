package es.curso.ejemplo.modelo.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import es.curso.ejemplo.modelo.beans.Cliente;
import es.curso.ejemplo.modelo.beans.Empleado;
import es.curso.ejemplo.modelo.beans.EmpresaEnvios;
import es.curso.ejemplo.modelo.beans.Pedido;


public class PedidoDAO extends JdbcDaoSupport implements IPedidoDAO, RowMapper<Pedido>{

	@Override
	public boolean grabar(Pedido pedido) {
		JdbcTemplate template = getJdbcTemplate();
		String sql = "insert into pedidos(idCliente,idEmpleado,idEmpresaEnvio,importe,pais) values(?,?,?,?,?)";
		try {
			Object[] o = new Object[5];
			o[0] = pedido.getCliente().getIdCliente();
			o[1] = pedido.getEmpleado().getIdEmpleado();
			o[2] = pedido.getEmpresa().getIdEmpresa();
			o[3] = pedido.getPrecio();
			o[4] = pedido.getPais();
			template.update(sql,o); //tambien se puede hacer comprobando que sea igual a 1
		}
		catch (DataAccessException e){
			return false;
		}
		return true; 
	}
	
	

	@Override
	public List<Pedido> listar() {
		JdbcTemplate template = getJdbcTemplate();
		String sql = "SELECT p.idpedido,c.idcliente,c.nombre,c.pais,e.id,e.nombre,es.id,es.nombre,p.importe,p.pais" +
				" FROM pedidos p " +
				"inner join clientes c on c.idcliente = p.idcliente " +
				"inner join empleados e on p.idempleado = e.id " +
				"inner join empresasenvios es on p.idempresaenvio = es.id order by idpedido desc";
		List<Pedido> pedidos = template.query(sql, this);	
		return pedidos;
	}

	@Override
	public Pedido mapRow(ResultSet rs, int n) throws SQLException {
		
		Pedido p = new Pedido();
		p.setIdPedido(rs.getInt(1));

		Cliente cl = new Cliente();
		cl.setIdCliente(rs.getString(2));
		cl.setNombre(rs.getString(3));
		cl.setPais(rs.getString(4));
		p.setCliente(cl);
		Empleado e = new Empleado();
		e.setIdEmpleado(rs.getInt(5));
		e.setNombre(rs.getString(6));
		e.setCargo("");
		p.setEmpleado(e);
		EmpresaEnvios es = new EmpresaEnvios();
		es.setIdEmpresa(rs.getInt(7));
		es.setNombre(rs.getString(8));
		p.setEmpresa(es);		
		p.setPrecio(rs.getDouble(9));
		p.setPais(rs.getString(10));
		
		return p;
	}

}
