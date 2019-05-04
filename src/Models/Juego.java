package Models;

import java.util.ArrayList;
import java.util.Arrays;

public class Juego {
    
    private ArrayList<Jugador>listaJugadores=new ArrayList<>();
    private ArrayList<Mazo>listaMazos=new ArrayList<>();
    private int jugadorFocus;
   
    public void llenarMazos(){
        Mazo mazoPrincipal = new Mazo();
        Mazo mazoSecundario = new Mazo();
        Mazo mazoRespaldo = new Mazo();
        listaMazos.addAll(Arrays.asList(mazoPrincipal,mazoRespaldo,mazoSecundario));
    }
    
    public void aplicarCartaEspecial(Jugador j,Carta c){
        String tipoCarta= c.getTipo();
        String valorCarta= c.getValor();
        if(tipoCarta.equals("numero"))return;
        
        switch(tipoCarta){
            
            case("+2"):
                int numeroRandom = (int)(Math.random());
                return;
            
            case("+4"):return;
            
            case("cambio"):return;
            
        }
    }
    
}
