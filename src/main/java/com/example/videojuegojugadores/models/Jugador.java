package com.example.videojuegojugadores.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "jugadores")
@Schema(description = "Jugador general que accede a la solución de VideoJuego")
public class Jugador {
    @Id
    @jakarta.persistence.Id
    @Schema(description = "Id unico del jugador", example = "PhoenixMan #4Lyfe" )
    protected String id;
    @Schema(description = "Nombres del jugador", example = "Mario")
    protected String nombres;
    @Schema(description = "Apellidos del jugador", example = "Rojas")
    protected String apellidos;
    @Schema(description = "Correo del jugador", example = "mrojas88@hotmail.com")
    protected String email;
    @Schema(description = "Nick del jugador en el juego", example = "PhoenixMan")
    protected String nickUsuario;
    @Schema(description = "Contraseña del jugador", example = "MRph0e200670/")
    protected String password;
}
