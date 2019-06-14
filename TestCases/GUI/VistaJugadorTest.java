package GUI;

import Juego.JuegoNormal;
import Models.Carta;
import Models.Jugador;
import Models.Mazo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VistaJugadorTest {

    Mazo mazo;
    JuegoNormal juego;
    ArrayList<Mazo> listaMazos;
    Carta carta;
    Carta cartaEspecial;
    Carta skip;
    Carta mas4;
    Carta spin;
    Carta cambioColor;
    List<Jugador> listaJugadores;
    Jugador jugador1;
    Jugador jugador2;
    Jugador jugador3;
    VistaJugador vistaJugador;

    @BeforeEach
    void setUp() {
        mazo = new Mazo();
        mazo.llenarMazo();
        juego = new JuegoNormal();
        listaMazos = new ArrayList<>();
        juego.setRondaHoraria(true);
        carta = new Carta("rojo", "numero", "9");
        cartaEspecial = new Carta("verde", "especial", "+2");
        skip = new Carta("azul", "especial", "skip");
        mas4 = new Carta("joker", "especial", "+4");
        spin = new Carta("amarillo", "especial", "spin");
        cambioColor = new Carta("joker", "especial", "color");
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
        juego.setPozo(carta);

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

    @Test
    void verificarEspecialTest(){
        Assertions.assertEquals(0, juego.getJugadorFocus());
        vistaJugador.verificarEspecial(cartaEspecial);
        Assertions.assertEquals(2, juego.getJugadorFocus());
        Assertions.assertEquals(9, jugador2.getManoCartas().size());

        vistaJugador.verificarEspecial(skip);
        Assertions.assertEquals(1, juego.getJugadorFocus());

        vistaJugador.verificarEspecial(spin);
        Assertions.assertEquals(false, juego.isRondaHoraria());
        Assertions.assertEquals(0, juego.getJugadorFocus());

        vistaJugador.verificarEspecial(cambioColor);
        Assertions.assertEquals(2, juego.getJugadorFocus());
        Assertions.assertEquals("verde", juego.getPozo().getColor());

        vistaJugador.verificarEspecial(mas4);
        Assertions.assertEquals(0, juego.getJugadorFocus());
        Assertions.assertEquals(13, jugador2.getManoCartas().size());
        Assertions.assertEquals("azul", juego.getPozo().getColor());
    }

    @Test
    void verValorTest (){
        Assertions.assertEquals(4, vistaJugador.verValor(skip));
        Assertions.assertEquals(7, vistaJugador.verValor(spin));
        Assertions.assertEquals(10, vistaJugador.verValor(cambioColor));
        Assertions.assertEquals(8, vistaJugador.verValor(cartaEspecial));
        Assertions.assertEquals(6, vistaJugador.verValor(mas4));
        Assertions.assertEquals(9, vistaJugador.verValor(carta));
    }

    @Test
    void verTipoTest(){
        Assertions.assertEquals(10, vistaJugador.verTipo(mas4));
        Assertions.assertEquals(10, vistaJugador.verTipo(cartaEspecial));
        Assertions.assertEquals(10, vistaJugador.verTipo(skip));
        Assertions.assertEquals(10, vistaJugador.verTipo(spin));
        Assertions.assertEquals(10, vistaJugador.verTipo(cambioColor));
        Assertions.assertEquals(5, vistaJugador.verTipo(carta));
    }

    @Test
    void verColorTest(){
        Assertions.assertEquals(15, vistaJugador.verColor(carta));
        Assertions.assertEquals(20, vistaJugador.verColor(skip));
        Assertions.assertEquals(10, vistaJugador.verColor(cartaEspecial));
        Assertions.assertEquals(25, vistaJugador.verColor(spin));
        Assertions.assertEquals(5, vistaJugador.verColor(mas4));
        Assertions.assertEquals(5, vistaJugador.verColor(cambioColor));
    }

    @Test
    void checkCantidadCartasTest(){
        juego.getListaMazos().get(0).removerCartas(mazo.getMazoPrincipal());
        Assertions.assertEquals(0, juego.getListaMazos().get(0).getMazoPrincipal().size());
        vistaJugador.checkCantidadCartas(mas4);
        Assertions.assertEquals(108, juego.getListaMazos().get(0).getMazoPrincipal().size());

    }

    @Test
    void asignarValoresTest(){
        ArrayList<Carta> lista = new ArrayList<>(Arrays.asList(carta, cartaEspecial));
        vistaJugador.asignarValores(lista);
        Assertions.assertEquals(899, carta.getCodigo());
        Assertions.assertEquals(868, cartaEspecial.getCodigo());
    }

    @Test
    void cambioColorTest(){
        vistaJugador.cambioColor();
        Assertions.assertEquals("amarillo", juego.getPozo().getColor());
        Assertions.assertEquals(1, juego.getJugadorFocus());
    }

    @Test
    void checkManoJugTest(){
    Jugador jugador4 = new Jugador("jugador 4", "123");
    juego.getListaJugadores().add(jugador4);
    vistaJugador.checkManoJug(jugador4);
    Assertions.assertEquals(3, juego.getListaJugadores().size());
    Assertions.assertEquals(1, juego.getListaGanadores().size());
    }

    @Test
    void checkPerderTest(){
        juego.getListaJugadores().remove(jugador1);
        juego.getListaJugadores().remove(jugador2);
        Assertions.assertTrue(vistaJugador.checkPerder());
        juego.getListaJugadores().add(jugador2);
        Assertions.assertFalse(vistaJugador.checkPerder());
    }

    @Test
    void validarTiroTest(){

        Carta carta2 = new Carta("rojo", "numero", "7" );
        jugador1.getManoCartas().add(carta2);
        Assertions.assertTrue(vistaJugador.validarTiro("7 rojo numero"));
        Assertions.assertEquals(carta2, juego.getPozo());
        Assertions.assertFalse(vistaJugador.validarTiro("9 amarillo numero"));
    }

    @Test
    void checkMazoVacioTest(){
        juego.getListaMazos().get(0).removerCartas(mazo.getMazoPrincipal());
        Assertions.assertEquals(0, juego.getListaMazos().get(0).getMazoPrincipal().size());
        juego.checkMazoVacio();
        Assertions.assertEquals(108, juego.getListaMazos().get(0).getMazoPrincipal().size());
    }

    @Test
    void rellenarMazoTest(){
        juego.getListaMazos().get(0).removerCartas(mazo.getMazoPrincipal());
        Assertions.assertEquals(0, juego.getListaMazos().get(0).getMazoPrincipal().size());
        juego.rellenarMazo();
        Assertions.assertEquals(108, juego.getListaMazos().get(0).getMazoPrincipal().size());
    }

    @Test
    void levantarCartaMazoTest(){
        Jugador jugador4 = new Jugador("jugador 4", "123");
        Carta carta2 = new Carta("amarillo", "numero", "3" );
        jugador4.getManoCartas().add(carta2);
        vistaJugador.levantarCartaMazo(jugador4);
        assertEquals(2, jugador4.getManoCartas().size());
    }


















}