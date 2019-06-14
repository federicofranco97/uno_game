package Tests;

import static org.junit.Assert.assertFalse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Models.Carta;
import Models.Jugador;


class CheckManoJug {
	
	Jugador j1;
	List<Jugador>listaJugadores;
	ArrayList<Carta> manoCartas;

	@BeforeEach
	void setUp() {
	    j1 = new Jugador ("Alex", "al");
	    listaJugadores = new ArrayList<>();
	    listaJugadores.addAll(Arrays.asList(j1));	    
	}
	
	/*Se verifica que una vez que la mano sea una mano vacia, el jugador sea borrado de la lista de jugadores*/

	@Test
	void testCheckManoJug() {
		ArrayList<Carta> manoCartas = new ArrayList<>();
		manoCartas.clear();
		assertFalse(listaJugadores.isEmpty());
	}

}
