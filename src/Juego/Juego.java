package Juego;

import Models.Carta;
import Models.Jugador;
import Models.Mazo;
import java.util.ArrayList;
import java.util.Arrays;

public class Juego {
    
    private ArrayList<Jugador>listaJugadores=new ArrayList<>();
    private ArrayList<Mazo>listaMazos=new ArrayList<>();
    private int jugadorFocus;
    private boolean rondaHoraria=true;
    private Carta pozo= new Carta();

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
        for(int i=0;i<7;i++){
            int random= (int)(Math.random()*mazo.getMazoPrincipal().size());
            mano.add(mazo.getMazoPrincipal().get(random));
        }
        
        return mano;
    }
    
    public void primerCartaPozo(){
        listaMazos.get(0).mezclarMazo();
        for(int i=0;i<listaMazos.get(0).getMazoPrincipal().size();i++){
            Carta c = listaMazos.get(0).getMazoPrincipal().get(i);
            if(!"especial".equals(c.getTipo())){
                pozo.setColor(c.getColor());
                pozo.setTipo(c.getTipo());
                pozo.setValor(c.getValor());
            }
        }
    }
    
    public Carta generarCarta(Jugador j){
        int random = (int)(Math.random()*j.getManoCartas().size());
        Carta cartaJugada=j.getManoCartas().get(random);
        return cartaJugada;
    }
    
    public void turnoJugador(Jugador j){
        jugadorFocus=listaJugadores.indexOf(j);
        Carta cartaJugada = generarCarta(j);
        if(pozo.validarCarta(cartaJugada)){
            System.out.println("Jugada exitosa!");
            System.out.print("\n");
            System.out.println("Pozo:"+pozo.getValor()+" "+pozo.getTipo()+" "+pozo.getColor());
            System.out.println("Carta tirada: "+cartaJugada.getValor()+" "+cartaJugada.getTipo()+" "+cartaJugada.getColor());
            pozo.setValor(cartaJugada.getValor());
            if(cartaJugada.getTipo().equals("especial")){
                pozo.setTipo("especial");
            }else{
                pozo.setTipo("numero");
                pozo.setColor(cartaJugada.getColor());
            }
        }else{
            System.out.println("Jugada no valida!");
            System.out.print("\n");
            System.out.println("Pozo:"+pozo.getValor()+" "+pozo.getTipo()+" "+pozo.getColor());
            System.out.println("Carta tirada: "+cartaJugada.getValor()+" "+cartaJugada.getTipo()+" "+cartaJugada.getColor());
        }
        
        aplicarCartaEspecial(pozo);
    
    }
    
    public void checkMazoVacio(){
        if(listaMazos.get(0).getMazoPrincipal().isEmpty()){
            refillMazo();
        }
    }
    
    public void refillMazo(){
        listaMazos.get(1).mezclarMazo();
        listaMazos.get(0).getMazoPrincipal().addAll(listaMazos.get(1).getMazoPrincipal());
    }
    
    public void levantarCartaMazo(Jugador j){
        checkMazoVacio();
        int numeroRandom = (int) (Math.random() * listaMazos.get(0).getMazoPrincipal().size());
        
    }
    
    /*
    Falta implementar
    */
    public void aplicarCartaEspecial(Carta c){
        checkMazoVacio();
        String tipoCarta= c.getTipo();
        String valorCarta= c.getValor();
        if(tipoCarta.equals("numero"))return;
        
        switch(tipoCarta){
            
            case("+2"):                
                int numeroRandom = (int)(Math.random()*listaMazos.get(0).getMazoPrincipal().size());
                int numeroRandom2 = (int)(Math.random()*listaMazos.get(0).getMazoPrincipal().size());
                break;
            
            case("+4"):break;
            
            case("skip"):break;
            
            case("spin"):
                rondaHoraria=!rondaHoraria;
                break;
            
        }   
    }
    
    
    
    
}
