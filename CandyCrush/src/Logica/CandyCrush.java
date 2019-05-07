/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author ldani
 */
public class CandyCrush {

    //ATRIBUTOS
    private int[][] candyCrush = new int[9][9];

    //METODOS  
    public void llenarAleatorio() {
        int numeroAleatorio;
        for (int i = 0; i < this.candyCrush.length; i++) {
            for (int j = 0; j < this.candyCrush.length; j++) {
                numeroAleatorio = (int) (Math.random() * 5) + 1;
                this.candyCrush[i][j] = numeroAleatorio;
            }
        }
    }

    public void corregirErrores() {
        for (int i = 0; i < this.candyCrush.length; i++) {
            for (int j = 0; j < this.candyCrush.length; j++) {
                if (!this.comprobarHorizontal(i, j)) {
                   this.candyCrush[i][j] = this.DarNumeroFuncional(i, j);
                }
                if (!this.comprobarVertical(i, j)){
                    this.candyCrush[i][j] = this.DarNumeroFuncional(i, j);
                }

            }
        }
    }

    public int DarNumeroFuncional(int fila, int columna) {
        while (true) {
            int n = (int) (Math.random() * 5) + 1;
            if (this.candyCrush[fila][columna] != n) {
                return n;
            }
        }
    }

    public boolean comprobarVertical(int fila, int columna) {
        if (fila == 7 || fila == 8) {
            return true;
        } else {
            if ((this.candyCrush[fila][columna] == this.candyCrush[fila+1][columna]) && (this.candyCrush[fila][columna] == this.candyCrush[fila+2][columna])) {
                return false; //significa que hay solucion vertical, osea que no esta bien
            }
        }
        return true;
    }

    public boolean comprobarHorizontal(int fila, int columna) {
        if (columna == 7 || columna == 8) {
            return true;
        } else {
            if ((this.candyCrush[fila][columna] == this.candyCrush[fila][columna + 1]) && (this.candyCrush[fila][columna] == this.candyCrush[fila][columna + 2])) {
                return false; //significa que hay solucion horizontal, osea que no esta bien
            }
        }
        return true;
    }

    public void imprimir() {
        for (int i = 0; i < this.candyCrush.length; i++) {
            System.out.print(" ");
            for (int j = 0; j < this.candyCrush[i].length; j++) {
                System.out.print(this.candyCrush[i][j]);
                if (j != this.candyCrush[i].length - 1) {
                    System.out.print("\t");
                }
            }
            System.out.println(" ");
        }
    }

    
}
