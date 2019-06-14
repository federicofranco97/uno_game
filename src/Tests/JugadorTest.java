package Tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Models.Jugador;

class JugadorTest {
	
	Jugador jugador;

	@BeforeEach
	void setUp() {
		jugador = new Jugador("Alex","alex");
	}	

	@Test
	void crearJugador() throws Exception {
		assertEquals("Alex", jugador.getNombre());
		assertNotEquals("alex", jugador.getNombre());		
		assertEquals("alex", jugador.getClave());
		assertNotEquals("Alex", jugador.getClave());
	}

}
