package com.example.videojuegojugadores.repositories;

import com.example.videojuegojugadores.models.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, String> {

    List<Jugador> findJugadoresByNombresContainsIgnoreCaseOrApellidosIgnoreCase(String nombres, String apellidos);
    List<Jugador> findJugadoresByEmailContainingIgnoreCase(String email);

}