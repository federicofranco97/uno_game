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
        juego.llenarMazos();
        juego.llenarJugadores();
        juego.primerCartaPozo();
        System.out.println(juego.getListaMazos().get(0).getMazoPrincipal().size());
        //juego.preguntarJugadores();
        juego.preguntarMovida(juego.getListaJugadores().get(juego.getJugadorFocus()));
    }
    
    public static void main(String[] args) {
        Partida partida = new Partida();
    }

}
