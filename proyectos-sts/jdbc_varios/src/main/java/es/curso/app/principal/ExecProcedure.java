package es.curso.app.principal;

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

		declareParameter(new SqlParameter("idped", Types.INTEGER));
		declareParameter(new SqlOutParameter("total", Types.FLOAT));
		compile();
	}
	
	public double execute(int idPedido) {
		Map<String, Object> params = new HashMap<String, Object>(1);
		params.put("idped", idPedido);
		
		Map<String, Object> paramsOut = execute(params);
		
		Double result = (Double) paramsOut.get("total");
		return (result != null) ? result.doubleValue() : new Double(-1.0);
	}

}
