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
        Mazo mazoSecundario = mazoPrincipal;
        listaMazos.addAll(Arrays.asList(mazoPrincipal, mazoSecundario));

        Assertions.assertEquals(2, listaMazos.size());
        Assertions.assertEquals(112, mazoPrincipal.tamañoMazo());


    }
}