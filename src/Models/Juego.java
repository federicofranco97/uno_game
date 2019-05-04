package Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Juego {
    
    private ArrayList<Jugador>listaJugadores=new ArrayList<>();
    private ArrayList<Mazo>listaMazos=new ArrayList<>();
    private int jugadorFocus;

    public Juego() {}
    
    
   
    public void llenarMazos(){
        Mazo mazoPrincipal = new Mazo();
        Mazo mazoSecundario = mazoPrincipal;
        listaMazos.addAll(Arrays.asList(mazoPrincipal,mazoSecundario));
    }
    
    public void llenarJugadores(){
        Jugador jugador = new Jugador("Jugador1");
        jugador.setManoCartas(generarMano());
        Jugador jugador2 = new Jugador("Jugador1");
        jugador2.setManoCartas(generarMano());
        Jugador jugador3 = new Jugador("Jugador1");
        jugador3.setManoCartas(generarMano());
        listaJugadores.addAll(Arrays.asList(jugador,jugador2,jugador3));
        jugador.imprimirMano();
    }

    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public ArrayList<Mazo> getListaMazos() {
        return listaMazos;
    }

    public int getJugadorFocus() {
        return jugadorFocus;
    }
    
    
    
    public ArrayList<Carta> generarMano(){
        ArrayList<Carta>mano=new ArrayList<>();
        Mazo mazo = listaMazos.get(0);
        for(int i=0;i<8;i++){
            int random= (int)(Math.random()*mazo.getMazoPrincipal().size());
            mano.add(mazo.getMazoPrincipal().get(random));
        }
        
        return mano;
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
