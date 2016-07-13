package es.curso.app.log;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import es.curso.app.modelo.beans.Trabajador;

/*@Aspect*/
public class ServicioLog {

	/*@Pointcut("execution(* com.curso.app.modelo.dao.TrabajadorDAO.save(Trabajador)) && args(tr)")*/
	public void saving(Trabajador tr) {
	}
	
	/*@AfterReturning("saving(tr)")*/
	public void grabarLog(Trabajador t) {
		System.out.println("Grabar log");
		System.out.println(t);
	}
}
