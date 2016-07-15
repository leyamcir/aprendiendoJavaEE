package es.curso.coche.modelo;

import java.util.Calendar;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CocheValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Coche.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "matricula", 
				"field.matricula.required", "La matrícula es obligatoria");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "modelo", 
				"field.modelo.required", "El modelo es obligatorio");

		Coche c = (Coche) obj;
		int year = Calendar.getInstance().get(Calendar.YEAR);
		
		if(c.getAño()<2000 || c.getAño()> year ){
			errors.rejectValue("año", "field.año.invalid", "El año es incorrecto");
		}
		
		//100.000
		if(c.getKm()>100000 ){
			errors.rejectValue("km", "field.km.invalid", "Los km son incorrectos");
		}
	}

}
