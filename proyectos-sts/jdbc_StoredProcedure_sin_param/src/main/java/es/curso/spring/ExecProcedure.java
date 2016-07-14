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
		declareParameter(new SqlOutParameter("NumeroTrabajadores", Types.INTEGER));
		compile();
	}

	public int execute(){
		Map<String, Object> params = new HashMap<String, Object>(1);
		Map<String,Object> paramsOut = execute(params);
		
		Integer resul = (Integer) paramsOut.get("NumeroTrabajadores");
		return (resul != null) ? resul.intValue() : new Integer(0);
	}
}
