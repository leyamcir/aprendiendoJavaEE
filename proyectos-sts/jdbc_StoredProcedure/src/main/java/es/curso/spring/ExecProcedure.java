package es.curso.spring;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class ExecProcedure extends StoredProcedure {

	public ExecProcedure(DataSource ds, String name) {
		super(ds, name);
		setFunction(true);		
		declareParameter(new SqlOutParameter("calcularPedido2", Types.DOUBLE));
		declareParameter(new SqlParameter("id_pedido", Types.INTEGER));		
		compile();
	}

	public double execute(int id){
		Map<String, Object> params = new HashMap<String, Object>(1);
		params.put("id_pedido", id);
		Map<String,Object> paramsOut = execute(params);
		
		Double resul = (Double) paramsOut.get("calcularPedido2");
		return (resul != null) ? resul.doubleValue() : new Double(-1.0);
	}
}
