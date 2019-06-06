package Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JOptionPane;

public class Jugador implements Serializable {

    private static final long serialVersionUID = -3051214141392711151L;
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
    
    public void addCartas(Collection<Carta> sumadas){
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

    public void removeCarta(int posicion){
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
