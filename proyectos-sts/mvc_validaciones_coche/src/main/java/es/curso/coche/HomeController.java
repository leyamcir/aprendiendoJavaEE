package es.curso.coche;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.curso.coche.modelo.Coche;
import es.curso.coche.modelo.CocheValidator;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model) {		
		
		return new ModelAndView("home", "coche", new Coche());
	}
	
	@InitBinder
	public void registerValidator(WebDataBinder bind) {
		// Registrar el validador en el controller
		bind.setValidator(new CocheValidator());
	}
	
	@RequestMapping(value = "/procesar", method = RequestMethod.POST)
	public String procesar(@Validated Coche coche, BindingResult errors, Model model) {		
		if(errors.hasErrors()){
			// Hay errores, nos quedamos en el mismo form
			return "home";
		} else {
			model.addAttribute("coche", coche);
			return "result";
		}
	}
}
