package Tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Models.Carta;
import Models.Jugador;
import Juego.JuegoNormal;


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

	@Test
	void testCheckManoJug() {
		ArrayList<Carta> manoCartas = new ArrayList<>();
		manoCartas.clear();
		if (listaJugadores.size() == 0){
			System.out.println("ListaJugadores es una lista vacia.");			
		} else {
			System.out.println("ListaJugadores no es vacia.");
		}
	}

}
