package Pruebas;

import Models.Juego;
import Models.Mazo;

public class TestClass {
    
    public static void main(String[] args) {
   
        Juego juego = new Juego();
        juego.llenarMazos();
        juego.llenarJugadores();
       
        juego.getListaJugadores().get(0).imprimirMano();
        
        
        
    }
}
