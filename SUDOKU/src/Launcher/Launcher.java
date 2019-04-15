package Launcher;

import presentacion.Modelo;


public class Launcher {
    //ATRIBUTOS
    private Modelo miSudo;
    //CONSTRUCTOR
    public Launcher() {

        miSudo = new Modelo();
        miSudo.iniciarVentana();
    }
    //METODO MAIN
    public static void main(String[] args) {
        new Launcher();
    }
}
