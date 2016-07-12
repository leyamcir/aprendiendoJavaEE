package es.curso.concierto;

import org.aspectj.lang.ProceedingJoinPoint;

public class Publico {

	public void aplaudir(){
		System.out.println("El público está aplaudiendo");
	}
	
	public void apagarTelefonos() {
		System.out.println("El público apaga sus teléfonos");
	}
	
	public void abuchear(){
		System.out.println("Buuuuu, Fueraaaaa");
	}
	
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
