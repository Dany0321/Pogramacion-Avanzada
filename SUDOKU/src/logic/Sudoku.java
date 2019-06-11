package logic;

import javax.swing.JOptionPane;

public class Sudoku implements Juego {

    //Atributos
    private int[][] Sudoku;
    private int dificultad;
    //Constructor

    public Sudoku() {
        dificultad = 45;
        Sudoku = new int[9][9];
    }

    //METODOS
    /**
     * Metodo para revisar si el numero ya se encuentra en el cuadrante
     *
     * @param cuadrante = numero entero que expresa el cuadrante que ingresa
     * @param numeroAleatorio = numero aleatorio generado para llenar el sudoku
     * @return boolean
     */
    public boolean comprobarEntradaCuadrante(int cuadrante, int numeroAleatorio) {
        switch (cuadrante) {
            case 1:
                if (this.comprobarExistencia(0, 2, 0, 2, numeroAleatorio)) {
                    return true;
                }
                ;
                break;
            case 2:
                if (this.comprobarExistencia(0, 2, 3, 5, numeroAleatorio)) {
                    return true;
                }
                ;
                break;
            case 3:
                if (this.comprobarExistencia(0, 2, 6, 8, numeroAleatorio)) {
                    return true;
                }
                ;
                break;
            case 4:
                if (this.comprobarExistencia(3, 5, 0, 2, numeroAleatorio)) {
                    return true;
                }
                ;
                break;
            case 5:
                if (this.comprobarExistencia(3, 5, 3, 5, numeroAleatorio)) {
                    return true;
                }
                ;
                break;
            case 6:
                if (this.comprobarExistencia(3, 5, 6, 8, numeroAleatorio)) {
                    return true;
                }
                ;
                break;
            case 7:
                if (this.comprobarExistencia(6, 8, 0, 2, numeroAleatorio)) {
                    return true;
                }
                ;
                break;
            case 8:
                if (this.comprobarExistencia(6, 8, 3, 5, numeroAleatorio)) {
                    return true;
                }
                ;
                break;
            case 9:
                if (this.comprobarExistencia(6, 8, 6, 8, numeroAleatorio)) {
                    return true;
                }
                ;
                break;
            default:
                return false;
        }
        return false;
    }

    /**
     * Metodo de sobrecarga utilizado en la solucion del usuario
     *
     * @param cuadrante = numero entero que expresa el cuadrante que ingresa
     * @param numeroAleatorio = numero aleatorio generado para llenar el sudoku
     * @param posibleSolucion = matriz llenada por el usuario para comprobar su
     * solucion
     * @param i = posicion filas
     * @param j = posicion columnas
     * @return
     */
    public boolean comprobarEntradaCuadrante(int cuadrante, int numeroAleatorio, int[][] posibleSolucion, int i, int j) {
        switch (cuadrante) {
            case 1:
                if (this.comprobarExistencia(0, 2, 0, 2, numeroAleatorio, posibleSolucion, i, j)) {
                    return true;
                }
                ;
                break;
            case 2:
                if (this.comprobarExistencia(0, 2, 3, 5, numeroAleatorio, posibleSolucion, i, j)) {
                    return true;
                }
                ;
                break;
            case 3:
                if (this.comprobarExistencia(0, 2, 6, 8, numeroAleatorio, posibleSolucion, i, j)) {
                    return true;
                }
                ;
                break;
            case 4:
                if (this.comprobarExistencia(3, 5, 0, 2, numeroAleatorio, posibleSolucion, i, j)) {
                    return true;
                }
                ;
                break;
            case 5:
                if (this.comprobarExistencia(3, 5, 3, 5, numeroAleatorio, posibleSolucion, i, j)) {
                    return true;
                }
                ;
                break;
            case 6:
                if (this.comprobarExistencia(3, 5, 6, 8, numeroAleatorio, posibleSolucion, i, j)) {
                    return true;
                }
                ;
                break;
            case 7:
                if (this.comprobarExistencia(6, 8, 0, 2, numeroAleatorio, posibleSolucion, i, j)) {
                    return true;
                }
                ;
                break;
            case 8:
                if (this.comprobarExistencia(6, 8, 3, 5, numeroAleatorio, posibleSolucion, i, j)) {
                    return true;
                }
                ;
                break;
            case 9:
                if (this.comprobarExistencia(6, 8, 6, 8, numeroAleatorio, posibleSolucion, i, j)) {
                    return true;
                }
                ;
                break;
            default:
                return false;
        }
        return false;
    }

    /**
     * Metodo para reconocer en qué cuadrante está el numero aleatorio
     *
     * @param fila = posicion en fila del numero
     * @param columna = posicion en columna del numero
     * @return cuadrante = entero que expresa el numero del cuadrante
     */
    public int conocerCuadrante(int fila, int columna) {
        int cuadrante = 0;
        if (fila >= 0 && fila <= 2 && columna >= 0 && columna <= 2) {
            cuadrante = 1;
        }
        if (fila >= 0 && fila <= 2 && columna >= 3 && columna <= 5) {
            cuadrante = 2;
        }
        if (fila >= 0 && fila <= 2 && columna >= 6 && columna <= 8) {
            cuadrante = 3;
        }
        if (fila >= 3 && fila <= 5 && columna >= 0 && columna <= 2) {
            cuadrante = 4;
        }
        if (fila >= 3 && fila <= 5 && columna >= 3 && columna <= 5) {
            cuadrante = 5;
        }
        if (fila >= 3 && fila <= 5 && columna >= 6 && columna <= 8) {
            cuadrante = 6;
        }
        if (fila >= 6 && fila <= 8 && columna >= 0 && columna <= 2) {
            cuadrante = 7;
        }
        if (fila >= 6 && fila <= 8 && columna >= 3 && columna <= 5) {
            cuadrante = 8;
        }
        if (fila >= 6 && fila <= 8 && columna >= 6 && columna <= 8) {
            cuadrante = 9;
        }
        return cuadrante;
    }

    /**
     * Metodo void que llena el sudoku de ceros
     */
    public void llenarSudokuCero() {
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 8; j++) {
                this.Sudoku[i][j] = 0;
            }
        }
    }

    /**
     * Metodo que busca ceros en la matriz y devuelve un true si lo encuentra
     *
     * @return boolean
     */
    public boolean buscarCeros() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (this.Sudoku[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Metodo que revisa si el numero se encuentra en alguna parte de la fila
     *
     * @param fila = posicion en fila del numero
     * @param numeroRevisar = numeroAleatorio que se quiere comparar en el resto
     * de la fila
     * @return boolean
     */
    public boolean comprobarFilas(int fila, int numeroRevisar) {
        for (int i = 0; i < 9; i++) {
            if (this.Sudoku[fila][i] == numeroRevisar) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que revisa si el numero se encuentra en alguna parte de la columna
     *
     * @param columna
     * @param numeroRevisar
     * @return
     */
    public boolean comprobarColumnas(int columna, int numeroRevisar) {
        for (int i = 0; i < 9; i++) {
            if (this.Sudoku[i][columna] == numeroRevisar) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo de sobrecarga que comprueba si el numero se encuentra en alguna
     * parte de la fila, (esto es para la solucion del usuario)
     *
     * @param fila = posicion en fila
     * @param numeroRevisar = numero aleatorio a revisar
     * @param posibleSolucion = solucion dada por el usuario
     * @param columna = posicion en columna
     * @return boolean
     */
    public boolean comprobarFilas(int fila, int numeroRevisar, int[][] posibleSolucion, int columna) {
        for (int i = 0; i < 9; i++) {
            if (i == columna) {
                continue;
            } else if (posibleSolucion[fila][i] == numeroRevisar) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo de sobrecarga que comprueba si el numero se encuentra en alguna
     * parte de la columna, (esto es para la solucion del usuario)
     *
     * @param fila = posicion en fila
     * @param numeroRevisar = numero aleatorio a revisar
     * @param posibleSolucion = solucion dada por el usuario
     * @param columna = posicion en columna
     * @return boolean
     *
     */
    public boolean comprobarColumnas(int columna, int numeroRevisar, int[][] posibleSolucion, int fila) {
        for (int i = 0; i < 9; i++) {
            if (i == fila) {
                continue;
            } else if (posibleSolucion[i][columna] == numeroRevisar) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que comprueba si el numero se encuentra en el cuadrante
     *
     * @param filaInicial = fila desde donde se va a analizar
     * @param filaFinal = fila hasta la que se va a analizar
     * @param columnaInicial = columna desde donde se va a revisar
     * @param columnaFinal = columna hasta la que se va a analizar
     * @param numero = numero que se comprueba
     * @return boolean
     */
    public boolean comprobarExistencia(int filaInicial, int filaFinal, int columnaInicial, int columnaFinal, int numero) {
        for (int i = filaInicial; i <= filaFinal; i++) {
            for (int j = columnaInicial; j <= columnaFinal; j++) {
                if (this.Sudoku[i][j] == numero) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Metodo de sobrecarga que comprueba si el numero existe en el cuadrante
     * (para la solucion del usuario)
     *
     * @param filaInicial = fila desde donde se va a analizar
     * @param filaFinal = fila hasta la que se va a analizar
     * @param columnaInicial = columna desde donde se va a revisar
     * @param columnaFinal = columna hasta la que se va a analizar
     * @param numero = numero que se comprueba
     * @param posibleSolucion = matriz solucion del usuario
     * @param x = posicion filas
     * @param d = posicion columnas
     * @return boolean
     */
    public boolean comprobarExistencia(int filaInicial, int filaFinal, int columnaInicial, int columnaFinal, int numero, int[][] posibleSolucion, int x, int d) {
        boolean resultado = false;
        for (int i = filaInicial; i <= filaFinal; i++) {
            for (int j = columnaInicial; j <= columnaFinal; j++) {
                if (i == x && j == d) {
                    continue;
                } else if (posibleSolucion[i][j] == numero) {
                    resultado = true;
                    return resultado;
                }
            }
        }
        return resultado;
    }

    /**
     * Metodo que genera el Sudoku que se envia a la vista
     */
    public void generar() {
        int fila, columna, cuadrante, numeroAleatorio;
        this.llenarSudokuCero();
        for (int i = 0; i < 17; i++) {
            while (true) {
                numeroAleatorio = (int) Math.ceil(Math.random() * 9);
                fila = (int) (Math.random() * 9);
                columna = (int) (Math.random() * 9);
                if (Sudoku[fila][columna] == 0) {
                    cuadrante = this.conocerCuadrante(fila, columna);
                    if (!this.comprobarEntradaCuadrante(cuadrante, numeroAleatorio)) {
                        if (!this.comprobarFilas(fila, numeroAleatorio)) {
                            if (!this.comprobarColumnas(columna, numeroAleatorio)) {
                                this.Sudoku[fila][columna] = numeroAleatorio;
                                break;

                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Metodo que comprueba la solucion dada por el usuario
     * @param posibleSolucion = matriaz solucion del usuario
     * @return 
     */
    public boolean comprobarSolucion(int[][] posibleSolucion) {
        int cuadrante, aciertos = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cuadrante = this.conocerCuadrante(i, j);
                if (!this.comprobarEntradaCuadrante(cuadrante, posibleSolucion[i][j], posibleSolucion, i, j)) {
                    if (!this.comprobarFilas(i, posibleSolucion[i][j], posibleSolucion, j)) {
                        if (!this.comprobarColumnas(j, posibleSolucion[i][j], posibleSolucion, i)) {
                            aciertos++;
                        } else {
                            System.out.println("La posision " + i + " " + j + " falla en columnas");
                        }
                    } else {
                        System.out.println("La posision " + i + " " + j + " falla en filas");
                    }
                } else {
                    System.out.println("La posision " + i + " " + j + " falla en cuadrante");
                }
            }
        }
        if (aciertos == 81) {
            return true;
        } else {
            return false;
        }
    }

    //METODOS GETTERS Y SETTERS
    
    /**
     * Metodo getter del atributo Sudoku
     *
     * @return int[][] Sudoku
     */
    public int[][] getSudoku() {
        return Sudoku;
    }

    /**
     * Metodo getter del atributo dificultad
     *
     * @return int dificultad
     */
    public int getDificultad() {
        return dificultad;
    }

    /**
     * Metodo setter del atributo dificultad
     *
     * @param dificultad = tiempo en minutos para el usuario
     */
    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }
}
