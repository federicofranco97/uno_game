package Pruebas;

import Juego.JuegoNormal;
import Models.Carta;
import Models.Mazo;

public class PruebaUno {
    
    public static void main(String[] args) {
   
        JuegoNormal juego = new JuegoNormal();
        juego.llenarMazos();
        juego.llenarJugadores();
        juego.primerCartaPozo();
//        Carta carta = new Carta("especial", "+2");
//        juego.getListaJugadores().get(1).imprimirMano();
//        System.out.println("\n");
//        juego.aplicarCartaEspecial(carta);
//        System.out.println("\n");
//        juego.getListaJugadores().get(1).imprimirMano();
//        System.out.println("\n");
//        juego.turnoJugador(juego.getListaJugadores().get(0));
        juego.preguntarMovida(juego.getListaJugadores().get(0));

        
        
    }
}
