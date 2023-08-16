package com.generation.pruebawebquila;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // Permite JPA Auditing
public class PruebawebquilaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebawebquilaApplication.class, args);
	}

}
