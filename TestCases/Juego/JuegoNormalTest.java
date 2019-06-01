package Juego;

import Models.Mazo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class JuegoNormalTest {
    Mazo mazo;
    JuegoNormal juego;
    ArrayList<Mazo> listaMazos;

    @BeforeEach
    void setUp() {
        mazo = new Mazo();
        juego = new JuegoNormal();
        listaMazos = new ArrayList<>();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void llenarMazosTest (){
        Mazo mazoPrincipal = mazo;
        mazoPrincipal.llenarMazo();
        Assertions.assertEquals(108, mazoPrincipal.tamañoMazo());

    }

    @Test
    void validarNombreTest (){
       String nombreV = "nombre";
       String nombreIn = " ";
       String nombreIn2 = "  ";

       Assertions.assertEquals(true, juego.validarNombre(nombreV));
       Assertions.assertEquals(false, juego.validarNombre(nombreIn));
       Assertions.assertEquals(false, juego.validarNombre(nombreIn2));

    }

    @Test
    void validarClaveTest (){
        String clave = "1234";
        String claveIn = " ";
        String claveIn2 = "  ";

        Assertions.assertEquals(true, juego.validarNombre(clave));
        Assertions.assertEquals(false, juego.validarNombre(claveIn));
        Assertions.assertEquals(false, juego.validarNombre(claveIn2));

    }






}