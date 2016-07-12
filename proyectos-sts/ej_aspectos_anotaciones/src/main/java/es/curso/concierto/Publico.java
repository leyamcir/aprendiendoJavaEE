package es.curso.concierto;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Publico {

	@Pointcut("execution(* es.curso.concierto.Concierto.actuar(..))")
	public void actuacion(){}
	
	@Pointcut("execution(* es.curso.concierto.Concierto.evaluacion(..)) && args(info)")
	public void actuacionArgs(String info){}
	
	@AfterReturning("actuacion()")
	public void aplaudir(){
		System.out.println("El público está aplaudiendo");
	}
	
	@Before("actuacion()")
	public void apagarTelefonos() {
		System.out.println("El público apaga sus teléfonos");
	}
	
	@AfterThrowing("actuacion()")
	public void abuchear(){
		System.out.println("Buuuuu, Fueraaaaa");
	}
	
	@Before("actuacionArgs(info)")
	public void recibirInfo(String info){
		System.out.println("Información para el público: " + info);
	}
	
	public void verActuacion(ProceedingJoinPoint joinpoint) { 
		try { 
			// Tareas que queremos hacer antes del método: 
			System.out.println("The audience is taking their seats."); 
			System.out.println("The audience is turning off their cellphones"); 
			long start = System.currentTimeMillis(); 
			
			joinpoint.proceed();
			
			// OJO, en este caso tenemos que lanzar la ejecución del método. 
			// en este caso es el método perform(). 
			long end = System.currentTimeMillis(); 
			
			// Tareas que queremos hacer después de la ejecución del método. 
			System.out.println("CLAP CLAP CLAP CLAP CLAP"); 
			System.out.println("The performance took " + (end - start) + " milliseconds."); 
		} catch (Throwable t) { 
			System.out.println("Boo! We want our money back!"); // Si hay error 
		} 
	}
}
