package com.example.videojuegojugadores.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "API para el servicio de Videojuego: Jugadores", version = "1.0",
        description = "API que expone los endpoints para la entidad de Jugador de la solución Videojuego (Servicio de Jugadores)"))
public class SwaggerConfig {
}
