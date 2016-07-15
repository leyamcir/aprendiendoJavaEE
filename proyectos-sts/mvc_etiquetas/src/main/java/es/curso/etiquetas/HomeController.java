package es.curso.etiquetas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.curso.etiquetas.beans.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@ModelAttribute("user")
	public User init() {
		// Init back bean for view
		User user = new User();
		user.setAddress("Gran via");
		user.setSex('M');
		user.setCountry("Spain");
		return user;
	}
	
	@ModelAttribute("frameworks")
	public List<String> initFrameworks() {
		List<String> frameworks = new ArrayList<String>();
		
		frameworks.add("Spring MVC");
		frameworks.add("JSF");
		frameworks.add("Struts");
		frameworks.add("Hibernate");
		
		return frameworks;
	}
	
	@ModelAttribute("genders")
	public Map<Character,String> initGenders(){
		Map<Character,String> map = new HashMap<Character, String>();
		map.put('M', "Male");
		map.put('F', "Female");
		return map;
	}
	
	@ModelAttribute("numbers")
	public Map<Integer,String> initNumbers(){
		Map<Integer,String> map = new TreeMap<Integer, String>();
		for (int i = 1; i <= 5; i++) {
			map.put(i, "Number "+i);
		}
		return map;
	}
	
	@ModelAttribute("countries")
	public Map<String,String> initCountries(){
		Map<String,String> list = new TreeMap<String,String>();
		list.put("FR", "France");
		list.put("GR", "Germany");
		list.put("HL", "Holland");
		list.put("ES", "Spain");
		return list;
	}
	
	@ModelAttribute("skillOptionList")
	public List<String> initJavaSkills(){
		List<String> list = new ArrayList<String>();
		list.add("Hibernate");
		list.add("Spring");
		list.add("Apache Wicket");
		list.add("Struts");
		return list;
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/process", method = RequestMethod.POST)
	public String process(User user, Model model) {
		// Get form filled bean 
		// and send it to result view
		model.addAttribute("user", user);
		return "results";
	}
	
}
