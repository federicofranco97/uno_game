package Models;

public class Carta {
    
    private String color;
    private String valor;
    private String tipo;

    public Carta() {}

    public void setColor(String color) {
        this.color = color;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Carta(String valor, String tipo) {
        this.valor = valor;
        this.tipo = tipo;
    }
    
    public Carta(String color, String tipo,String valor) {
        this.color = color;
        this.tipo = tipo;
        this.valor=valor;
    }

    public String getColor() {
        return color;
    }

    public String getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
 
    public boolean validarCarta(Carta c){
        if(getColor().equals(c.getColor()) || getValor().equals(c.getValor()) || c.getValor().equals("cambioColor")
                || c.getValor().equals("+4")){
            return true;
        }
        return false;
    }
    
    
    
}
