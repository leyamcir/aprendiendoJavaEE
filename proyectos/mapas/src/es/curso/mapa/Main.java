package es.curso.mapa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	
	public static void main(String[] args) {
		Map<Integer, List<String>> mapa;
		
		List<String> cadenas = new ArrayList<String>();
		cadenas.add("Uno");
		cadenas.add("Dos");
		cadenas.add("Tres");

		List<String> cadenas2 = new ArrayList<String>();
		cadenas2.add("Uno2");
		cadenas2.add("Dos2");
		cadenas2.add("Tres2");

		// Crear el mapa
		mapa = new HashMap<>();
		mapa.put(1, cadenas);
		mapa.put(2, cadenas2);
		mapa.put(1, cadenas2);
		
		for (Integer i : mapa.keySet()){
			System.out.println(i);
			for (String s : mapa.get(i))
				System.out.println(s);
		}
	}

}
