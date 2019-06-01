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
import javax.swing.JOptionPane;
public class Persistencia {
    private File archivo=new File("Partida.txt");
    private ArrayList<String> kdena = new ArrayList<>();
    private ArrayList<Jugador> listaJugadores = new ArrayList<>();
    private Carta pozo = new Carta();
    private ArrayList<Carta> mazo = new ArrayList<>();
    private int jugadorFocus=-1;
    private int valid=0;

    public Persistencia() {
        
    }

    public int getJugadorFocus() {
        return jugadorFocus;
    }
    
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
 
    public String generarValidKdena(String algo){
        int tamaño=algo.length();
        return "V\n"+String.valueOf(tamaño*31);
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
            String conjunto=j+"\n"+m;
            f.write(conjunto);
            f.newLine();
            f.write(generarValidKdena(conjunto));
            f.newLine();
                
            
            f.close();
        }catch(IOException e){}
    }
       
    public void agregarData(){
        boolean archivoValido=true;
        for (int i = 0; i < kdena.size(); i++) {
            if (kdena.get(i).equals("JUGADOR")) {
                Jugador jugador = new Jugador(kdena.get(i+1), kdena.get(i+2));
                String aux1= kdena.get(i+3).replaceAll("-", "");
                String [] cartaLista = aux1.split(",");
                int codigoAuxiliar=Integer.parseInt(kdena.get(i+4));
                System.out.println(codigoAuxiliar);
                for (String carta : cartaLista) {
                    String [] aux2=carta.split(" ");
                    jugador.addCartas(Arrays.asList(new Carta(aux2[2], aux2[1], aux2[0])));
                }
                if(calcularValores(jugador.getManoCartas())==codigoAuxiliar){
                    listaJugadores.add(jugador);
                }else{
                    JOptionPane.showMessageDialog(null,"Mano alterada, fuiste eliminado: "+jugador.getNombre());
                    archivoValido=false;
                }
                
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
            
            if(kdena.get(i).equals("V")) valid=Integer.parseInt(kdena.get(i+1));
        }
        if (validarData() || archivoValido) {
            System.out.println("Es valido el fichero");
        }else{
            System.out.println("Fichero corrupto");
            //falta implementar que haga algo como no cargar la partida
        }
    }
    
    public int calcularValores(ArrayList<Carta> listaCartas){
        int codigoAux=0;
        for (Carta carta : listaCartas) {
           int aux=0;
           aux+= verTipo(carta)+verColor(carta)+verValor(carta);
           codigoAux+=aux;
        }
        return codigoAux*31;
    }
    
    public int verValor(Carta c){
        int valor=0;
        if(c.getTipo().equals("especial")){
            switch(c.getValor()){
                case("spin"):valor=7;break;
                case("skip"):valor=4;break;
                case("color"):valor=10;break;
                case("+2"):valor=8;break;
                case("+4"):valor=6;break;
            }
        }else{
            valor=Integer.parseInt(c.getValor());
        }
        return valor;
    }
    
    public int verTipo(Carta c){
        if(c.getTipo().equals("especial")){
            return 10;
        }else{
            return 5;
        }        
    }
    
    public int verColor(Carta c){
        int valor;
        String colorCarta=c.getColor();
        switch(colorCarta){
            case("rojo"):valor=15;break;            
            case("amarillo"):valor=25;break;
            case("azul"):valor=20;break;
            case("verde"):valor=10;break;
            case("joker"):valor=5;break;
            default:valor=0;break;
        }
        return valor;
    }
    
    public boolean validarData(){
        String conjunto=jString()+"\n"+mString();
        int validNumber=conjunto.length()*31;
        return validNumber==valid;
    }
    
    public String mString(){
        String data="MAZO\n-";
        for (Carta carta : getMazo()) {
            data+=carta.getValor()+" "+carta.getTipo()+" "+carta.getColor();
            if (getMazo().indexOf(carta)!=getMazo().size()-1){
                data+=",";
            }
        }
        data+="-";
        data+="\nPOZO\n"+pozo.getValor()+" "+pozo.getTipo()+" "+pozo.getColor();
        return data;
    }
    
    public String jString(){
        String data="";
        for (Jugador jug : listaJugadores) {
            data+="JUGADOR\n";
            data+=jug.getNombre()+"\n"+jug.getClave()+"\n-";
            for (Carta carta : jug.getManoCartas()) {
                data+=carta.getValor()+" "+carta.getTipo()+" "+carta.getColor();
                if (jug.getManoCartas().indexOf(carta)!=jug.getManoCartas().size()-1){
                    data+=",";
                }
            }
            data+="-\n";            
        }   
        data+="FOCUS\n"+jugadorFocus;
        return data;
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
