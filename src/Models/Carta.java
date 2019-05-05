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

    public Carta(String tipo, String valor) {
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
    
    /*
    Agregar validacion de que pasa cuando la carta que se tira es un +4 o un cambio de color.
    Ahora si la carta es un +4 o un cambio de color, el color al cual se pasa lo define la
    siguiente carta que se tira.
    */
    public boolean validarCarta(Carta c){
        if(getTipo().equals("especial") && (getValor().equals("+4") || getValor().equals("color"))){
            return true;
        }
        if(getColor().equals(c.getColor()) || getValor().equals(c.getValor()) || c.getValor().equals("cambioColor")
                || c.getValor().equals("+4")){
            return true;
        }
        return false;
    }
    
    
    
}
