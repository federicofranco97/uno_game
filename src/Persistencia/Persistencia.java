package Persistencia;


import Models.Jugador;
import Models.Mazo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fede
 */
public class Persistencia {
    File archivo=new File("Partida.txt");
    ArrayList<String> kdena = new ArrayList<>();
    ArrayList<Jugador> listaJugadores = new ArrayList<>();
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
                String aux1="";
                String aux2="";
                listaJugadores.add(new Jugador(aux1 ,aux2));
            }
        }
    }
    
    public static void main(String[] args) {
        Persistencia persistencia = new Persistencia();
        persistencia.leerArchivo();
        persistencia.agregarJugadores();
        
        
    }//fin main
    
}
