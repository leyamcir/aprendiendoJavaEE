package principal;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import modelo.beans.GestorCarpetas;
import modelo.beans.User;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GestorCarpetas carpetas = null;
		ApplicationContext contexto = null;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Crear usuarios del sistema:");
		System.out.print("Introduzca nombre: ");
		String nombre = scanner.nextLine();

		System.out.print("Introduzca carpeta Raiz: ");
		String carpetaRaiz = scanner.nextLine();

		// Capturar el contexto de Spring:
		contexto = new ClassPathXmlApplicationContext("applicationContext.xml");
		carpetas = (GestorCarpetas) contexto.getBean("carpetas");
		
		User user = new User(nombre, carpetaRaiz);
		crearUser(user, carpetas);
		
		scanner.close();
		((ClassPathXmlApplicationContext) contexto).close();
	}

	private static void crearUser(User user, GestorCarpetas carpetas) {
		// TODO Auto-generated method stub
		String rutaInicio = "Usuarios/" + user.getPath();
		
		// Capturar el GestorCarpetas de Spring ...
		File carpeta = new File(rutaInicio);
		carpeta.mkdirs();
		
		crearCarpetas(rutaInicio, carpetas.getPath());
	}

	private static void crearCarpetas(String rutaInicio, List<?> carpetas) {
		// Crear el arbol de carpetas. Recorre la lista de forma recursiva:
		File carpeta = null;
		String aux = new String();
		
		for (Object path : carpetas){
			if (path instanceof String){
				
				aux = rutaInicio + (String)path;
				System.out.println("Creando carpeta " + aux + " ...");
				carpeta = new File(aux);
				carpeta.mkdirs();
			
			} else // Seria una lista:
				crearCarpetas(aux + "/",(List<?>)path);
		}
	}

}
