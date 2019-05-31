package Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Mazo {
    private ArrayList<Carta> mazoPrincipal= new ArrayList<>();

    public Mazo() {
     
    }
    
    /*
    Llena el mazo con cartas numericas de los 4 colores mas las cartas especiales
    */
    public void llenarMazo(){
        ArrayList<Carta>numeros=new ArrayList<>();
        ArrayList<Carta>especiales=new ArrayList<>();
        
        /*
        Add cartas numericas
        */
        for(int i=0;i<4;i++){
            String temp="";
            if(i==0)temp=("rojo");
            if(i==1)temp=("azul");
            if(i==2)temp=("verde");
            if(i==3)temp=("amarillo");
            for (int j = 0; j < 10; j++) {
                Carta c = new Carta(temp, "numero", String.valueOf(j));
                numeros.add(c);
            }            
        }
        
        /*
        Add cartas +2, spin, skip
        */
        for(int i=0;i<4;i++){
            String temp="";
            if(i==0)temp=("rojo");
            if(i==1)temp=("azul");
            if(i==2)temp=("verde");
            if(i==3)temp=("amarillo");
            Carta s= new Carta(temp, "especial", "skip");
            Carta s2= new Carta(temp, "especial", "skip");
            Carta t= new Carta(temp, "especial", "spin");
            Carta t2= new Carta(temp, "especial", "spin");
            Carta p= new Carta(temp, "especial", "+2");
            Carta p2= new Carta(temp, "especial", "+2");
            
            especiales.addAll(Arrays.asList(s,s2,t,t2,p,p2));
        }
        /*
        Add cartas especiales +4 / cambio color
        */
        Carta c1= new Carta("joker","especial", "color");
        Carta c2= new Carta("joker","especial", "color");
        Carta c3= new Carta("joker", "especial", "color");
        Carta c4= new Carta("joker", "especial", "color");
        Carta m1= new Carta("joker","especial","+4");
        Carta m2= new Carta("joker","especial","+4");
        Carta m3= new Carta("joker","especial","+4");
        Carta m4= new Carta("joker","especial","+4");
        
        especiales.addAll(Arrays.asList(m1,m2,m3,m4,c1,c2,c3,c4));
        mazoPrincipal.addAll(numeros);
        mazoPrincipal.addAll(numeros);
        mazoPrincipal.addAll(especiales);
        //cartas totales 112
    }   
    
    public void imprimirMazo(){
        for (Carta carta : mazoPrincipal) {
            System.out.println(carta.getTipo()+" "+carta.getValor());
        }
    }
    
    public void mezclarMazo(){
        Collections.shuffle(mazoPrincipal);
    }
    
    public ArrayList<Carta> getMazoPrincipal() {
        return mazoPrincipal;
    }
    
    public void removeCarta(int posicion){
        mazoPrincipal.remove(posicion);
    }
    
    public void removeCartas(Collection<Carta> lista){
        mazoPrincipal.removeAll(lista);
    }
    
    public void agregarCartas(Collection<Carta> lista){
        mazoPrincipal.addAll(lista);
    }

    //Se agrega este método para verificar que el mazo se haya llenado.
    public int tamañoMazo (){
        return mazoPrincipal.size();
    }
    
    public static void main(String[] args) {
        Mazo mazo = new Mazo();
        mazo.llenarMazo();
    }
}
