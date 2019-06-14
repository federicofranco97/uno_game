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
import org.junit.jupiter.api.Test;

import Juego.JuegoNormal;
import Models.Carta;
import Models.Jugador;
import Models.Mazo;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlexsTest {

	Jugador jugador;
	Jugador j1;
    Mazo mazo;
    JuegoNormal juego;
    ArrayList<Mazo> listaMazos;
    Carta carta;
    Carta c;
    List<Jugador>listaJugadores;
	
    

	@BeforeEach
	void setUp1() {
	    j1 = new Jugador ("Alex", "al");
	    listaJugadores = new ArrayList<>();
	    listaJugadores.addAll(Arrays.asList(j1));	    
	}
	
	/*Se verifica que una vez que la mano sea una mano vacia, el jugador sea borrado de la lista de jugadores*/

	@Test
	void testCheckManoJug() {
		ArrayList<Carta> manoCartas = new ArrayList<>();
		manoCartas.clear();
		assertFalse(JuegoNormal.listaJugadores.isEmpty());
	}
	
	
	@BeforeEach
	void setUp2() {
		jugador = new Jugador("Alex","alex");
	}	

	@Test
	void crearJugador() throws Exception {
		assertEquals("Alex", jugador.getNombre());
		assertNotEquals("alex", jugador.getNombre());		
		assertEquals("alex", jugador.getClave());
		assertNotEquals("Alex", jugador.getClave());
	}
	
	
	@BeforeEach
	void setUp3(){		
		c = new Carta ("verde", "número", "3");
	}

	@Test
	void testVerTipo() {
		assertEquals(5, juego.verValor(c));
	}
	
	
	@BeforeEach
	void setUp4() {
		carta = new Carta ("verde", "número", "3");
	}

	@Test
	void testVerValor() {	
		assertEquals(3,juego.verValor(carta));
	}
	
	
	/*@BeforeEach
	void setUp5() throws Exception {
		c = new Carta ("verde", "especial", "skip");
	}

	@Test
	void testVerificarEspecial() {
		assertFalse(juego.aplicarCartaEspecial(c),juego.verificarEspecial(c));
	}*/
	

}
