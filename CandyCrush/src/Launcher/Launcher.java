/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Launcher;

import Presentacion.Modelo;

/**
 *
 * @author Estudiantes
 */
public class Launcher {
    private Modelo miModelo;
    public Launcher(){
        miModelo = new Modelo();
        miModelo.iniciar();        
    }
    public static void main(String[] args) {
    new Launcher();   
    }
}
