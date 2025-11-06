package co.edu.co.extraclase.initializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages = {"co.edu.co.extraclase"})

@SpringBootApplication
public class ExtraClaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExtraClaseApplication.class, args);
	}
	
}
