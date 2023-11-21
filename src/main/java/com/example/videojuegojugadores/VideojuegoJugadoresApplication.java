package com.example.videojuegojugadores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@SpringBootApplication
public class VideojuegoJugadoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideojuegoJugadoresApplication.class, args);
	}

}
