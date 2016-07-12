package es.curso.spring;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class Main {

	public static void main(String[] args) {
		ExpressionParser parser = new SpelExpressionParser();
		
		Expression exp = parser.parseExpression("'Hello World'.concat('!')");		
		String mensaje = (String) exp.getValue();
		System.out.println(mensaje);
		
		exp = parser.parseExpression("3+9");
		int val = (Integer) exp.getValue();
		System.out.println(val);
		
		Usuario usuario = new Usuario("Jose Gonzalez");
		EvaluationContext contexto = new StandardEvaluationContext(usuario);
		
		Expression expresion = parser.parseExpression("nombre");
		String nombreUsuario = expresion.getValue(contexto, String.class);
		System.out.println(nombreUsuario);
		
		
	}

}
