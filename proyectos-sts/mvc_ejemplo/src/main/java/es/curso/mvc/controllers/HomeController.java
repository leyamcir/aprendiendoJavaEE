package es.curso.mvc.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		/*
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		*/
		return "index";
	}
	
	@RequestMapping(value="/saludar", method= RequestMethod.POST)
	public String saludar(@RequestParam("nombre") String nombre,
		@RequestParam("edad") int edad, 
		@RequestParam("fecha") Date fecha, Model model){
		
		model.addAttribute("saludo", "Hola " + nombre);
		model.addAttribute("edad", "Tienes " + edad + " a�os.");
		model.addAttribute("fecha", "Naciste el " + fecha + ".");
		return "saludar";
	}
}
