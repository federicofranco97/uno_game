package Juego;

import javax.swing.*;
import java.io.IOException;

public class Partida {
    /*
    pasos:
    llenar mazos
    llenar jugadores
    primer carta pozo
    preguntar accion para el primer jugador 
    */
    
    public Partida(){
        JuegoNormal juego = new JuegoNormal();
        //juego.llenarMazo2();
        //juego.llenarJugadores();

        try {
            String nombrePartida = JOptionPane.showInputDialog(null, "¿Qué partida quieres reanudar?");
            juego.cargarData(nombrePartida);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //juego.setCartaPozo();
        juego.mensajeEntrada();           
        //juego.preguntarJugadores();
        juego.preguntarMovida(juego.getListaJugadores().get(juego.getJugadorFocus()));
    }
    
    public static void main(String[] args) {
        Partida partida = new Partida();
    }

}
