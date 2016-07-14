package es.curso.spring;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.object.SqlQuery;

import es.curso.modelo.beans.Trabajador;

public class SelectTrabajador extends SqlQuery<Trabajador> {

	public SelectTrabajador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SelectTrabajador(DataSource ds, String sql) {
		super(ds, sql);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected RowMapper<Trabajador> newRowMapper(Object[] obj, Map mapa) {		
		return ParameterizedBeanPropertyRowMapper.newInstance(Trabajador.class);
	}

}
