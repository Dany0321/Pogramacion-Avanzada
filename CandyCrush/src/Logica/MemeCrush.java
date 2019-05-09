/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Presentacion.Modelo;

/**
 *
 * @author ldani
 */
public class MemeCrush {

    //ATRIBUTOS
    private int[][] memeCrush = new int[9][9];
    private Meme[][] memeCrushImg = new Meme[9][9];
    private Meme miMeme;

    
    //METODOS  
    public void llenarAleatorio() {
        int numeroAleatorio;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                numeroAleatorio = (int) (Math.random() * 5) + 1;
                this.memeCrush[i][j] = numeroAleatorio;
            }
        }
    }

    public void corregirErrores() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!this.comprobarHorizontal(i, j)) {
                   this.memeCrush[i][j] = this.DarNumeroFuncional(i, j);
                }
                if (!this.comprobarVertical(i, j)){
                    this.memeCrush[i][j] = this.DarNumeroFuncional(i, j);
                }

            }
        }
    }

    public int DarNumeroFuncional(int fila, int columna) {
        while (true) {
            int n = (int) (Math.random() * 5) + 1;
            if (this.memeCrush[fila][columna] != n) {
                return n;
            }
        }
    }

    public boolean comprobarVertical(int fila, int columna) {
        if (fila == 7 || fila == 8) {
            return true;
        } else {
            if ((this.memeCrush[fila][columna] == this.memeCrush[fila+1][columna]) && (this.memeCrush[fila][columna] == this.memeCrush[fila+2][columna])) {
                return false; //significa que hay solucion vertical, osea que no esta bien
            }
        }
        return true;
    }

    public boolean comprobarHorizontal(int fila, int columna) {
        if (columna == 7 || columna == 8) {
            return true;
        } else {
            if ((this.memeCrush[fila][columna] == this.memeCrush[fila][columna + 1]) && (this.memeCrush[fila][columna] == this.memeCrush[fila][columna + 2])) {
                return false; //significa que hay solucion horizontal, osea que no esta bien
            }
        }
        return true;
    }

    public void imprimir() {
        for (int i = 0; i < this.memeCrush.length; i++) {
            System.out.print(" ");
            for (int j = 0; j < this.memeCrush[i].length; j++) {
                System.out.print(this.memeCrush[i][j]);
                if (j != this.memeCrush[i].length - 1) {
                    System.out.print("\t");
                }
            }
            System.out.println(" ");
        }
    }
    
    public void asignarMemes(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                miMeme = new Meme(memeCrush[i][j]);
                memeCrushImg[i][j] = miMeme;
            }
        }
        
    }
    //GETTERS Y SETTERS

    public Meme[][] getMemeCrushImg() {
        return memeCrushImg;
    }
    
    

    
}
