<?php

public class sudoku{
    private  $Dificultad;
    private  $Sudoku;

    function __construct() {
        $Dificultad = 45;
        $Sudoku = [][];
    }

    /**
     * Metodo para revisar si el numero ya se encuentra en el cuadrante
     *
     * @param cuadrante = numero entero que expresa el cuadrante que ingresa
     * @param numeroAleatorio = numero aleatorio generado para llenar el sudoku
     * @return boolean
     */
    public function comprobarEntradaCuadrante($cuadrante,$numeroAleatorio){
        switch($cuadrante){
            case 1:
                if ($this->comprobarExistencia(0, 2, 0, 2, $numeroAleatorio)) {
                    return true;
                }
                ;
                break;                
            case 2:
                if ($this->comprobarExistencia(0, 2, 3, 5, $numeroAleatorio)) {
                    return true;
                }
                ;
                break;
            case 3:
                if ($this->comprobarExistencia(0, 2, 6, 8, $numeroAleatorio)) {
                    return true;
                }
                ;
                break;
            case 4:
                if ($this->comprobarExistencia(3, 5, 0, 2, $numeroAleatorio)) {
                    return true;
                }
                ;
                break;
            case 5:
                if ($this->comprobarExistencia(3, 5, 3, 5, $numeroAleatorio)) {
                    return true;
                }
                ;
                break;
            case 6:
                if ($this->comprobarExistencia(3, 5, 6, 8, $numeroAleatorio)) {
                    return true;
                }
                ;
                break;
            case 7:
                if ($this->comprobarExistencia(6, 8, 0, 2, $numeroAleatorio)) {
                    return true;
                }
                ;
                break;
            case 8:
                if ($this->comprobarExistencia(6, 8, 3, 5, $numeroAleatorio)) {
                    return true;
                }
                ;
                break;
            case 9:
                if ($this->comprobarExistencia(6, 8, 6, 8, $numeroAleatorio)) {
                    return true;
                }
                ;
                break;
            default:
                return false;
        }
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
    public function comprobarEntradaCuadrante($cuadrante,$numeroAleatorio,$posibleSolucion,$i,$j){
        switch ($cuadrante) {
            case 1:
                if ($this->comprobarExistencia(0, 2, 0, 2, $numeroAleatorio, $posibleSolucion, i, j)) {
                    return true;
                }
                ;
                break;
            case 2:
                if ($this->comprobarExistencia(0, 2, 3, 5, $numeroAleatorio, $posibleSolucion, i, j)) {
                    return true;
                }
                ;
                break;
            case 3:
                if ($this->comprobarExistencia(0, 2, 6, 8, $numeroAleatorio, $posibleSolucion, i, j)) {
                    return true;
                }
                ;
                break;
            case 4:
                if ($this->comprobarExistencia(3, 5, 0, 2, $numeroAleatorio, $posibleSolucion, i, j)) {
                    return true;
                }
                ;
                break;
            case 5:
                if ($this->comprobarExistencia(3, 5, 3, 5, $numeroAleatorio, $posibleSolucion, i, j)) {
                    return true;
                }
                ;
                break;
            case 6:
                if ($this->comprobarExistencia(3, 5, 6, 8, $numeroAleatorio, $posibleSolucion, i, j)) {
                    return true;
                }
                ;
                break;
            case 7:
                if ($this->comprobarExistencia(6, 8, 0, 2, $numeroAleatorio, $posibleSolucion, i, j)) {
                    return true;
                }
                ;
                break;
            case 8:
                if ($this->comprobarExistencia(6, 8, 3, 5, $numeroAleatorio, $posibleSolucion, i, j)) {
                    return true;
                }
                ;
                break;
            case 9:
                if ($this->comprobarExistencia(6, 8, 6, 8, $numeroAleatorio, $posibleSolucion, i, j)) {
                    return true;
                }
                ;
                break;
            default:
                return false;
        }
        return false;
    }

    public function conocerCuadrante($fila, $columna) {
        $cuadrante = 0;
        if ($fila >= 0 && $fila <= 2 && $columna >= 0 && $columna <= 2) {
            $cuadrante = 1;
        }
        if ($fila >= 0 && $fila <= 2 && $columna >= 3 && $columna <= 5) {
            $cuadrante = 2;
        }
        if ($fila >= 0 && $fila <= 2 && $columna >= 6 && $columna <= 8) {
            $cuadrante = 3;
        }
        if ($fila >= 3 && $fila <= 5 && $columna >= 0 && $columna <= 2) {
            $cuadrante = 4;
        }
        if ($fila >= 3 && $fila <= 5 && $columna >= 3 && $columna <= 5) {
            $cuadrante = 5;
        }
        if ($fila >= 3 && $fila <= 5 && $columna >= 6 && $columna <= 8) {
            $cuadrante = 6;
        }
        if ($fila >= 6 && $fila <= 8 && $columna >= 0 && $columna <= 2) {
            $cuadrante = 7;
        }
        if ($fila >= 6 && $fila <= 8 && $columna >= 3 && $columna <= 5) {
            $cuadrante = 8;
        }
        if ($fila >= 6 && $fila <= 8 && $columna >= 6 && $columna <= 8) {
            $cuadrante = 9;
        }
        return $cuadrante;
    }

    public function llenarSudokuCero() {
        for ($i = 0; $i <= 8; $i++) {
            for ($j = 0; $j <= 8; $j++) {
                $Sudoku[i][j] = 0;
            }
        }
    }

    public function buscarCeros() {
        for (int $i = 0; $i < 10; $i++) {
            for (int $j = 0; $j < 10; $j++) {
                if ($Sudoku[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public function comprobarFilas($fila, $numeroRevisar) {
        for ($i = 0; $i < 9; $i++) {
            if ($Sudoku[$fila][$i] == $numeroRevisar) {
                return true;
            }
        }
        return false;
    }

    public function comprobarColumnas($columna, $numeroRevisar) {
        for ($i = 0; $i < 9; $i++) {
            if ($Sudoku[$i][$columna] == $numeroRevisar) {
                return true;
            }
        }
        return false;
    }

    public function comprobarFilas($fila, $numeroRevisar, $posibleSolucion, $columna) {
        for ($i = 0; $i < 9; $i++) {
            if ($i == $columna) {
                continue;
            } else if ($posibleSolucion[$fila][$i] == $numeroRevisar) {
                return true;
            }
        }
        return false;
    }

    public function comprobarColumnas($columna, $numeroRevisar, $posibleSolucion, $fila) {
        for ( $i = 0; $i < 9; $i++) {
            if ($i == $fila) {
                continue;
            } else if ($posibleSolucion[$i][$columna] == $numeroRevisar) {
                return true;
            }
        }
        return false;
    }

    public function comprobarExistencia($filaInicial, $filaFinal, $columnaInicial, $columnaFinal, $numero, $posibleSolucion, $x, $d) {
        boolean $resultado = false;
        for ( $i = $filaInicial; $i <= $filaFinal; $i++) {
            for ($j = $columnaInicial; $j <= $columnaFinal; $j++) {
                if ($i == $x && $j == $d) {
                    continue;
                } else if ($posibleSolucion[$i][$j] == $numero) {
                    $resultado = true;
                    return $resultado;
                }
            }
        }
        return $resultado;
    }

    /**
     * Metodo para comprobar la existencia de un numero en el cuadrante
     */
    public function comprobarExistencia($filaInicial,$filaFinal,$columnaInicial,$columnaFinal,$numero){
        for($i = $filaInicial;$i <= $filaFinal;$i++){
            for($j = $columnaInicial; $j<=$columnaFinal;$j++){
                if($Sudoku[i][j] == $numero){
                    return true;
                }                
            }
        }
        return false;
    }

    public function generar() {
         $fila, $columna, $cuadrante, $numeroAleatorio;
        $this->llenarSudokuCero();
        for ($i = 0; $i < 17; $i++) {
            while (true) {
                $numeroAleatorio = rand(1,9);
                $fila = rand(0,8);
                $columna = rand(0,8);
                if ($Sudoku[$fila][$columna] == 0) {
                    $cuadrante = $this->conocerCuadrante($fila, $columna);
                    if (!$this->comprobarEntradaCuadrante($cuadrante, $numeroAleatorio)) {
                        if (!$this->comprobarFilas($fila, $numeroAleatorio)) {
                            if (!$this.comprobarColumnas($columna, $numeroAleatorio)) {
                                $this->$Sudoku[$fila][$columna] = $numeroAleatorio;
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public function comprobarSolucion($posibleSolucion) {
        $cuadrante, $aciertos = 0;
        for ($i = 0; $i < 9; $i++) {
            for ($j = 0; $j < 9; $j++) {
                $cuadrante = $this->conocerCuadrante($i, $j);
                if (!$this->comprobarEntradaCuadrante($cuadrante, $posibleSolucion[i][j], $posibleSolucion, $i, $j)) {
                    if (!$this->comprobarFilas($i, $posibleSolucion[$i][$j], $posibleSolucion, $j)) {
                        if (!$this->comprobarColumnas($j, $posibleSolucion[$i][$j], $posibleSolucion, $i)) {
                            $aciertos++;
                        } else {
                            echo("La posision " + i + " " + j + " falla en columnas");
                        }
                    } else {
                        echo("La posision " + i + " " + j + " falla en filas");
                    }
                } else {
                    echo("La posision " + i + " " + j + " falla en cuadrante");
                }
            }
        }
        if ($aciertos == 81) {
            return true;
        } else {
            return false;
        }
    }

    public function getSudoku() {
        return $Sudoku;
    }

    public function getDificultad() {
        return $dificultad;
    }

    public function setDificultad($dificultad) {
        $this->dificultad = $dificultad;
    }

}

?>