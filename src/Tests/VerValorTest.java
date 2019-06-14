package Tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Models.Carta;
import Juego.JuegoNormal;

class VerValorTest {
	
	Carta carta;	

	@BeforeEach
	void setUp() {
		carta = new Carta ("verde", "número", "3");
	}

	@Test
	void testVerValor() {	
		JuegoNormal.verValor(carta);
	}

}
