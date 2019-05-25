package Persistencia;


import Models.Carta;
import Models.Jugador;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Persistencia {
    File archivo=new File("Partida.txt");
    ArrayList<String> kdena = new ArrayList<>();
    ArrayList<Jugador> listaJugadores = new ArrayList<>();
    Carta pozo = new Carta();
    ArrayList<Carta> mazo = new ArrayList<>();

    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public Carta getPozo() {
        return pozo;
    }

    public void setPozo(Carta pozo) {
        this.pozo = pozo;
    }

    public ArrayList<Carta> getMazo() {
        return mazo;
    }

    public void setMazo(ArrayList<Carta> mazo) {
        this.mazo = mazo;
    }
    
    public void leerArchivo(){
        try{
           String cadena;            
           FileReader f = new FileReader(archivo);
           BufferedReader b = new BufferedReader(f);
           while((cadena = b.readLine())!=null) {
               kdena.add(cadena);                   
           }
           b.close();  
        }catch(Exception e){
            System.out.println(e);
        }        
    }
    
    public void agregarJugadores(){
        for (int i = 0; i < kdena.size(); i++) {
            if (kdena.get(i).equals("JUGADOR")) {
                Jugador jugador = new Jugador(kdena.get(i+1), kdena.get(i+2));
                String aux1= kdena.get(i+3).replaceAll("-", "");
                String [] cartaLista = aux1.split(",");
                for (String carta : cartaLista) {
                    String [] aux2=carta.split(" ");
                    jugador.addCartas(Arrays.asList(new Carta(aux2[2], aux2[1], aux2[0])));
                }
                listaJugadores.add(jugador);
            }
            if (kdena.get(i).equals("POZO")) {
                String [] aux=kdena.get(i+1).split(" ");
                pozo.setValor(aux[0]);
                pozo.setTipo(aux[1]);
                pozo.setColor(aux[2]);
            }
            
            if(kdena.get(i).equals("MAZO")){
                String [] aux = (kdena.get(i+1).replaceAll("-", "")).split(",");
                for (String string : aux) {
                    String [] aux2=string.split(" ");
                    Carta carta = new Carta(aux2[0], aux2[1], aux2[2]);
                    mazo.add(carta);
                    
                }
            }
            
        }
    }
    
    public void guardarJugador(){
        
    }
    
    public void imprimirMazo(){
        for (Carta carta : mazo) {
            System.out.println(carta.getValor()+" "+carta.getTipo()+" "+carta.getColor());
        }
    }
    
    public void imprimirPozo(){
        System.out.println(pozo.getValor()+" "+pozo.getTipo()+" "+pozo.getColor());
    }
    
    public static void main(String[] args) {
        Persistencia persistencia = new Persistencia();
        persistencia.leerArchivo();
        persistencia.agregarJugadores();
        persistencia.getListaJugadores().get(0).imprimirMano();
        
        
    }//fin main
    
}
