package com.ejemplo.principal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ejemplo.spring.Entidad;

public class Prueba {
	
	public static void main(String[] args) {
		ApplicationContext contexto = new ClassPathXmlApplicationContext("contexto.xml");
		Entidad entidad;
		
		entidad = (Entidad) contexto.getBean("entidad");
		System.out.println(entidad);
		
	}

}
