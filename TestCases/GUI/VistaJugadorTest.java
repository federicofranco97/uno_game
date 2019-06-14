package GUI;

import Juego.JuegoNormal;
import Models.Carta;
import Models.Jugador;
import Models.Mazo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VistaJugadorTest {

    Mazo mazo;
    JuegoNormal juego;
    ArrayList<Mazo> listaMazos;
    Carta carta;
    List<Jugador> listaJugadores;
    Jugador jugador1;
    Jugador jugador2;
    Jugador jugador3;

    @BeforeEach
    void setUp() {
        mazo = new Mazo();
        juego = new JuegoNormal();
        listaMazos = new ArrayList<>();
        juego.setRondaHoraria(true);
        juego.setJugadorFocus(0);
        carta = new Carta();
        juego.setIsValid(true);
        listaJugadores = new ArrayList<>();
        jugador1 = new Jugador("jugador 1", "123");
        jugador2 = new Jugador("jugador 2", "456");
        jugador3 = new Jugador("jugador 3", "789");
        listaJugadores.addAll(Arrays.asList(jugador1, jugador2, jugador3));
        juego.llenarMazos();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void incrementarFocusTest(){
       Assertions.assertEquals(0, juego.getJugadorFocus());
       juego.incrementFocus();
       Assertions.assertEquals(1, juego.getJugadorFocus());
    }




}