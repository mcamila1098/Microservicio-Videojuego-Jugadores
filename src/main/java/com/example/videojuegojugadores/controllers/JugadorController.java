package com.example.videojuegojugadores.controllers;

import com.example.videojuegojugadores.models.Jugador;
import com.example.videojuegojugadores.services.JugadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/jugadores")
@Tag(name = "Jugadores", description = "Operaciones sobre los jugadores de la aplicación VideoJuego")
public class JugadorController {

    private final JugadorService jugadorService;

    @PostMapping("")
    @Operation(summary = "Crear un nuevo jugador", description = "Permite crear un nuevo jugador")
    @ApiResponse(responseCode = "200", description = "Jugador Creado",
            content = @Content(schema = @Schema(implementation = Jugador.class)))
    public Jugador saveJugador(Jugador jugador) {
        return jugadorService.saveJugador(jugador);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar jugador por Id", description = "Permite buscar un jugador por Id")
    public Jugador getJugadorById(String id) {
        return jugadorService.getJugadorById(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar jugador por Id", description = "Permite eliminar un jugador por Id")
    @ResponseBody
    public ResponseEntity<String> deleteJugador(@PathVariable String id){
        try{
            return new ResponseEntity<>(jugadorService.deleteJugador(id), HttpStatus.NO_CONTENT);
        } catch (ResponseStatusException ex) {
            return new ResponseEntity<>(ex.getStatusCode());
        }
    }

    @GetMapping("")
    @Operation(summary = "Buscar todos los jugadores", description = "Permite obtener el listado de todos los jugadores")
    @ApiResponse(responseCode = "200", description = "Jugadores encontrados")
    public List<Jugador> getAllJugadores() {return jugadorService.getAllJugadores();}

    @PutMapping("")
    @Operation(summary = "Actualizar data de un jugador", description = "Permite actualizar datos de un jugador")
    @ApiResponse(responseCode = "200", description = "Jugador actualizado",
            content = @Content(schema = @Schema(implementation = Jugador.class)))
    public Jugador updateJugador(@RequestBody Jugador jugador) {return jugadorService.updateJugador(jugador);}

    @GetMapping("/findByEmail/{email}")
    @Operation(summary = "Buscar jugadores por su correo electrónico", description = "Permite obtener jugadores por correo electrónico")
    @Parameter(name = "Correo del jugador a buscar")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Jugadores que contienen el correo electrónico dado",
                        content = @Content(schema = @Schema(implementation = Jugador.class)))
    })
    public List<Jugador> findJugadoresByEmail(@PathVariable String email){
        return jugadorService.getJugadoresContainsEmail(email);
    }

}
