package Persistencia;


import Models.Carta;
import Models.Jugador;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Persistencia {
    private File archivo=new File("Partida.txt");
    private ArrayList<String> kdena = new ArrayList<>();
    private ArrayList<Jugador> listaJugadores = new ArrayList<>();
    private Carta pozo = new Carta();
    private ArrayList<Carta> mazo = new ArrayList<>();
    private int jugadorFocus=1;

    public Persistencia() {}
    
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

    public ArrayList<String> getKdena() {
        return kdena;
    }
    
    public void escribirArchivo(String j,String m){
        //limpiar el fichero
        try {
            
            PrintWriter writer = new PrintWriter(archivo);
            writer.print("");
            writer.close();
        } catch (IOException ex) {}
        
        //reescribir fichero
        try{
            FileWriter escribir = new FileWriter(archivo,true);
            BufferedWriter f = new BufferedWriter(escribir);
            //agrega los jugadores y sus cartas como string
            f.write(j);
            f.newLine();
            f.write(m);
            f.newLine();
                
            
            f.close();
        }catch(IOException e){}
    }
    
    public void agregarData(){
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
                    Carta carta = new Carta(aux2[2], aux2[1], aux2[0]);
                    mazo.add(carta);                    
                }
            }
            
            if(kdena.get(i).equals("FOCUS")){
                jugadorFocus=Integer.parseInt(kdena.get(i+1));
            }            
        }
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
        persistencia.agregarData();
        
        
        
    }//fin main
    
}