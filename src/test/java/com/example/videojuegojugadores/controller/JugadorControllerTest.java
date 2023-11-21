package com.example.videojuegojugadores.controller;

import com.example.videojuegojugadores.controllers.JugadorController;
import com.example.videojuegojugadores.models.Jugador;
import com.example.videojuegojugadores.services.JugadorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class JugadorControllerTest {

    @Mock
    private JugadorService jugadorService;

    @InjectMocks
    private JugadorController jugadorController;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testConsultarJugadoresExitoso(){
        Jugador jugadorEsperado1 = new Jugador("Catpuccino #Purple3", "Maria Camila", "Alvarez Perdomo", "mcap21@hotmail.com", "Catpuccino", "hola12345");
        Jugador jugadorEsperado2 = new Jugador("C9Shuro #C9", "Nicolas", "Olave Portilla", "nop2906@gmail.com", "C9Shuro", "adios12345");
        List<Jugador> jugadoresEsperados = new ArrayList<>();
        jugadoresEsperados.add(jugadorEsperado1);
        jugadoresEsperados.add(jugadorEsperado2);
        when(jugadorService.getAllJugadores()).thenReturn(jugadoresEsperados);

        List<Jugador> resultado = jugadorController.getAllJugadores();
        assertEquals(jugadoresEsperados, resultado);
    }


}
