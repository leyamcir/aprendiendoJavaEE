package es.curso.app.log;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		
		String linea;
		Date d = new Date();
		FileOutputStream f = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy hh:mm");
		try {
			f = new FileOutputStream("log.txt",true);
			linea = sdf.format(d) + "\t\t" + t.toString() + "\r\n";

			f.write(linea.getBytes());
			
			
		} catch (FileNotFoundException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (f != null){
				try{
					f.close();
				} catch (IOException e){
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
