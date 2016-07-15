package es.curso.ejemplo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import es.curso.ejemplo.modelo.File;
import es.curso.ejemplo.modelo.FileValidator;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/file.htm")
public class HomeController {

	@Autowired
	FileValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getForm(Model model) {
		File fileModel = new File();
		model.addAttribute("file", fileModel);
		return "file";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String fileUploaded(Model model, @Validated File file, BindingResult result) {
		String returnVal = "successFile";
		if (result.hasErrors()) {
			returnVal = "file";
		} else {
			MultipartFile multipartFile = file.getFile();
			try {
				System.out.println(multipartFile.getBytes().length);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return returnVal;
	}
}
