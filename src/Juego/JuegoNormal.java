package Juego;

import GUI.MenuPrincipal;
import GUI.VistaJugador;
import Models.Carta;
import Models.Jugador;
import Models.Mazo;
import Persistencia.Persistencia;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class JuegoNormal {

    public static ArrayList<Jugador> listaJugadores = new ArrayList<>();
    public static ArrayList<Jugador> listaGanadores = new ArrayList<>();
    public static ArrayList<Mazo> listaMazos = new ArrayList<>();
    public static int jugadorFocus = 0;
    public static boolean rondaHoraria = true;
    public static Carta pozo = new Carta();
    static int acumulador = 0;
    public static Persistencia persistencia = new Persistencia();
    private ArrayList<String> kdena= persistencia.getKdena();
    private final int tamañoMano=7;
    public boolean isValid=true;

    public void setJugadorFocus (int num){
        jugadorFocus = num;
    }

    public boolean isIsValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }

    
    
    public JuegoNormal() {}
    
    /*
     Crea el mazo principal del juego y uno de respaldo. Los dos se añaden a la lista
     de mazos
     */
    public void llenarMazos() {
        Mazo mazoPrincipal = new Mazo();
        mazoPrincipal.llenarMazo();
        Mazo mazoSecundario = new Mazo();
        mazoSecundario.llenarMazo();
        listaMazos.addAll(Arrays.asList(mazoPrincipal, mazoSecundario));
    }

    /*
    Crea algunos jugadores y les asigna una mano de cartas.
    */
    public void llenarJugadores() {
        Jugador jugador = new Jugador("Jugador1");
        jugador.setManoCartas(generarMano());
        Jugador jugador2 = new Jugador("Jugador2");
        jugador2.setManoCartas(generarMano());
        Jugador jugador3 = new Jugador("Jugador3");
        jugador3.setManoCartas(generarMano());
        listaJugadores.addAll(Arrays.asList(jugador, jugador2, jugador3));
        for (Jugador jug : listaJugadores) {
            jug.setClave("test");
        }
    }

    /*
    Crea un jugador con todas cartas +4 para probar la partida
    */
    public void jugTrucado(){
        Jugador jugadorr = new Jugador("Cheater");
        for (int i = 0; i < tamañoMano; i++) {
            Carta cartaa = new Carta("joker", "especial", "+4");
            jugadorr.agregarCartas(Arrays.asList(cartaa));
        }       
//        Carta cartaa2 = new Carta("verde", "especial", "spin");
//        Carta cartaa3 = new Carta("rojo", "especial", "spin");
//        Carta cartaa4 = new Carta("azul", "especial", "spin");
//        Carta cartaa5 = new Carta("amarillo", "especial", "spin");
//        jugadorr.addCartas(Arrays.asList(cartaa2,cartaa3,cartaa4,cartaa5));
        jugadorr.setClave("q");
        listaJugadores.add(jugadorr);
    }
    /*
    Devuelve la lista con los jugadores
    */
    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    /*
    Devuelve la lista con los 2 mazos
    */
    public ArrayList<Mazo> getListaMazos() {
        return listaMazos;
    }

    /*
    Devuelve el numero de jugador que esta en juego
    */
    public int getJugadorFocus() {
        return jugadorFocus;
    }

    /*
    Devuelve la mano de un jugador (7cartas) aleatorias
    */
    public ArrayList<Carta> generarMano() {
        ArrayList<Carta> mano = new ArrayList<>();
        Mazo mazo = listaMazos.get(0);
        for (int i = 0; i < tamañoMano; i++) {
            int random = (int) (Math.random() * mazo.getMazoPrincipal().size());
            mano.add(mazo.getMazoPrincipal().get(random));
        }
        return mano;
    }
    
    public boolean validarClave(String claveInput,Jugador j){
        return j.getClave().equals(claveInput);
    }

    /*
    Elige una carta aleatoria del mazo, que no sea una carta especial, y la saca del
    mazo una vez que se tira.
    */
    public void primerCartaPozo() {
        listaMazos.get(0).mezclarMazo();
        for (int i = 0; i < listaMazos.get(0).getMazoPrincipal().size(); i++) {
            Carta c = listaMazos.get(0).getMazoPrincipal().get(i);
            if (!"especial".equals(c.getTipo())) {
                pozo.setColor(c.getColor());
                pozo.setTipo(c.getTipo());
                pozo.setValor(c.getValor());
                listaMazos.get(0).removerCarta(i);
            }
        }

    }

    public void asignarValores(ArrayList<Carta> listaCartas){
        for (Carta carta : listaCartas) {
           int aux=0;
           aux+= verTipo(carta)+verColor(carta)+verValor(carta);
           carta.setCodigo(aux*31);
        }
    }
    
    public int verValor(Carta c){
        int valor=0;
        if(c.getTipo().equals("especial")){
            switch(c.getValor()){
                case("spin"):valor=7;break;
                case("skip"):valor=4;break;
                case("color"):valor=10;break;
                case("+2"):valor=8;break;
                case("+4"):valor=6;break;
            }
        }else{
            valor=Integer.parseInt(c.getValor());
        }
        return valor;
    }
    
    public int verTipo(Carta c){
        if(c.getTipo().equals("especial")){
            return 10;
        }else{
            return 5;
        }        
    }
    
    public int verColor(Carta c){
        int valor;
        String colorCarta=c.getColor();
        switch(colorCarta){
            case("rojo"):valor=15;break;            
            case("amarillo"):valor=25;break;
            case("azul"):valor=20;break;
            case("verde"):valor=10;break;
            case("joker"):valor=5;break;
            default:valor=0;break;
        }
        return valor;
    }
    
    /*
    Trae una carta aleatoria de la mano del jugador.
    */
    public Carta generarCarta(Jugador j) {
        int random = (int) (Math.random() * j.getManoCartas().size());
        Carta cartaJugada = j.getManoCartas().get(random);
        return cartaJugada;
    }

    /*
    Tira una carta aleatoria valida
    */
    public Carta generarCartaValida(Jugador j) {
        if (j.validarMano(pozo)) {
            return j.traerCartaValida(pozo);
        }
        return null;
    }

    /*
    Simular tiro carta valida de bot
    */
    public void tirarValida(Jugador j) {
        if (j.validarMano(pozo)) {
            Carta cartaJugada = generarCartaValida(j);
            String msj = "";
            msj += ("Jugada exitosa!\n");
            msj += ("Pozo:" + pozo.getValor() + " " + pozo.getTipo() + " " + pozo.getColor() + "\n");
            msj += ("Carta tirada: " + cartaJugada.getValor() + " " + cartaJugada.getTipo() + " " + cartaJugada.getColor() + "\n");
            JOptionPane.showMessageDialog(null, msj);
            pozo.setValor(cartaJugada.getValor());
            pozo.setColor(cartaJugada.getColor());
            if (cartaJugada.getTipo().equals("especial")) {
                pozo.setTipo("especial");
            } else {
                pozo.setTipo("numero");
            }
            j.removerCarta(j.getManoCartas().indexOf(cartaJugada));
            if (pozo.getTipo().equals("especial")) aplicarCartaEspecial(pozo);
        } else {
            JOptionPane.showMessageDialog(null, "El jugador no posee cartas validas!");
        }

    }

    public void cambioColor() {
        String msj = "Elija a que color quiere cambiar:\n"
                + "1-rojo\n2-azul\n3-amarillo\n4-verde";
        String choice = JOptionPane.showInputDialog(msj);
        switch (choice) {
            case ("1"):
                pozo.setColor("rojo");
                preguntarMovida(nextPlayer());
                break;
            case ("2"):
                pozo.setColor("azul");
                preguntarMovida(nextPlayer());
                break;
            case ("3"):
                pozo.setColor("amarillo");
                preguntarMovida(nextPlayer());
                break;
            case ("4"):
                pozo.setColor("verde");
                preguntarMovida(nextPlayer());
                break;
            default:
                JOptionPane.showMessageDialog(null, "La opcion ingresada no es valida!\nIntenta de nuevo.");
                cambioColor();
                break;
        }
    }

    public void verificarEspecial(Carta c) {
        if (c.getTipo().equals("especial")) {
            aplicarCartaEspecial(c);
        }
        
    }


    /*
    Asigna como jugador que esta jugando a la posicion de j en el array. Valida la carta que tira el jugador
    contra la carta que esta en el pozo. Y aplica las consecuencias si la carta es especial.
    Y saca la carta de la mano del jugador, siempre que la jugada haya sido valida.
    */
    public void turnoJugador(Jugador j) {
        
        Carta cartaJugada = generarCarta(j);
        String msj = "";
        boolean valid = true;
        if (pozo.validarCarta(cartaJugada)) {

            msj += ("Jugada exitosa!\n");
            msj += ("Pozo:" + pozo.getValor() + " " + pozo.getTipo() + " " + pozo.getColor() + "\n");
            msj += ("Carta tirada: " + cartaJugada.getValor() + " " + cartaJugada.getTipo() + " " + cartaJugada.getColor() + "\n");
            pozo.setValor(cartaJugada.getValor());
            if (cartaJugada.getTipo().equals("especial")) {
                pozo.setTipo("especial");
            } else {
                pozo.setTipo("numero");
                pozo.setColor(cartaJugada.getColor());
            }
            j.removerCarta(j.getManoCartas().indexOf(cartaJugada));
            checkManoJug(j);
            if (pozo.getTipo().equals("especial")) aplicarCartaEspecial(pozo);
        } else {

            msj += ("Jugada no valida!\n");
            msj += ("Pozo:" + pozo.getValor() + " " + pozo.getTipo() + " " + pozo.getColor() + "\n");
            msj += ("Carta tirada: " + cartaJugada.getValor() + " " + cartaJugada
                    .getTipo() + " " + cartaJugada.getColor() + "\n");
            valid = false;
        }
        JOptionPane.showMessageDialog(null, msj);

        if (!valid) preguntarMovida(j);

    }
    
    public boolean validarChoice(String choice,int tamañoMano){
        try {
            Integer.parseInt(choice);
        } catch (Exception e) {
            return false;
        }
        if(Integer.parseInt(choice) < -1 || Integer.parseInt(choice) >= tamañoMano){
            return false;
        }
        return true;
    }
    
    public Carta elegirCarta(Jugador j){
        int tamañoMano=j.getManoCartas().size();
        String choice="";

        String cartaPozo = "La carta del pozo es: \n";
        cartaPozo += pozo.getTipo() + " " + pozo.getValor() + " " + pozo.getColor()+"\n";
        
        while (!validarChoice(choice=JOptionPane.showInputDialog(j.devolverStringMano()+
                "\n"+cartaPozo+"\nIngrese el numero de carta que quiere mostrar\nIngrese -1 para salir"),tamañoMano)) {
                JOptionPane.showMessageDialog(null, "Numero ingresado no es valido");
        }        
                
        
        if(Integer.parseInt(choice) == -1){
            return null;
        }
        return j.getManoCartas().get(Integer.parseInt(choice));
    }
    
    
    public void tirarEleccion(Jugador j){
        
        Carta cartaJugada = elegirCarta(j);
        if(cartaJugada==null){
            preguntarMovida(j);
        }
        String msj = "";
        boolean valid = true;
        if (pozo.validarCarta(cartaJugada)) {

            msj += ("Jugada exitosa!\n");
            msj += ("Pozo:" + pozo.getValor() + " " + pozo.getTipo() + " " + pozo.getColor() + "\n");
            msj += ("Carta tirada: " + cartaJugada.getValor() + " " + cartaJugada.getTipo() + " " + cartaJugada.getColor() + "\n");
            pozo.setValor(cartaJugada.getValor());
            if (cartaJugada.getTipo().equals("especial")) {
                pozo.setTipo("especial");
            } else {
                pozo.setTipo("numero");
                pozo.setColor(cartaJugada.getColor());
            }
            j.removerCarta(j.getManoCartas().indexOf(cartaJugada));
            checkManoJug(j);
            if (pozo.getTipo().equals("especial")) aplicarCartaEspecial(pozo);
        } else {

            msj += ("Jugada no valida!\n");
            msj += ("Pozo:" + pozo.getValor() + " " + pozo.getTipo() + " " + pozo.getColor() + "\n");
            msj += ("Carta tirada: " + cartaJugada.getValor() + " " + cartaJugada.getTipo() + " " + cartaJugada.getColor() + "\n");
            valid = false;
        }
        JOptionPane.showMessageDialog(null, msj);

        if (!valid) preguntarMovida(j);

    }
    
    public void mensajeEntrada(){
        JOptionPane.showMessageDialog(null, "¡Bienvenido al UNO!");
    }
    
    public void checkManoJug(Jugador j){
        int tamañoMano= j.getManoCartas().size();
        if(tamañoMano == 1){
            JOptionPane.showMessageDialog(null, "UNO! "+j.getNombre());
            
        }
        if(tamañoMano==0){
            JOptionPane.showMessageDialog(null, "El jugador "+j.getNombre()+" se ha quedado sin cartas!");
            listaGanadores.add(j);
            listaJugadores.remove(j);
        }
    }
    
    public void checkCantidadCartas(Carta c){
        int tamañoActual=listaMazos.get(0).getMazoPrincipal().size();
        if(c.getTipo().equals("especial") && c.getValor().equals("+4") || c.getValor().equals("+2") && tamañoActual<4 ){
            rellenarMazo();
        }
    }
    
    /*
    Checkea si el mazo principal esta vacio, si lo esta lo rellena usando el refil
    */
    public void checkMazoVacio() {
        if (listaMazos.get(0).getMazoPrincipal().isEmpty()) {
        	rellenarMazo();
        }
    }

    /*l
    Toma el mazo secundario, lo mezcla y agrega al mazo principal todas las cartas ya mezcladas
    */
    public void rellenarMazo() {
        listaMazos.get(1).mezclarMazo();
        listaMazos.get(0).getMazoPrincipal().addAll(listaMazos.get(1).getMazoPrincipal());
    }

    public boolean otraValidacion(Jugador j){
        JPasswordField pwd = new JPasswordField();
        JOptionPane.showConfirmDialog(null, pwd, "Ingrese su clave "+j.getNombre(),JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if(pwd.getText().equals(j.getClave())){
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
            otraValidacion(j);
        }
        return false;            
    }
    
    public void preguntarMovida(){
        VistaJugador vista=new VistaJugador(pozo, jugadorFocus);
        vista.setVisible(true);
    }
    
    /*
    Accion a tomar en el turno
    (Faltan implementar)
    */
    public void preguntarMovida(Jugador j) {
        j.setVecesEnMenu(j.getVecesEnMenu()+1);
        if(checkPerder()){
            String ganadores="";
            for (Jugador jug : listaGanadores) {
                ganadores+=jug.getNombre()+"\n";
            }
            JOptionPane.showMessageDialog(null, "Queda solo un jugador, la partida termino!"
                    + "\nLos ganadores fueron:\n"+ganadores);
            
            System.exit(0);
        }
        if(j.getVecesEnMenu()==1){
            otraValidacion(j);            
        }        
        String msj = "1-Ver mano" +
                "\n2-Ver Pozo" +
                "\n3-Tirar carta" +
                "\n4-Levantar carta del mazo" +
                "\n5-Validar mano" +
                "\n6-Pasar turno" +
                "\n7-Tirar Valida"+
                "\n8-Elegir Carta para Tirar"
                + "\n10-Guardar y Salir" +

                "\n    -------------------------------"+
                "\n                   POZO              "+
                 "\n         " + getPozo().toString() +
                "\n    -------------------------------";
        int opcion;
        try {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(msj));
        } catch (NumberFormatException e) {
            opcion = -1;
        }
        //agregar constantes
        final int verMano=1;
        final int verCartaPozo=2;
        final int tirarCartaRandom=3;
        final int levantarCartaMazo=4;
        final int validarMano=5;
        final int pasarTurno=6;
        final int tirarValida=7;
        final int elegirCartaJugador=8;
        final int salir=10;
        final int casodefault=-1;
        
        switch (opcion) {
            case (verMano):
                j.imprimirMano();
                preguntarMovida(j);
                break;
            case (verCartaPozo):
                String cartaPozo = "La carta del pozo es: \n\n";
                cartaPozo += pozo.getTipo() + "\n" + pozo.getValor() + "\n" + pozo.getColor();
                JOptionPane.showMessageDialog(null, cartaPozo);
                preguntarMovida(j);
                break;
            case (tirarCartaRandom):
                turnoJugador(j);
                verificarEspecial(pozo);                
                JOptionPane.showMessageDialog(null, "Tu turno: " + listaJugadores.get(jugadorFocus+1).getNombre());
                preguntarMovida(nextPlayer());
                break;
            case (levantarCartaMazo):
                levantarCartaMazo(j);
                JOptionPane.showMessageDialog(null, "Carta Levantada!");
                preguntarMovida(j);
                break;
            case (validarMano):
                String alert;
                if (j.validarMano(pozo)) {
                    alert = "Tu mano cuenta con una carta valida!";
                } else {
                    alert = "No posees ninguna carta valida! Toma del pozo";
                }
                JOptionPane.showMessageDialog(null, alert);
                preguntarMovida(j);
                break;
            case (pasarTurno):
                JOptionPane.showMessageDialog(null, "Turno cedido!");
                preguntarMovida(nextPlayer());
                break;
            case (tirarValida):
                tirarValida(j);
                checkManoJug(j);
                checkPerder();
                preguntarMovida(nextPlayer());
                break;
            case (elegirCartaJugador):
                tirarEleccion(j);                
                checkPerder();
                preguntarMovida(nextPlayer());
                break;
            case (salir):
                guardarData();
                System.exit(0);
            case(150):
                VistaJugador vista=new VistaJugador(pozo, jugadorFocus);
                vista.setVisible(true);
                
                break;
            case (casodefault):
                JOptionPane.showMessageDialog(null, "¡El valor ingresado no es valido!");
                preguntarMovida(j);
                break;
            default:
                JOptionPane.showMessageDialog(null, "¡El numero ingresado no es valido!");
                //Ignorar Warning.
                preguntarMovida(j);
                break;

        }
    }

    /*
    Toma una carta aleatoria del mazo y la agrega a la mano del jugador
    */

    /*
    Se modificó el método para que no deje levantar cartas si el jugador tiene alguna carta válida.
     */
    public void levantarCartaMazo(Jugador j) {
        checkMazoVacio();
        if (!tieneCartaParaJugar(j)){
            int numeroRandom = (int) (Math.random() * listaMazos.get(0).getMazoPrincipal().size());
            j.getManoCartas().add(listaMazos.get(0).getMazoPrincipal().get(numeroRandom));
            listaMazos.get(0).removerCarta(listaMazos.get(0).getMazoPrincipal().indexOf(numeroRandom-1));
        } else {
            JOptionPane.showMessageDialog(null, "Tienes al menos una carta válidad para jugar");
            preguntarMovida(j);
        }
    }
    /*
    Método para verificar si el jugador tiene alguna carta válida antes de levantar una carta del mazo.
     */
    public boolean tieneCartaParaJugar (Jugador j){
        checkMazoVacio();

        for (int i = 0; i <j.getManoCartas().size() ; i++) {
            if (getPozo().validarCarta(j.getManoCartas().get(i)))
                return true;

        }
        return false;
    }



    /*
    Metodo que va corriendo el focus de los jugadores
    */
    public void incrementFocus() {
        int lastPlayer = jugadorFocus;
        if (rondaHoraria) {
            if (lastPlayer + 1 == listaJugadores.size()) {
                jugadorFocus = 0;
            } else {
                jugadorFocus = lastPlayer + 1;
            }
        } else {
            if (lastPlayer - 1 < 0) {
                jugadorFocus = listaJugadores.size() - 1;
            } else {
                jugadorFocus = lastPlayer - 1;
            }
        }
    }

    /*
    Metodo que calcula quien es el siguiente jugador
    (A mejorar el codigo, pero funciona)
    */
    public Jugador nextPlayer() {
        for (Jugador jug : listaJugadores) {
            jug.setVecesEnMenu(0);
        }
        incrementFocus();
        int nextPlayer = jugadorFocus;
        return listaJugadores.get(nextPlayer);
    }
    
    public int numeroSiguiente(){
        int lastPlayer = jugadorFocus;
        int siguiente;
        if (rondaHoraria) {
            if (lastPlayer + 1 == listaJugadores.size()) {

                siguiente = 0;
            } else {
                siguiente = lastPlayer + 1;
            }
        } else {
            if (lastPlayer - 1 < 0) {
                siguiente = listaJugadores.size() - 1;
            } else {
                siguiente = lastPlayer - 1;
            }
        }
        return siguiente;
    }
    
    /*
    Falta implementar
    Metodo que toma la carta especial, y lleva a cabo la accion que trae la carta.
    +2---> funciona
    +4---> suma las 4  cartas pero falta resolver el tema del cambio de color.
    skip--->
    spin--->cambia el sentido de la ronda, falta implementar que le pregunte al siguiente jugador que accion quiere tomar
    */
    public void aplicarCartaEspecial(Carta c) {
        checkMazoVacio();
        checkCantidadCartas(c);
        String tipoCarta = c.getTipo();
        String valorCarta = c.getValor();
        if (tipoCarta.equals("numero")) return;

        switch (valorCarta) {

            case ("+2"):
                nextPlayer();
                int numeroRandom = (int) (Math.random() * listaMazos.get(0).getMazoPrincipal().size()-1);
                Carta ca1 = listaMazos.get(0).getMazoPrincipal().get(numeroRandom);
                int numeroRandom2 = (int) (Math.random() * listaMazos.get(0).getMazoPrincipal().size() - 2);
                Carta ca2 = listaMazos.get(0).getMazoPrincipal().get(numeroRandom2);
                listaJugadores.get(numeroSiguiente()).agregarCartas(Arrays.asList(ca1, ca2));
                listaMazos.get(0).removerCartas(Arrays.asList(ca1, ca2));
                break;

                
            case ("+4"):
                nextPlayer();
                int n1 = (int) (Math.random() * listaMazos.get(0).getMazoPrincipal().size()-1);
                Carta c1 = listaMazos.get(0).getMazoPrincipal().get(n1);
                int n2 = (int) (Math.random() * listaMazos.get(0).getMazoPrincipal().size()-1);
                Carta c2 = listaMazos.get(0).getMazoPrincipal().get(n2);
                int n3 = (int) (Math.random() * listaMazos.get(0).getMazoPrincipal().size()-1);
                Carta c3 = listaMazos.get(0).getMazoPrincipal().get(n3);
                int n4 = (int) (Math.random() * listaMazos.get(0).getMazoPrincipal().size()-1);
                Carta c4 = listaMazos.get(0).getMazoPrincipal().get(n4);
                listaJugadores.get(numeroSiguiente()).agregarCartas(Arrays.asList(c1, c2, c3, c4));
                listaMazos.get(0).removerCartas(Arrays.asList(c1, c2, c3, c4));
                cambioColor();
                break;
            case ("skip"):
                nextPlayer();
                preguntarMovida(nextPlayer());
                break;

            case ("spin"):
                rondaHoraria = !rondaHoraria;
                preguntarMovida(nextPlayer());
                break;

            case ("color"):
                cambioColor();
                break;

        }
    }

    public void preguntarJugadores() {
        int numero;
        final int minJugadores=2;
        final int maxJugadores=6;
        
        try {
            numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de jugadores\nEntre 2 y 6 Jugadores"));
            if (numero < minJugadores || numero > maxJugadores) {
                JOptionPane.showMessageDialog(null, "El numero ingresado no es valido");
                preguntarJugadores();
            }
        } catch (NumberFormatException e) {
            numero = -1;
            JOptionPane.showMessageDialog(null, "El numero ingresado no es valido");
            preguntarJugadores();
        }

        for (int i = 0; i < numero; i++) {
            String name = "";
            while (!validarNombre(name = JOptionPane.showInputDialog("Ingrese el nombre del jugador"))) {
                JOptionPane.showMessageDialog(null, "Nombre ingresado no es valido");
            }
            String pass = "";
            while (!validarClave(pass = JOptionPane.showInputDialog("Ingrese la clave del jugador"))) {
                JOptionPane.showMessageDialog(null, "Clave ingresada no es valido");
            }
            Jugador jugador = new Jugador(name, pass);
            jugador.agregarCartas(generarMano());
            listaJugadores.add(jugador);
            JOptionPane.showMessageDialog(null, "Jugador " + jugador.getNombre() + " agregado con exito!");
        }
        //Descomentar jugador trucado para usar cartas especificas (Clave = q)
        //jugTrucado();
        for (Jugador jugador : listaJugadores) {
            asignarValores(jugador.getManoCartas());
        }
        //preguntarMovida(listaJugadores.get(jugadorFocus));
        preguntarMovida();
    }

    public boolean validarNombre(String nombre) {
        for (int i = 0; i < nombre.length(); i++) {
            if (nombre.charAt(i) != ' ') return true;
        }
        return false;
    }

    public boolean validarClave(String clave) {
        for (int i = 0; i < clave.length(); i++) {
            if (clave.charAt(i) != ' ') return true;
        }
        return false;
    }

    public boolean checkPerder(){
        if(listaJugadores.size()==1){
            return true;
        }
        return false;
    }

    public boolean isRondaHoraria() {
        return rondaHoraria;
    }

    public void setRondaHoraria(boolean rondaHoraria) {
        this.rondaHoraria = rondaHoraria;
    }

    public Carta getPozo() {
        return pozo;
    }

    public void setPozo(Carta pozo) {
        this.pozo = pozo;
    }
    
    public ArrayList<Jugador> getListaJug(){
        return listaJugadores;
    }

    public ArrayList<Carta> getMazo(){
        return listaMazos.get(0).getMazoPrincipal();
    }
    
    public String mString(){
        String data="MAZO\n-";
        for (Carta carta : getMazo()) {
            data+=carta.getValor()+" "+carta.getTipo()+" "+carta.getColor();
            if (getMazo().indexOf(carta)!=getMazo().size()-1){
                data+=",";
            }
        }
        data+="-";
        data+="\nPOZO\n"+pozo.getValor()+" "+pozo.getTipo()+" "+pozo.getColor();
        return data;
    }
    
    public String jString(){
        String data="";
        for (Jugador jug : listaJugadores) {
            int codigoJug=0;
            data+="JUGADOR\n";
            data+=jug.getNombre()+"\n"+jug.getClave()+"\n-";
            asignarValores(jug.getManoCartas());
            for (Carta carta : jug.getManoCartas()) {
                codigoJug+=carta.getCodigo();
                data+=carta.getValor()+" "+carta.getTipo()+" "+carta.getColor();
                if (jug.getManoCartas().indexOf(carta)!=jug.getManoCartas().size()-1){
                    data+=",";
                }
            }
            data+="-\n";            
            data+=codigoJug+"\n";            
        }   
        data+="FOCUS\n"+jugadorFocus;
        return data;
    }
    
    
    public void guardarData(){
        persistencia.escribirArchivo(jString(), mString());
    }
   
    public void volverMenu(){
        MenuPrincipal menu = new MenuPrincipal(1);
        menu.setVisible(true);
        
    }
    
    
    public void cargarData(){
        persistencia.leerArchivo();
        persistencia.agregarData();
        if(persistencia.corrupto){
            JOptionPane.showMessageDialog(null, "El fichero fue alterado, y fue eliminado!\n"
                    + "O el fichero no tiene contenido!\n"
                    + "Para Jugar crea una nueva partida.");
            isValid=false;
            return;
        }
        setPozo(persistencia.getPozo());
        listaJugadores=persistencia.getListaJugadores();
        Mazo mazo = new Mazo();        
        mazo.agregarCartas(persistencia.getMazo());
        Mazo aux = new Mazo();
        aux.llenarMazo();
        listaMazos.add(mazo);
        listaMazos.add(aux);
        jugadorFocus=persistencia.getJugadorFocus();
        
    }

    ///Para test
    public static ArrayList<Jugador> getListaGanadores() {
        return listaGanadores;
    }
}
