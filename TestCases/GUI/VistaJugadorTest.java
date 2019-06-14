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
    VistaJugador vistaJugador;

    @BeforeEach
    void setUp() {
        mazo = new Mazo();
        juego = new JuegoNormal();
        listaMazos = new ArrayList<>();
        juego.setRondaHoraria(true);
        carta = new Carta("rojo", "número", "9");
        juego.setIsValid(true);
        listaJugadores = new ArrayList<>();
        jugador1 = new Jugador("jugador 1", "123");
        jugador2 = new Jugador("jugador 2", "456");
        jugador3 = new Jugador("jugador 3", "789");
        listaJugadores.addAll(Arrays.asList(jugador1, jugador2, jugador3));
        juego.llenarMazos();
        jugador1.setManoCartas(juego.generarMano());
        jugador2.setManoCartas(juego.generarMano());
        jugador3.setManoCartas(juego.generarMano());
        juego.getListaJugadores().addAll(listaJugadores);
        juego.setJugadorFocus(0);
        vistaJugador = new VistaJugador();


    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void incrementarFocusTest(){
       Assertions.assertEquals(0, juego.getJugadorFocus());
       vistaJugador.incrementFocus();
       Assertions.assertEquals(1, juego.getJugadorFocus());
    }

    @Test
    void asignarNombreTest(){
        vistaJugador.asignarNombre();
        Assertions.assertEquals("jugador 1", vistaJugador.getLblNombre().getText());
        vistaJugador.incrementFocus();
        vistaJugador.asignarNombre();
        Assertions.assertEquals("jugador 2", vistaJugador.getLblNombre().getText());
    }

    @Test
    void asignarPozoTest (){
        vistaJugador.asignarPozo(carta);
        Assertions.assertEquals(carta, juego.getPozo());
        Assertions.assertEquals(carta.getColor(), juego.getPozo().getColor());
        Assertions.assertEquals(carta.getValor(), juego.getPozo().getValor());
        Assertions.assertEquals(carta.getTipo(), juego.getPozo().getTipo());
    }










}