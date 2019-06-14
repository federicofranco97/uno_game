package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Juego.JuegoNormal;
import Models.Carta;

class VerTipoTest {
	
	Carta c;
	JuegoNormal juego;

	@BeforeEach
	void setUp(){		
		c = new Carta ("verde", "número", "3");
	}

	@Test
	void testVerTipo() {
		assertEquals(5, juego.verValor(c));
	}

}
