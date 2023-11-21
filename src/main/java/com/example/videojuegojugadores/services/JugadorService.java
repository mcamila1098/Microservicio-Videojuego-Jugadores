package com.example.videojuegojugadores.services;

import com.example.videojuegojugadores.models.Jugador;
import com.example.videojuegojugadores.repositories.JugadorRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class JugadorService {
    private final JugadorRepository jugadorRepository;

    public Jugador saveJugador(Jugador jugador) {
        try {
            return jugadorRepository.save(jugador);
        } catch (DataAccessException e) {
            log.error("Error al guardar el jugador", e);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al guardar el jugador", e);
        }
    }
    public Jugador getJugadorById(String id) {
        try {
            return jugadorRepository.findById(id).orElse(null);
        } catch (DataAccessException e) {
            log.error("Error al consultar el jugador por id", e);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al guardar el jugador", e);
        }
    }

    public List<Jugador> getAllJugadores() {
        try {
            return jugadorRepository.findAll();
        } catch (DataAccessException e) {
            log.error("Error al buscar todos los jugadores", e);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al buscar todos los jugadores", e);
        }
    }

    public Jugador updateJugador(Jugador jugador) {
        try {
            Jugador existingJugador = jugadorRepository.findById(jugador.getId()).orElse(null);
            Objects.requireNonNull(existingJugador).setNombres(jugador.getNombres());
            Objects.requireNonNull(existingJugador).setApellidos(jugador.getApellidos());
            Objects.requireNonNull(existingJugador).setEmail(jugador.getEmail());
            Objects.requireNonNull(existingJugador).setNickUsuario(jugador.getNickUsuario());
            Objects.requireNonNull(existingJugador).setPassword(jugador.getPassword());
            return jugadorRepository.save(existingJugador);
        } catch (DataAccessException e) {
            log.error("Error al actualizar el jugador", e);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al guardar el jugador", e);
        }
    }

    public String deleteJugador(String id) {
        Optional<Jugador> optionalJugador = jugadorRepository.findById(id);

        if (optionalJugador.isPresent()) {
            Jugador jugador = optionalJugador.get();
            jugadorRepository.deleteById(jugador.getId());
            log.info("El jugador con Id= " + id + " ha sido eliminado");
            return "El jugador con Id= " + id + " ha sido eliminado";
        } else {
            log.error("Jugador con Id=" + id + " no encontrado");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Jugador con Id=" + id + " no encontrado");
        }
    }

    public List<Jugador> getJugadoresContainsEmail(String email) {
        try {
            return jugadorRepository.findJugadoresByEmailContainingIgnoreCase(email);
        } catch (DataAccessException e) {
            log.error("Error al buscar jugadores por email", e);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al guardar el jugador", e);
        }
    }
}
