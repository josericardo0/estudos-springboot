package com.projeto.webapp.spring.pratica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("controller")
public class PraticaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PraticaApplication.class, args);
	}

}
