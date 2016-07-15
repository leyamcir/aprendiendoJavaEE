package es.curso.mvc.controllers;

import java.text.DateFormat;


import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.curso.mvc.models.bean.Trabajador;
import es.curso.mvc.models.bo.ITrabajadorBO;



/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	
	@Autowired
	private ITrabajadorBO bo;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		/*logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		*/
		return "home";
	}
	
	@RequestMapping(value = "/nuevoTrabajador", method = RequestMethod.GET)
	public String nuevoTrabajador(Locale locale, Model model) {
		return "nuevoTrabajador";
	}
	
	@RequestMapping(value = "/listadoTrabajadores", method = RequestMethod.GET)
	public String listadoTrabajadores(Locale locale, Model model) {
		
		List<Trabajador> listTr = bo.getAllBO();
		model.addAttribute("trabajadores", listTr);
		
		return "listadoTrabajadores";
	}
	
	@RequestMapping(value="/addTrabajador", method= RequestMethod.POST)
	public String saludar(@RequestParam("id") String id,
		@RequestParam("nombre") String nombre, 
		@RequestParam("departamento") String departamento, 
		Model model){
	
		 
		try {
			Trabajador ti = new Trabajador(0, id, nombre, departamento);
			int n = bo.saveBO(ti);
			
			model.addAttribute("message", "Se ha insertado " + n + "elemento.");
			
			List<Trabajador> listTr = bo.getAllBO();
			model.addAttribute("trabajadores", listTr);
			
			return "listadoTrabajadores";
			
		} catch (RuntimeException e) {

			model.addAttribute("error", e.getMessage());
			return "error";
		}
		
		
	}
	
}
