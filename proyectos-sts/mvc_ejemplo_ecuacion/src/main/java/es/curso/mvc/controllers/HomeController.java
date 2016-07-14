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

import es.curso.mvc.models.EcuacionGrado2;
import es.curso.mvc.models.RaizException;

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
		return "index";
	}
	
	@RequestMapping(value="/calcular", method= RequestMethod.POST)
	public String saludar(@RequestParam("a") Double a,
		@RequestParam("b") Double b, 
		@RequestParam("c") Double c, 
		Model model){
		
		EcuacionGrado2 ec = new EcuacionGrado2(a,b,c);
		
		 
		try {
			Double result1 = ec.getSol1();
			Double result2 = ec.getSol2();
			model.addAttribute("result1", result1);
			model.addAttribute("result2", result2);
			
			return "calcular";
			
		} catch (RaizException e) {

			model.addAttribute("error", e.getMessage());
			return "error";
		}
		
		
	}
}
