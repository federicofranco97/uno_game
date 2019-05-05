package Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Mazo {
    private ArrayList<Carta> mazoPrincipal= new ArrayList<>();

    public Mazo() {
        llenarMazo();
    }

    public void llenarMazo(){
        ArrayList<Carta>numeros=new ArrayList<>();
        ArrayList<Carta>especiales=new ArrayList<>();
        
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
        
        for(int i=0;i<4;i++){
            String temp="";
            if(i==0)temp=("rojo");
            if(i==1)temp=("azul");
            if(i==2)temp=("verde");
            if(i==3)temp=("amarillo");
            Carta s= new Carta(temp, "especial", "skip");
            Carta s2= new Carta(temp, "especial", "skip");
            Carta t= new Carta(temp, "especial", "turn");
            Carta t2= new Carta(temp, "especial", "turn");
            Carta p= new Carta(temp, "especial", "+2");
            Carta p2= new Carta(temp, "especial", "+2");
            Carta c1= new Carta(temp, "especial", "color");
            Carta c2= new Carta(temp, "especial", "color");
            Carta c3= new Carta(temp, "especial", "color");
            Carta c4= new Carta(temp, "especial", "color");
            especiales.addAll(Arrays.asList(s,s2,t,t2,p,p2,c1,c2,c3,c4));
        }
        Carta m1= new Carta("+4", "especial");
        Carta m2= new Carta( "+4","especial" );
        Carta m3= new Carta( "+4","especial");
        Carta m4= new Carta( "+4","especial");
        especiales.addAll(Arrays.asList(m1,m2,m3,m4));
        mazoPrincipal.addAll(numeros);
        mazoPrincipal.addAll(especiales);
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
    
}
