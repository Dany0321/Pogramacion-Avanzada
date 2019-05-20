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
import jdk.nashorn.internal.ir.ContinueNode;

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
        memeCrush = matrizComprobante;
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

    //ARRGELAR ESTE METODO, CUANDO ENCUENTRE TRES SEGUIDOS, LOS BORRA. lUEGO PREGUNTA SI EL NUMERO QUE ESTA SIENDO EVALUADO ES != 0 Y SI LO ES 
    //PREGUNTA SI EL NUMERO ANTERIOR ES 0, SI ESTO SE CUMPLE SE GUARDA EL VALOR QUE ESTA SIENDO EVALUADO EN UNA VARABLE N, Y SE REEMPLAZA ESA POSICION POR 0
    //LUEGO SE VUELVE A PREGUNTAR EN EL SIGUIENTE DE LA MISMA FORMA QUE EN EL PUNTO ANTERIOR, ASI ENCONTRARA TODOS LOS QUE SEAN IGUALES EN UNA FILA
    
    public int [][] clonarMatriz(int[][] matrizComprobante){
        int[][] m = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                m[i][j] = matrizComprobante[i][j];
            }
        }
        return m;
    }
    
    public int [][] borrarEnX(int[][] matrizComprobante) {
        int numeroGuardado=0;
        int[][] matrizDeX = clonarMatriz(matrizComprobante);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
               
                if (matrizDeX[i][j]==0)
                    continue;
                if ((j!=7 && j!=8) && (matrizDeX[i][j]== matrizDeX[i][j+1] && matrizDeX[i][j]== matrizDeX[i][j+2])){
                    numeroGuardado= matrizDeX[i][j];
                    borrador(i,j,matrizDeX);
                    borrador(i, j+1, matrizDeX);
                    borrador(i, j+2, matrizDeX);                    
                }
                if (j!=0 && (matrizDeX[i][j-1]==0)){
                    if(matrizDeX[i][j]==numeroGuardado){
                        borrador(i, j, matrizDeX);
                    }else{
                        continue;
                    }
                }
                
            }
        }
        return matrizDeX;
    }
    
    public int [][] borrarEnY(int[][] matrizComprobante) {
        int numeroGuardado=0;
        int[][] matrizDeY = clonarMatriz(matrizComprobante);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (matrizDeY[i][j]==0)
                    continue;
                if ((i!=7 && i!=8) && (matrizDeY[i][j]== matrizDeY[i+1][j] && matrizDeY[i][j]== matrizDeY[i+2][j])){
                    numeroGuardado= matrizDeY[i][j];
                    borrador(i,j,matrizDeY);
                    borrador(i+1, j, matrizDeY);
                    borrador(i+2, j, matrizDeY);                    
                }
                if (i!=0 && (matrizDeY[i-1][j]==0)){
                    if(matrizDeY[i][j]==numeroGuardado){
                        borrador(i, j, matrizDeY);
                    }else{
                        continue;
                    }
                }
                
            }
        }
        return matrizDeY;
    }
    
    /**
     * Metodo que fusiona las matrices que borran las soluciones en X y Y
     *
     * @param matrizComprobante
     * @return matriz con las soluciones = a 0
     */
    
    public  int [][] BorrarSoluciones(int[][] matrizComprobante){
        int[][] m = clonarMatriz(matrizComprobante);
        int[][] matrizDeY = borrarEnY(matrizComprobante);
        int[][] matrizDeX = borrarEnX(matrizComprobante);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (matrizDeX[i][j] == matrizDeY[i][j]){
                    continue;
                }else{
                    m[i][j] = 0;
                }
            }
        }
        memeCrush = m;
        return m;
    }
    
    public int contarSoluciones(int[][] matrizComprobante){
        int cont=0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (matrizComprobante[i][j]==0){
                    cont++;
                }
            }
        }
        
        return cont;
    }
    
    public boolean ComprobarExistenciarSolucionEnX(int[][] matrizComprobante) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (matrizComprobante[i][j]==0)
                    continue;
                if ((j!=7 && j!=8) && (matrizComprobante[i][j]== matrizComprobante[i][j+1] && matrizComprobante[i][j]== matrizComprobante[i][j+2])){
                    return true;
                } 
            }
        }
        return false;
    }
    
    public boolean ComprobarExistenciarSolucionEnY(int[][] matrizComprobante) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (matrizComprobante[i][j]==0)
                    continue;
                if ((i!=7 && i!=8) && (matrizComprobante[i][j]== matrizComprobante[i+1][j] && matrizComprobante[i][j]== matrizComprobante[i+2][j])){
                    return true;
                } 
            }
        }
        return false;
    }
    /**
     * Metodo que comprueba si el cambio hecho por el usuario es valido
     * NUMERICAMENTE
     */
    public boolean ComprobarExistenciaSolucion(int[][] matrizComprobante){
        if(ComprobarExistenciarSolucionEnX(matrizComprobante) || ComprobarExistenciarSolucionEnY(matrizComprobante))
            return true;
        return false;
    }

    /**
     * Metodo que busca en la matriz cuantos numeros hay seguidos en Y y retorna
     * ese numero, para luego borrar eso en la matriz con otro metodo
     *
     * @param matrizComprobante matriz a verificar
     * @return int que expresa ese numero de veces para borrar
     */

    /**
     * Remplaza los meme que forman parte de la solucion por 0
     *
     * @param matrizComprobante matriz sobre la que se esta trabajando
     * @param posxUsuario coordenada en i a la que el usuario realizo el
     * movimiento
     * @param posyUsuario coordinada en j a la que el usuario realizo el
     * movimiento
     */

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
        memeCrush = matrizComprobante;
    }

    


    //GETTERS Y SETTERS
    public Meme[][] getMemeCrushImg() {
        return memeCrushImg;
    }

    public int[][] getMemeCrush() {
        return memeCrush;
    }

    private void borrador(int i, int j, int [][] matriz) {
        matriz[i][j]=0;
    }

    public void setMemeCrush(int[][] memeCrush) {
        this.memeCrush = memeCrush;
    }
    
    

}
