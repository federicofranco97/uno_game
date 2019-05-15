package Juego;

import javax.swing.JOptionPane;

public class MenuPrincipal {
    
    public void jugar(){
        //Falta agregar el texto del menu.
        int choice=Integer.parseInt(JOptionPane.showInputDialog("Menu principal"));
        if(choice==1){
            Partida partida = new Partida();
        }
        if(choice==2){
            Partida2 partida2 = new Partida2();
        }
            
    }
    public static void main(String[] args) {
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.jugar();
     
    }
}
