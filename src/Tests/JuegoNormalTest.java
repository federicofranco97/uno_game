package Tests;

import Models.Carta;
import Models.Jugador;
import Models.Mazo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Juego.JuegoNormal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class JuegoNormalTest {
    Mazo mazo;
    JuegoNormal juego;
    ArrayList<Mazo> listaMazos;
    Carta carta;
    List<Jugador>listaJugadores;
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
    void llenarMazosTest (){
        Mazo mazoPrincipal = mazo;
        mazoPrincipal.llenarMazo();
        Assertions.assertEquals(108, mazoPrincipal.tamañoMazo());

    }

    @Test
    void validarNombreTest (){
       String nombreV = "nombre";
       String nombreIn = " ";
       String nombreIn2 = "  ";

       Assertions.assertEquals(true, juego.validarNombre(nombreV));
       Assertions.assertEquals(false, juego.validarNombre(nombreIn));
       Assertions.assertEquals(false, juego.validarNombre(nombreIn2));

    }

    @Test
    void validarClaveTest (){
        String clave = "1234";
        String claveIn = " ";
        String claveIn2 = "  ";

        Assertions.assertEquals(true, juego.validarNombre(clave));
        Assertions.assertEquals(false, juego.validarNombre(claveIn));
        Assertions.assertEquals(false, juego.validarNombre(claveIn2));

    }

    @Test
    void numeroSiguiente(){

        Assertions.assertEquals(1, juego.numeroSiguiente());
        juego.setRondaHoraria(false);
        Assertions.assertEquals(-1, juego.numeroSiguiente());
        juego.setRondaHoraria(true);
        listaJugadores.remove(jugador1);
        listaJugadores.remove(jugador2);
        Assertions.assertEquals(0, juego.numeroSiguiente());
    }








}