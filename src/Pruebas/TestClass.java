package Pruebas;

import Juego.Juego;
import Models.Mazo;

public class TestClass {
    
    public static void main(String[] args) {
   
        Juego juego = new Juego();
        juego.llenarMazos();
        juego.llenarJugadores();
        
        /*
        Se genera una carta numerica random en el pozo, y un jugador genera una carta random y se valida 
        si la carta del jugador es compatible con la carta del pozo. Si es asi la carta del pozo pasa a ser
        la carta que tiro el jugador.
        */
        juego.primerCartaPozo();
        juego.turnoJugador(juego.getListaJugadores().get(0));
        
        
        
    }
}
