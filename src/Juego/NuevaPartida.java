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
        juego.llenarMazos();
        //juego.llenarJugadores();
        //juego.cargarData();
        juego.primerCartaPozo();
        juego.mensajeEntrada();           
        juego.preguntarJugadores();
//        juego.jugTrucado();
        juego.preguntarMovida(juego.getListaJugadores().get(juego.getJugadorFocus()));   
    }
    
}
