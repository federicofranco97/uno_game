package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Juego.JuegoNormal;
import Models.Carta;

class VerificarEspecialTest {
	
	Carta c;

	@BeforeEach
	void setUp() throws Exception {
		c = new Carta ("verde", "número", "3");
	}

	@Test
	void testVerificarEspecial() {
		
	}

}
