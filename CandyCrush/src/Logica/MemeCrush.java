/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Presentacion.Modelo;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                numeroAleatorio = (int) (Math.random() * 5);
                this.memeCrush[i][j] = numeroAleatorio;
            }
        }
    }

    /**
     * Sobrecarga de metodo para asignar nuevos numeros a la matriz una vez el
     * usuario pone una solucion
     */
    public void llenarAleatorio(int[][] matrizComprobante) {
        int numeroAleatorio;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (matrizComprobante[i][j] != 0) {
                    continue;
                }
                numeroAleatorio = (int) (Math.random() * 5) + 1;
                matrizComprobante[i][j] = numeroAleatorio;

            }
        }
    }

    public void corregirErrores() {
        boolean i = false;
        while (!i) {
            i = comprobarTODO();
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

    public boolean comprobarTODO() {
        boolean estado = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (comprobarHorizontal(i, j) || comprobarVertical(i, j)) {
                    memeCrush[i][j] = DarNumeroFuncional(i, j);
                    estado = false;
                }
            }
        }
        return estado;
    }

    public boolean comprobarVertical(int fila, int columna) {
        if (fila == 7 || fila == 8) {
            return false;
        } else {
            if ((this.memeCrush[fila][columna] == this.memeCrush[fila + 1][columna]) && (this.memeCrush[fila][columna] == this.memeCrush[fila + 2][columna])) {
                return true; // siginifca que encontro un error
            }
        }
        return false;
    }

    public boolean comprobarHorizontal(int fila, int columna) {
        if (columna == 7 || columna == 8) {
            return false;
        } else {
            if ((this.memeCrush[fila][columna] == this.memeCrush[fila][columna + 1]) && (this.memeCrush[fila][columna] == this.memeCrush[fila][columna + 2])) {
                return true; // siginifca que encontro un error
            }
        }
        return false;
    }

    public void imprimir(int[][] matrizComprobante) {
        for (int i = 0; i < matrizComprobante.length; i++) {
            System.out.print(" ");
            for (int j = 0; j < matrizComprobante[i].length; j++) {
                System.out.print(matrizComprobante[i][j]);
                if (j != matrizComprobante[i].length - 1) {
                    System.out.print("\t");
                }
            }
            System.out.println(" ");
        }
    }

    public void asignarMemes() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                try {
                    miMeme = new Meme(memeCrush[i][j]);
                } catch (IOException ex) {
                    Logger.getLogger(MemeCrush.class.getName()).log(Level.SEVERE, null, ex);
                }
                memeCrushImg[i][j] = miMeme;
            }
        }

    }

    /**
     * Metodo que busca en la matriz cuantos numeros hay seguidos en X y retorna
     * ese numero, para luego borrar eso en la matriz con otro metodo
     *
     * @param matrizComprobante matriz a verificar
     * @return int que expresa ese numero de veces para borrar
     */
    public int[] obtenerNumeroParaBorrarX(int[][] matrizComprobante) {
        int cont = 0;
        int posx = 0, posy = 0;
        int[] borrar = new int[3];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == 8) {
                    continue;
                }
                if (matrizComprobante[i][j] == matrizComprobante[i + 1][j]) {
                    cont = cont + 1;
                    if (cont == 1) {
                        posx = i;
                        posy = j;
                    }
                } else {
                    if (cont < 3) {
                        cont = 0;
                        posx = 0;
                        posy = 0;
                    }
                }

            }
        }
        System.out.println("x: " + cont);
        borrar[0] = cont;
        borrar[1] = posx;
        borrar[2] = posy;
        return borrar;
    }

    /**
     * Metodo que busca en la matriz cuantos numeros hay seguidos en Y y retorna
     * ese numero, para luego borrar eso en la matriz con otro metodo
     *
     * @param matrizComprobante matriz a verificar
     * @return int que expresa ese numero de veces para borrar
     */
    public int[] obtenerNumeroParaBorrarY(int[][] matrizComprobante) {
        int cont = 0;
        int posx = 0, posy = 0;
        int[] borrar = new int[3];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (j == 8) {
                    continue;
                }
                if (matrizComprobante[i][j] == matrizComprobante[i][j + 1]) {
                    cont = cont + 1;
                    if (cont == 1) {
                        posx = i;
                        posy = j;
                    }
                } else {
                    if (cont < 3) {
                        cont = 0;
                        posx = 0;
                        posy = 0;
                    }
                }
            }
        }
        System.out.println("y: " + cont);
        borrar[0] = cont;
        borrar[1] = posx;
        borrar[2] = posy;
        return borrar;
    }

    /**
     * Remplaza los meme que forman parte de la solucion por 0
     *
     * @param matrizComprobante matriz sobre la que se esta trabajando
     * @param posxUsuario coordenada en i a la que el usuario realizo el
     * movimiento
     * @param posyUsuario coordinada en j a la que el usuario realizo el
     * movimiento
     */
    public void borrarSoluciones(int[][] matrizComprobante, int posxUsuario, int posyUsuario) {
        int[] x = obtenerNumeroParaBorrarX(matrizComprobante);
        int[] y = obtenerNumeroParaBorrarY(matrizComprobante);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i != x[1] && j != x[2]) {
                    continue;
                }
                for (int k = 0; k < x[0]; k++) {
                    if (i == posxUsuario && j == posyUsuario) {
                        continue;
                    }
                    matrizComprobante[i + k][j] = 0;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i != y[1] && j != x[2]) {
                    continue;
                }
                for (int k = 0; k < y[0]; k++) {
                    if (i == posxUsuario && j == posyUsuario) {
                        continue;
                    }
                    matrizComprobante[i][j + k] = 0;
                }
            }
        }
        matrizComprobante[posxUsuario][posyUsuario] = 0;
    }

    //HAY QUE HACER UN METODO PARA SUBIR LOS CEROS, recorrer la matriz en busca de 0 (exeptuando la primera fila)
    //si encuentra un cero lo cambia con el que tenga arriba y aumenta el valor de un contador cuando termina el metodo
    //si el contador es mayor a 0 entonces lo vuevle a ejecutar (esto asegura que todos los 0 esten en la parte de mas arriba que puedan estar
    /**
     * Metodo que pone los ceros que encuentra en la parte superior de la matriz
     * *
     */
    public void subirCeros(int[][] matrizComprobante) {
        int cont = 0, numeroGuardado = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == 0) {
                    continue;
                }
                if (matrizComprobante[i][j] == 0) {
                    numeroGuardado = matrizComprobante[i - 1][j];
                    matrizComprobante[i][j] = numeroGuardado;
                    if (matrizComprobante[i - 1][j] != 0) {
                        cont++;
                    }
                    matrizComprobante[i - 1][j] = 0;
                }
            }

        }
        if (cont != 0) {
            this.subirCeros(matrizComprobante);
        }

    }
    /**
     * Metodo que comprueba si el cambio hecho por el usuario es valido NUMERICAMENTE     
     */
    public boolean comprobarValidezDeCambioNumerico(int[][] matrizComprobante){
        int SolucionesEnX[] = this.obtenerNumeroParaBorrarX(matrizComprobante);
        int SolucionesEnY[] = this.obtenerNumeroParaBorrarY(matrizComprobante);
        if (SolucionesEnX[0]==0 && SolucionesEnY[0]==0 ){
            return false;            
        }else{
            return true;
        }        
    }

    //GETTERS Y SETTERS
    public Meme[][] getMemeCrushImg() {
        return memeCrushImg;
    }

    public int[][] getMemeCrush() {
        return memeCrush;
    }

}
