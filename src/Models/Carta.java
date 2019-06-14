package Models;

import java.util.Objects;

public class Carta {
    
    private String color;
    private String valor;
    private String tipo;
    private int codigo;

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
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
        return this.tipo + " " + this.valor + " " + this.color;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carta other = (Carta) obj;
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        return true;
    }
    
    
}
