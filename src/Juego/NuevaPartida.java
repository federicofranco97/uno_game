package Juego;

import javax.swing.JOptionPane;

/*
    pasos:
    llenar mazos
    llenar jugadores
    primer carta pozo
    preguntar accion para el primer jugador 
*/
public class NuevaPartida {
  
    public NuevaPartida(){
        JuegoNormal juego = new JuegoNormal();
        juego.llenarMazo2();
        //juego.llenarJugadores();
        //juego.cargarData();
        juego.setCartaPozo();
        juego.mensajeEntrada();           
        juego.preguntarJugadores();
        
        juego.preguntarMovida(juego.getListaJugadores().get(juego.getJugadorFocus()));   
    }
    
}
