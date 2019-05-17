package Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CartaTest {

    Carta carta;
    String valor;
    String tipo;
    @BeforeEach
        void setUp (){
        carta = new Carta("verde", "número", "3");

    }

    @Test
    void crearCarta() throws Exception {
        carta = new Carta();
        assertThrows(InvalidParameterException.class, ()-> new Carta("2", "número"));
        assertThrows(InvalidParameterException.class, ()-> new Carta("2", null, "naranja"));

    }

    @Test
    void setColor() throws Exception{
        assertThrows(InvalidParameterException.class, ()-> carta.setColor(""), "El valor no puede ser vacío");
        assertThrows(InvalidParameterException.class, ()-> carta.setColor(null), "El valor no puede ser null");


    }

    @Test
    void setTipo() {
        assertThrows(InvalidParameterException.class, ()-> carta.setTipo(""), "El tipo no puede ser vacío");
        assertThrows(InvalidParameterException.class, ()-> carta.setTipo(null), "El tipo no puede ser null");
    }

    @Test
    void getColor() {
        assertEquals("verde", carta.getColor());
        carta.setColor(null);
        assertEquals(null, carta.getColor());

    }

    @Test
    void getValor() {
        assertEquals("3", carta.getValor());
        carta.setValor(null);
        assertEquals(null, carta.getValor());
    }

    @Test
    void getTipo() {
        assertEquals("número", carta.getTipo());
        carta.setTipo(null);
        assertEquals(null, carta.getTipo());
    }

    @Test
    void setValor() {
        assertThrows(InvalidParameterException.class, ()-> carta.setValor(""), "El tipo no puede ser vacío");
        assertThrows(InvalidParameterException.class, ()-> carta.setValor(null), "El tipo no puede ser null");
    }

    @Test
    void validarCarta() {
        Carta carta3 = new Carta("especial", "+4");
        assertEquals(true, carta.validarCarta(carta3));

        Carta carta4 = new Carta("especial", "color");
        assertEquals(true, carta4.validarCarta(carta3));

        Carta carta5 = new Carta("verde", "número", "5");
        assertEquals(true, carta.validarCarta(carta5));

        Carta carta6 = new Carta("especial", "cambioColor");
        assertEquals(true, carta.validarCarta(carta6));

        assertEquals(false, carta.validarCarta(carta4));
        assertEquals(false, carta.validarCarta(new Carta (null, "número", "8")));
    }
}