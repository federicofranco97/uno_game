package Juego;

import Models.Carta;
import Models.Jugador;
import Models.Mazo;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class Juego {
    
    private ArrayList<Jugador>listaJugadores=new ArrayList<>();
    private ArrayList<Mazo>listaMazos=new ArrayList<>();
    private int jugadorFocus=0;
    private boolean rondaHoraria=true;
    private Carta pozo= new Carta();

    public Juego() {}
    
    
   /*
    Crea el mazo principal del juego y uno de respaldo. Los dos se añaden a la lista
    de mazos
    */
    public void llenarMazos(){
        Mazo mazoPrincipal = new Mazo();
        Mazo mazoSecundario = mazoPrincipal;
        listaMazos.addAll(Arrays.asList(mazoPrincipal,mazoSecundario));
    }
    
    /*
    Crea algunos jugadores y les asigna una mano de cartas.
    */
    public void llenarJugadores(){
        Jugador jugador = new Jugador("Jugador1");
        jugador.setManoCartas(generarMano());
        Jugador jugador2 = new Jugador("Jugador2");
        jugador2.setManoCartas(generarMano());
        Jugador jugador3 = new Jugador("Jugador3");
        jugador3.setManoCartas(generarMano());
        listaJugadores.addAll(Arrays.asList(jugador,jugador2,jugador3));
    }

    /*
    Devuelve la lista con los jugadores
    */
    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    /*
    Devuelve la lista con los 2 mazos
    */
    public ArrayList<Mazo> getListaMazos() {
        return listaMazos;
    }

    /*
    Devuelve el numero de jugador que esta en juego
    */
    public int getJugadorFocus() {
        return jugadorFocus;
    }
    
    /*
    Devuelve la mano de un jugador (7cartas) aleatorias
    */
    public ArrayList<Carta> generarMano(){
        ArrayList<Carta>mano=new ArrayList<>();
        Mazo mazo = listaMazos.get(0);
        for(int i=0;i<7;i++){
            int random= (int)(Math.random()*mazo.getMazoPrincipal().size());
            mano.add(mazo.getMazoPrincipal().get(random));
        }
        
        return mano;
    }
    
    
    /*
    Elige una carta aleatoria del mazo, que no sea una carta especial, y la saca del
    mazo una vez que se tira.
    */
    public void primerCartaPozo(){
        listaMazos.get(0).mezclarMazo();
        for(int i=0;i<listaMazos.get(0).getMazoPrincipal().size();i++){
            Carta c = listaMazos.get(0).getMazoPrincipal().get(i);
            if(!"especial".equals(c.getTipo())){
                pozo.setColor(c.getColor());
                pozo.setTipo(c.getTipo());
                pozo.setValor(c.getValor());
                listaMazos.get(0).removeCarta(i);
            }
        }
        
    }
    
    /*
    Trae una carta aleatoria de la mano del jugador.
    */
    public Carta generarCarta(Jugador j){
        int random = (int)(Math.random()*j.getManoCartas().size());
        Carta cartaJugada=j.getManoCartas().get(random);
        return cartaJugada;
    }
    
    
    /*
    Asigna como jugador que esta jugando a la posicion de j en el array. Valida la carta que tira el jugador
    contra la carta que esta en el pozo. Y aplica las consecuencias si la carta es especial.
    Y saca la carta de la mano del jugador, siempre que la jugada haya sido valida.
    */
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
            j.removeCarta(j.getManoCartas().indexOf(cartaJugada));
        }else{
            System.out.println("Jugada no valida!");
            System.out.print("\n");
            System.out.println("Pozo:"+pozo.getValor()+" "+pozo.getTipo()+" "+pozo.getColor());
            System.out.println("Carta tirada: "+cartaJugada.getValor()+" "+cartaJugada.getTipo()+" "+cartaJugada.getColor());
        }
        
        aplicarCartaEspecial(pozo);
    
    }
    
    /*
    Checkea si el mazo principal esta vacio, si lo esta lo rellena usando el refil
    */
    public void checkMazoVacio(){
        if(listaMazos.get(0).getMazoPrincipal().isEmpty()){
            refillMazo();
        }
    }
    
    /*l
    Toma el mazo secundario, lo mezcla y agrega al mazo principal todas las cartas ya mezcladas
    */
    public void refillMazo(){
        listaMazos.get(1).mezclarMazo();
        listaMazos.get(0).getMazoPrincipal().addAll(listaMazos.get(1).getMazoPrincipal());
    }
    
    /*
    Accion a tomar en el turno
    (Falta implementar)
    */
    public void preguntarMovida(Jugador j){
        String msj="1-Tirar carta\n2-Levantar carta del mazo\n3-Pasar turno";
        int opcion=Integer.parseInt(JOptionPane.showInputDialog(msj));
        switch(opcion){
            case(1):break;
            case(2):
                levantarCartaMazo(j);
                break;
            case(3):break;
            
        }
    }
    
    /*
    Toma una carta aleatoria del mazo y la agrega a la mano del jugador
    */
    public void levantarCartaMazo(Jugador j){
        checkMazoVacio();
        int numeroRandom = (int) (Math.random() * listaMazos.get(0).getMazoPrincipal().size());
        j.getManoCartas().add(listaMazos.get(0).getMazoPrincipal().get(numeroRandom));
        listaMazos.get(0).removeCarta(listaMazos.get(0).getMazoPrincipal().indexOf(numeroRandom));
    }
    
    /*
    Metodo que calcula quien es el siguiente jugador
    (A mejorar el codigo, pero funciona)
    */
    public Jugador nextPlayer(){
        int lastPlayer=jugadorFocus;
        int nextPlayer;
        if(rondaHoraria){
            if(lastPlayer==listaJugadores.size()-1){
                nextPlayer=0;
            }else{
                nextPlayer=lastPlayer+1;
            }
        }else{
            if(lastPlayer==0){
                nextPlayer=listaJugadores.size()-1;
            }else{
                nextPlayer=lastPlayer-1;
            }
        }
        return listaJugadores.get(nextPlayer);
    }
    /*
    Falta implementar
    Metodo que toma la carta especial, y lleva a cabo la accion que trae la carta.
    +2---> funciona
    +4---> suma las 4  cartas pero falta resolver el tema del cambio de color.
    skip--->
    spin--->cambia el sentido de la ronda, falta implementar que le pregunte al siguiente jugador que accion quiere tomar
    */
    public void aplicarCartaEspecial(Carta c){
        checkMazoVacio();
        String tipoCarta= c.getTipo();
        String valorCarta= c.getValor();
        if(tipoCarta.equals("numero"))return;
        
        switch(valorCarta){
            
            case("+2"):                
                int numeroRandom = (int)(Math.random()*listaMazos.get(0).getMazoPrincipal().size());
                Carta ca1= listaMazos.get(0).getMazoPrincipal().get(numeroRandom);
                int numeroRandom2 = (int)(Math.random()*listaMazos.get(0).getMazoPrincipal().size()-1);
                Carta ca2= listaMazos.get(0).getMazoPrincipal().get(numeroRandom2);
                nextPlayer().addCartas(Arrays.asList(ca1,ca2));
                listaMazos.get(0).removeCartas(Arrays.asList(ca1,ca2));                
                break;
            
            case("+4"):
                int n1 = (int)(Math.random()*listaMazos.get(0).getMazoPrincipal().size());
                Carta c1= listaMazos.get(0).getMazoPrincipal().get(n1);
                int n2 = (int)(Math.random()*listaMazos.get(0).getMazoPrincipal().size());
                Carta c2= listaMazos.get(0).getMazoPrincipal().get(n2);
                int n3 = (int)(Math.random()*listaMazos.get(0).getMazoPrincipal().size());
                Carta c3= listaMazos.get(0).getMazoPrincipal().get(n3);
                int n4 = (int)(Math.random()*listaMazos.get(0).getMazoPrincipal().size());
                Carta c4= listaMazos.get(0).getMazoPrincipal().get(n4);
                nextPlayer().addCartas(Arrays.asList(c1,c2,c3,c4));
                listaMazos.get(0).removeCartas(Arrays.asList(c1,c2,c3,c4));
                break;
            case("skip"):
                
                break;
            
            case("spin"):
                rondaHoraria=!rondaHoraria;
                //Preguntar al siguiente jugador.
                break;
            
            case("color"):
                break;
            
        }   
    }
    
    
    
    
}
