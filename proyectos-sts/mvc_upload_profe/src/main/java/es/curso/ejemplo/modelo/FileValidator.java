package es.curso.ejemplo.modelo;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class FileValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {		
		return File.class.equals(clazz);
	}
	@Override
	public void validate(Object obj, Errors errors) {
		File file = (File) obj;		
		if (file.getFile().getSize() == 0)
			errors.rejectValue("file", "valid.file",
					"No has seleccionado un fichero ...");		
	}
}
