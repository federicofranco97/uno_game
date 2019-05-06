package Pruebas;

import Juego.Juego;
import Models.Carta;
import Models.Mazo;

public class TestClass {
    
    public static void main(String[] args) {
   
        Juego juego = new Juego();
        juego.llenarMazos();
        juego.llenarJugadores();
        Carta carta = new Carta("especial", "+4");
        juego.aplicarCartaEspecial(carta);
        juego.getListaJugadores().get(1).imprimirMano();
        
        
    }
}
