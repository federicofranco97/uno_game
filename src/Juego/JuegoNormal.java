package Juego;

import Models.Carta;
import Models.Jugador;
import Models.Mazo;
import Persistencia.Persistencia;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class JuegoNormal {

    private ArrayList<Jugador> listaJugadores = new ArrayList<>();
    private ArrayList<Jugador> listaGanadores = new ArrayList<>();
    private int jugadorFocus = 0;
    private boolean rondaHoraria = true;
    private Carta mostrarPozo2 = new Carta();
    static int acumulador = 0;
    private Persistencia persistencia = new Persistencia();
    private ArrayList<String> kdena= persistencia.getKdena();
     final int tamañoMano=7;


    public JuegoNormal() {}
    
    /*
     Crea el mazo principal del juego y uno de respaldo. Los dos se añaden a la lista
     de mazos
     */
    /*public void llenarMazos() {
        Mazo mazoPrincipal = new Mazo();
        mazoPrincipal.llenarMazo();
        Mazo mazoSecundario = mazoPrincipal;
        listaMazos.addAll(Arrays.asList(mazoPrincipal, mazoSecundario));
    }*/

    /*
    Crea algunos jugadores y les asigna una mano de cartas.
    */
    public void llenarJugadores() {
        Jugador jugador = new Jugador("Jugador1");
        jugador.setManoCartas(generarMano2());
        Jugador jugador2 = new Jugador("Jugador2");
        jugador2.setManoCartas(generarMano2());
        Jugador jugador3 = new Jugador("Jugador3");
        jugador3.setManoCartas(generarMano2());
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
            jugadorr.addCartas(Arrays.asList(cartaa));
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

    /*
    public ArrayList<Mazo> getListaMazos() {
        return getMazoP;
    }*/

    /*
    Devuelve el numero de jugador que esta en juego
    */
    public int getJugadorFocus() {
        return jugadorFocus;
    }

    /*
    Devuelve la mano de un jugador (7cartas) aleatorias
    */
    /*public ArrayList<Carta> generarMano() {
        ArrayList<Carta> mano = new ArrayList<>();
        Mazo mazo = listaMazos.get(0);
        for (int i = 0; i < tamañoMano; i++) {
            int random = (int) (Math.random() * mazo.getMazoPrincipal().size());
            mano.add(mazo.getMazoPrincipal().get(random));
        }
        return mano;
    }*/
    
    public boolean validarClave(String claveInput,Jugador j){
        return j.getClave().equals(claveInput);
    }

    /*
    Elige una carta aleatoria del mazo, que no sea una carta especial, y la saca del
    mazo una vez que se tira.
    */

    /*
    public void primerCartaPozo() {
        listaMazos.get(0).mezclarMazo();
        for (int i = 0; i < listaMazos.get(0).getMazoPrincipal().size(); i++) {
            Carta c = listaMazos.get(0).getMazoPrincipal().get(i);
            if (!"especial".equals(c.getTipo())) {
                pozo.setColor(c.getColor());
                pozo.setTipo(c.getTipo());
                pozo.setValor(c.getValor());
                listaMazos.get(0).removeCarta(i);
            }
        }

    }*/

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
        if (j.validarMano(mostrarPozo2())) {
            return j.traerCartaValida(mostrarPozo2());
        }
        return null;
    }

    /*
    Simular tiro carta valida de bot
    */
    public void tirarValida(Jugador j) {
        if (j.validarMano(mostrarPozo2())) {
            Carta cartaJugada = generarCartaValida(j);
            String msj = "";
            msj += ("Jugada exitosa!\n");
            msj += ("Pozo:" + mostrarPozo2().getValor() + " " + mostrarPozo2().getTipo() + " " + mostrarPozo2().getColor() + "\n");
            msj += ("Carta tirada: " + cartaJugada.getValor() + " " + cartaJugada.getTipo() + " " + cartaJugada.getColor() + "\n");
            JOptionPane.showMessageDialog(null, msj);
            mostrarPozo2().setValor(cartaJugada.getValor());
            mostrarPozo2().setColor(cartaJugada.getColor());
            if (cartaJugada.getTipo().equals("especial")) {
                mostrarPozo2().setTipo("especial");
            } else {
                mostrarPozo2().setTipo("numero");
            }
            j.removeCarta(j.getManoCartas().indexOf(cartaJugada));

            getPilaJugadas().getMazoPrincipal().add(cartaJugada);


            if (mostrarPozo2().getTipo().equals("especial")) aplicarCartaEspecial(mostrarPozo2());
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
                mostrarPozo2().setColor("rojo");
                preguntarMovida(nextPlayer());
                break;
            case ("2"):
                mostrarPozo2().setColor("azul");
                preguntarMovida(nextPlayer());
                break;
            case ("3"):
                mostrarPozo2().setColor("amarillo");
                preguntarMovida(nextPlayer());
                break;
            case ("4"):
                mostrarPozo2().setColor("verde");
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
        if (mostrarPozo2().validarCarta(cartaJugada)) {

            msj += ("Jugada exitosa!\n");
            msj += ("Pozo:" + mostrarPozo2().getValor() + " " + mostrarPozo2().getTipo() + " " + mostrarPozo2().getColor() + "\n");
            msj += ("Carta tirada: " + cartaJugada.getValor() + " " + cartaJugada.getTipo() + " " + cartaJugada.getColor() + "\n");
            mostrarPozo2().setValor(cartaJugada.getValor());
            if (cartaJugada.getTipo().equals("especial")) {
                mostrarPozo2().setTipo("especial");
            } else {
                mostrarPozo2().setTipo("numero");
                mostrarPozo2().setColor(cartaJugada.getColor());
            }
            j.removeCarta(j.getManoCartas().indexOf(cartaJugada));
            getPilaJugadas().getMazoPrincipal().add(cartaJugada);
            checkManoJug(j);
            if (mostrarPozo2().getTipo().equals("especial")) aplicarCartaEspecial(mostrarPozo2());
        } else {

            msj += ("Jugada no valida!\n");
            msj += ("Pozo:" + mostrarPozo2().getValor() + " " + mostrarPozo2().getTipo() + " " + mostrarPozo2().getColor() + "\n");
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
        cartaPozo += mostrarPozo2().getTipo() + " " + mostrarPozo2().getValor() + " " + mostrarPozo2().getColor()+"\n";
        
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
        if (mostrarPozo2().validarCarta(cartaJugada)) {

            msj += ("Jugada exitosa!\n");
            msj += ("Pozo:" + mostrarPozo2().getValor() + " " + mostrarPozo2().getTipo() + " " + mostrarPozo2().getColor() + "\n");
            msj += ("Carta tirada: " + cartaJugada.getValor() + " " + cartaJugada.getTipo() + " " + cartaJugada.getColor() + "\n");
            mostrarPozo2().setValor(cartaJugada.getValor());
            if (cartaJugada.getTipo().equals("especial")) {
                mostrarPozo2().setTipo("especial");
            } else {
                mostrarPozo2().setTipo("numero");
                mostrarPozo2().setColor(cartaJugada.getColor());
            }
            j.removeCarta(j.getManoCartas().indexOf(cartaJugada));
            getPilaJugadas().getMazoPrincipal().add(cartaJugada);
            checkManoJug(j);

            //*****************************////
            System.out.println(getMazoP().getMazoPrincipal().size());
            System.out.println(getPilaJugadas().getMazoPrincipal().size());

            //****************************////


            if (mostrarPozo2().getTipo().equals("especial")) aplicarCartaEspecial(mostrarPozo2());
        } else {

            msj += ("Jugada no valida!\n");
            msj += ("Pozo:" + mostrarPozo2().getValor() + " " + mostrarPozo2().getTipo() + " " + mostrarPozo2().getColor() + "\n");
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
        int tamañoActual=getMazoP().getMazoPrincipal().size();
        if(c.getTipo().equals("especial") && c.getValor().equals("+4") || c.getValor().equals("+2") && tamañoActual<4 ){
            refillMazo();
        }
    }
    
    /*
    Checkea si el mazo principal esta vacio, si lo esta lo rellena usando el refil
    */
    public void checkMazoVacio() {
        if (getMazoP().getMazoPrincipal().isEmpty()) {
            refillMazo();
        }
    }

    /*l
    Toma el mazo secundario, lo mezcla y agrega al mazo principal todas las cartas ya mezcladas
    */


    public void refillMazo() {
        getPilaJugadas().mezclarMazo();
        getMazoP().agregarCartas(getPilaJugadas().getMazoPrincipal());
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
//            while (!validarClave(JOptionPane.showInputDialog("Ingrese la clave de "+j.getNombre()),j)) {
//                JOptionPane.showMessageDialog(null, "La clave ingresada no es valida");
//            }
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
                 "\n         " + mostrarPozo2().toString() +
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
                cartaPozo += mostrarPozo2().getTipo() + "\n" + mostrarPozo2().getValor() + "\n" + mostrarPozo2().getColor();
                JOptionPane.showMessageDialog(null, cartaPozo);
                preguntarMovida(j);
                break;
            case (tirarCartaRandom):
                turnoJugador(j);
                verificarEspecial(mostrarPozo2());
                
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
                if (j.validarMano(mostrarPozo2())) {
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
            int numeroRandom = (int) (Math.random() * getMazoP().getMazoPrincipal().size());
            j.getManoCartas().add(getMazoP().getMazoPrincipal().get(numeroRandom));
            getMazoP().getMazoPrincipal().remove(numeroRandom);

        } else {
            JOptionPane.showMessageDialog(null, "Tienes al menos una carta válidad para jugar");
            preguntarMovida(j);
        }


//        listaMazos.get(0).removeCarta(listaMazos.get(0).getMazoPrincipal().indexOf(numeroRandom-1));
    }
    /*
    Método para verificar si el jugador tiene alguna carta válida antes de levantar una carta del mazo.
     */
    public boolean tieneCartaParaJugar (Jugador j){
        checkMazoVacio();

        for (int i = 0; i <j.getManoCartas().size() ; i++) {
            if (mostrarPozo2().validarCarta(j.getManoCartas().get(i)))
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
                int numeroRandom = (int) (Math.random() * getMazoP().getMazoPrincipal().size()-1);
                Carta ca1 = getMazoP().getMazoPrincipal().get(numeroRandom);
                int numeroRandom2 = (int) (Math.random() * getMazoP().getMazoPrincipal().size() - 2);
                Carta ca2 = getMazoP().getMazoPrincipal().get(numeroRandom2);
                listaJugadores.get(numeroSiguiente()).addCartas(Arrays.asList(ca1, ca2));
                getMazoP().removeCartas(Arrays.asList(ca1, ca2));
                System.out.println("Se eliminaron 2");
                break;

                
            case ("+4"):
                int n1 = (int) (Math.random() * getMazoP().getMazoPrincipal().size()-1);
                Carta c1 = getMazoP().getMazoPrincipal().get(n1);
                int n2 = (int) (Math.random() * getMazoP().getMazoPrincipal().size()-1);
                Carta c2 = getMazoP().getMazoPrincipal().get(n2);
                int n3 = (int) (Math.random() * getMazoP().getMazoPrincipal().size()-1);
                Carta c3 = getMazoP().getMazoPrincipal().get(n3);
                int n4 = (int) (Math.random() * getMazoP().getMazoPrincipal().size()-1);
                Carta c4 = getMazoP().getMazoPrincipal().get(n4);
                listaJugadores.get(numeroSiguiente()).addCartas(Arrays.asList(c1, c2, c3, c4));
                getMazoP().removeCartas(Arrays.asList(c1, c2, c3, c4));
                System.out.println("Se eliminaron 4");
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
            jugador.addCartas(generarMano2());
            listaJugadores.add(jugador);
            JOptionPane.showMessageDialog(null, "Jugador " + jugador.getNombre() + " agregado con exito!");
        }
        //Descomentar jugador trucado para usar cartas especificas (Clave = q)
        //jugTrucado();
        preguntarMovida(listaJugadores.get(jugadorFocus));
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

//    public Carta getPozo() {
//        return mostrarPozo2;
//    }
//
//    public void setPozo(Carta pozo) {
//        this.mostrarPozo2 = pozo;
//    }
    
    public ArrayList<Jugador> getListaJug(){
        return listaJugadores;
    }

    public ArrayList<Carta> getMazo(){
        return getMazoP().getMazoPrincipal();
    }
    
    public String mString(){
        String data="MAZO\n-";
        for (Carta carta : getMazoP().getMazoPrincipal()) {
            data+=carta.getValor()+" "+carta.getTipo()+" "+carta.getColor();
            if (getMazoP().getMazoPrincipal().indexOf(carta)!=getMazoP().getMazoPrincipal().size()-1){
                data+=",";
            }
        }/////////////////////////////////////////////////////////////////////////
        data+="-";
        data+="\nPILA\n-";
        for (Carta carta : getPilaJugadas().getMazoPrincipal()) {
            data+=carta.getValor()+" "+carta.getTipo()+" "+carta.getColor();
            if (getPilaJugadas().getMazoPrincipal().indexOf(carta)!=getPilaJugadas().getMazoPrincipal().size()-1){
                data+=",";
            }
        }


        ////////////////////////////////////////////////////////////////////////
        data+="-";
        data+="\nPOZO\n"+mostrarPozo2().getValor()+" "+mostrarPozo2().getTipo()+" "+mostrarPozo2().getColor();
        return data;
    }
    
    public String jString(){
        String data="";
        for (Jugador jug : listaJugadores) {
            data+="JUGADOR\n";
            data+=jug.getNombre()+"\n"+jug.getClave()+"\n-";
            for (Carta carta : jug.getManoCartas()) {
                data+=carta.getValor()+" "+carta.getTipo()+" "+carta.getColor();
                if (jug.getManoCartas().indexOf(carta)!=jug.getManoCartas().size()-1){
                    data+=",";
                }
            }
            data+="-\n";            
        }   
        data+="FOCUS\n"+jugadorFocus;
        return data;
    }
    
    
    public void guardarData(){
        persistencia.escribirArchivo(jString(), mString());
    }
   
    public void cargarData(){
        persistencia.leerArchivo();
        persistencia.agregarData();
        //setPozo(persistencia.getPozo());
        cartaPozo = persistencia.getPozo();
        listaJugadores=persistencia.getListaJugadores();
        //Mazo mazo = new Mazo();
        mazoP.agregarCartas(persistencia.getMazo());
        pilaJugadas.agregarCartas(persistencia.getMazoPila());
//        pilaJugadas.llenarMazo();
//        System.out.println(pilaJugadas.getMazoPrincipal().size());
//        pilaJugadas.removeCartas(persistencia.getMazo());
//        System.out.println(pilaJugadas.getMazoPrincipal().size());
//
//        for (int i = 0; i <listaJugadores.size() ; i++) {
//            pilaJugadas.getMazoPrincipal().remove(persistencia.getListaJugadores().get(i).getManoCartas());
//            System.out.println(persistencia.getListaJugadores().get(i).getManoCartas().size());
//        }
//        mazoP = mazo;
//        pilaJugadas = aux;

        System.out.println(pilaJugadas.getMazoPrincipal().size());
        jugadorFocus=persistencia.getJugadorFocus();

    }

    //////////Pozo como lista
    private Mazo mazoP = new Mazo();
    private Mazo pilaJugadas = new Mazo();
    private Carta cartaPozo = new Carta();

    public void llenarMazo2(){
        mazoP.llenarMazo();
        mazoP.mezclarMazo();
        System.out.println("tamaño mazo al llenarlo: " + getMazoP().getMazoPrincipal().size());
    }

    public Carta mostrarPozo2 (){

          return cartaPozo;
    }

    public void setCartaPozo (){

        for (int i = 0; i <getMazoP().getMazoPrincipal().size() ; i++) {
            if (!"especial".equalsIgnoreCase(getMazoP().getMazoPrincipal().get(i).getTipo())){

            this.cartaPozo = getMazoP().getMazoPrincipal().get(i);
            getMazoP().removeCarta(getMazoP().getMazoPrincipal().size()-1);
            getPilaJugadas().agregarCartaIndividual(cartaPozo);
            break;
            }
        }

    }


    public Mazo getMazoP(){
        return mazoP;
    }

    public Mazo getPilaJugadas (){

        return pilaJugadas;
    }

    public ArrayList<Carta> generarMano2() {

        ArrayList<Carta> mano = new ArrayList<>();
        System.out.println("tamaño mazo antes de asignar cartas: " + getMazoP().getMazoPrincipal().size());

        for (int i = 0; i < tamañoMano; i++) {
            mano.add(getMazoP().getMazoPrincipal().get(i));
            getMazoP().removeCarta(i);
        }

        System.out.println("tamaño mazo después del for: " + getMazoP().getMazoPrincipal().size());
        System.out.println("tamaño mano: " + mano.size());
        return mano;
    }


}
