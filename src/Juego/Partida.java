package Juego;

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
        juego.cargarData();
        juego.primerCartaPozo();
        juego.mensajeEntrada();           
        //juego.preguntarJugadores();
        //juego.preguntarMovida(juego.getListaJugadores().get(juego.getJugadorFocus()));
        juego.preguntarMovida();
    }
    
    public static void main(String[] args) {
        Partida partida = new Partida();
    }

}
