package Pruebas;

import Juego.Juego;
import Models.Carta;
import Models.Mazo;

public class PruebaUno {
    
    public static void main(String[] args) {
   
        Juego juego = new Juego();
        juego.llenarMazos();
        juego.llenarJugadores();
        juego.primerCartaPozo();
        Carta carta = new Carta("especial", "+2");
        juego.aplicarCartaEspecial(carta);
        juego.getListaJugadores().get(1).imprimirMano();
        System.out.println("\n");
        juego.turnoJugador(juego.getListaJugadores().get(0));
        
        
    }
}
