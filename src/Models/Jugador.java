package Models;

import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JOptionPane;

public class Jugador {
    
    private String nombre;
    private ArrayList<Carta> manoCartas= new ArrayList<>();
    private String clave;
    private int vecesEnMenu;
    
    public Jugador(String nombre) {
        this(nombre, "");
        //this.nombre = nombre;
       
    }
    
    public Jugador(String nombre,String pass) {
        this.nombre = nombre;
        this.clave=pass;
        
    }

    public int getVecesEnMenu() {
        return vecesEnMenu;
    }

    public void setVecesEnMenu(int vecesEnMenu) {
        this.vecesEnMenu = vecesEnMenu;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public String getClave() {
        return clave;
    }
   
    public String getNombre() {
        return nombre;
    }

    public ArrayList<Carta> getManoCartas() {
        return manoCartas;
    }

    public void setManoCartas(ArrayList<Carta> manoCartas) {
        this.manoCartas = manoCartas;
    }
    
    public void agregarCartas(Collection<Carta> sumadas){
        manoCartas.addAll(sumadas);
    }

    public String devolverStringMano(){
        String mano="Tu mano "+getNombre()+" es:\n\n";
        for (int i = 0; i < getManoCartas().size(); i++) {
            mano+=i+"-";
            mano+=(getManoCartas().get(i).getTipo()+" "+getManoCartas().get(i).getValor()+" "+getManoCartas().get(i).getColor())+"\n";
        }
        return mano;
    }
    
    public void imprimirMano(){
        String mano="Tu mano "+getNombre()+" es:\n\n";
        for (int i = 0; i < getManoCartas().size(); i++) {
            mano+=i+"-";
            mano+=(getManoCartas().get(i).getTipo()+" "+getManoCartas().get(i).getValor()+" "+getManoCartas().get(i).getColor())+"\n";
        }
        JOptionPane.showMessageDialog(null, mano);
    }

    public void removerCarta(int posicion){
        manoCartas.remove(posicion);
    }
    
    public void removerCarta(Carta c){
        System.out.println("Entro remover Carta");
        System.out.println(getNombre());
        int posicion=-1;
        for (int i = 0; i < manoCartas.size(); i++) {
            if(manoCartas.get(i).equals(c) ){
                System.out.println("Encontro la posicion");
                posicion=i;
                break;
            }
        }
            
        manoCartas.remove(posicion);
    }
    
    public boolean validarMano(Carta c){
        for (Carta carta : manoCartas) {
            if(carta.validarCarta(c))return true;            
        }
        return false;
    }
    
    public Carta traerCartaValida(Carta c){
        for (Carta carta : manoCartas) {
            if(carta.validarCarta(c))return carta;            
        }
        return null;
    }
}
