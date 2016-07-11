package es.curso.coche;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean
	public Radio getRadio() {
		return new Radio();
	}
	
	@Bean
	public Motor getMotor() {
		return new Motor();
	}
	
	@Bean
	public Coche getCoche() {
		return new Coche();
	}
}
