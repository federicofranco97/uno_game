package Models;

import java.util.Objects;

public class Carta {
    
    private String color;
    private String valor;
    private String tipo;


    private static int id;

    public Carta() {}

    public void setColor(String color) {
        this.color = color;
    }

    public void setTipo(String tipo) {
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
        if(c.getTipo().equals("especial") && (c.getValor().equals("+4") || c.getValor().equals("color"))){
            return true;
        }
        if(getColor().equals(c.getColor()) || getValor().equals(c.getValor())){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return getTipo() + " " + getValor() + " " + getColor();
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Carta)) return false;
//        Carta carta = (Carta) o;
//        return Objects.equals(getColor(), carta.getColor()) &&
//                Objects.equals(getValor(), carta.getValor()) &&
//                Objects.equals(getTipo(), carta.getTipo());
//    }


}
