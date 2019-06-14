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
        if(juego.isValid){
            //juego.primerCartaPozo();
            juego.mensajeEntrada();   
            juego.preguntarMovida();
        }else{
            juego.volverMenu();
        }
        
        //juego.preguntarJugadores();
        //juego.preguntarMovida(juego.getListaJugadores().get(juego.getJugadorFocus()));
        
    }
    
    public static void main(String[] args) {
        Partida partida = new Partida();
    }

}
