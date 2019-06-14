package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Models.Carta;
import Juego.JuegoNormal;

class VerValorTest {
	
	Carta carta;	
	JuegoNormal juego;

	@BeforeEach
	void setUp() {
		carta = new Carta ("verde", "número", "3");
	}

	@Test
	void testVerValor() {	
		assertEquals(3,juego.verValor(carta));
	}

}
