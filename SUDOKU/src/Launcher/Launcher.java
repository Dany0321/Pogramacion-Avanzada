package Launcher;

import presentacion.Modelo;


public class Launcher {

    private Modelo miSudo;

    public Launcher() {

        miSudo = new Modelo();
        miSudo.iniciarVentana();
    }

    public static void main(String[] args) {
        new Launcher();
    }
}
