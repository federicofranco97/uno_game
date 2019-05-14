package Models;

import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JOptionPane;

public class Jugador {
    
    private String nombre;
    private ArrayList<Carta> manoCartas= new ArrayList<>();
    private boolean esTurno;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.esTurno=false;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isEsTurno() {
        return esTurno;
    }

    public void setEsTurno(boolean esTurno) {
        this.esTurno = esTurno;
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
    
    public void imprimirMano(){
        String mano="Tu mano "+getNombre()+" es:\n\n";
        for (int i = 0; i < getManoCartas().size(); i++) {
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
    
}
