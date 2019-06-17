<?php
error_reporting(E_ALL ^ E_NOTICE);
class Sudoku{
    private  $Dificultad;
    private  $Sudoku;

    function __construct() {
        $Dificultad = 45;
        $Sudoku = [];
    }

    public function __call($metodo,$argumentos){
        if($metodo == "comprobarEntradaCuadrante"){
            if (count($argumentos) == 2){
                switch($argumentos[0]){
                    case 1:
                        if ($this->comprobarExistencia(0, 2, 0, 2, $argumentos[1])) {
                            return true;
                        }
                        ;
                        break;                
                    case 2:
                        if ($this->comprobarExistencia(0, 2, 3, 5, $argumentos[1])) {
                            return true;
                        }
                        ;
                        break;
                    case 3:
                        if ($this->comprobarExistencia(0, 2, 6, 8, $argumentos[1])) {
                            return true;
                        }
                        ;
                        break;
                    case 4:
                        if ($this->comprobarExistencia(3, 5, 0, 2, $argumentos[1])) {
                            return true;
                        }
                        ;
                        break;
                    case 5:
                        if ($this->comprobarExistencia(3, 5, 3, 5, $argumentos[1])) {
                            return true;
                        }
                        ;
                        break;
                    case 6:
                        if ($this->comprobarExistencia(3, 5, 6, 8, $argumentos[1])) {
                            return true;
                        }
                        ;
                        break;
                    case 7:
                        if ($this->comprobarExistencia(6, 8, 0, 2, $argumentos[1])) {
                            return true;
                        }
                        ;
                        break;
                    case 8:
                        if ($this->comprobarExistencia(6, 8, 3, 5, $argumentos[1])) {
                            return true;
                        }
                        ;
                        break;
                    case 9:
                        if ($this->comprobarExistencia(6, 8, 6, 8,$argumentos[1])) {
                            return true;
                        }
                        ;
                        break;
                    default:
                        return false;
            }
        }elseif(count($argumentos) == 5){
            switch ($argumentos[0]) {
                case 1:
                    if ($this->comprobarExistencia(0, 2, 0, 2, $argumentos[1], $argumentos[2], $argumentos[3], $argumentos[4])) {
                        return true;
                    }
                    ;
                    break;
                case 2:
                    if ($this->comprobarExistencia(0, 2, 3, 5, $argumentos[1], $argumentos[2], $argumentos[3], $argumentos[4])) {
                        return true;
                    }
                    ;
                    break;
                case 3:
                    if ($this->comprobarExistencia(0, 2, 6, 8, $argumentos[1], $argumentos[2], $argumentos[3], $argumentos[4])) {
                        return true;
                    }
                    ;
                    break;
                case 4:
                    if ($this->comprobarExistencia(3, 5, 0, 2, $argumentos[1], $argumentos[2], $argumentos[3], $argumentos[4])) {
                        return true;
                    }
                    ;
                    break;
                case 5:
                    if ($this->comprobarExistencia(3, 5, 3, 5, $argumentos[1], $argumentos[2], $argumentos[3], $argumentos[4])) {
                        return true;
                    }
                    ;
                    break;
                case 6:
                    if ($this->comprobarExistencia(3, 5, 6, 8, $argumentos[1], $argumentos[2], $argumentos[3], $argumentos[4])) {
                        return true;
                    }
                    ;
                    break;
                case 7:
                    if ($this->comprobarExistencia(6, 8, 0, 2, $argumentos[1], $argumentos[2], $argumentos[3], $argumentos[4])) {
                        return true;
                    }
                    ;
                    break;
                case 8:
                    if ($this->comprobarExistencia(6, 8, 3, 5, $argumentos[1], $argumentos[2], $argumentos[3], $argumentos[4])) {
                        return true;
                    }
                    ;
                    break;
                case 9:
                    if ($this->comprobarExistencia(6, 8, 6, 8, $argumentos[1], $argumentos[2], $argumentos[3], $argumentos[4])) {
                        return true;
                    }
                    ;
                    break;
                default:
                    return false;
            }
        }

    }elseif($metodo == "comprobarFilas"){
        if (count($argumentos) == 2){
            for ($i = 0; $i < 9; $i++) {
                if ($this->$Sudoku[$argumentos[0]][$i] == $argumentos[1]) {
                    return true;
                }
            }
            return false;
        }elseif(count($argumentos) == 4){
            for ($i = 0; $i < 9; $i++) {
                if ($i == $argumentos[3]) {
                    continue;
                } else if ($argumentos[2][$argumentos[0]][$i] == $argumentos[1]) {
                    return true;
                }
            }
            return false;
        }
    }elseif($metodo == "comprobarColumnas"){
        if (count($argumentos) == 2){
            for ($i = 0; $i < 9; $i++) {
                if ($this->$Sudoku[$i][$argumentos[0]] == $argumentos[1]) {
                    return true;
                }
            }
            return false;
        }elseif(count($argumentos) == 4){
            for ($i = 0; $i < 9; $i++) {
                if ($i == $argumentos[3]) {
                    continue;
                } else if ($argumentos[2][$i][$argumentos[0]] == $argumentos[1]) {
                    return true;
                }
            }
            return false;
        }
        }elseif($metodo = "comprobarExistencia"){
            if (count($argumentos) == 8){
                $resultado = false;
            for ( $i = $argumentos[0]; $i <= $argumentos[1]; $i++) {
                for ($j = $argumentos[2]; $j <= $argumentos[3]; $j++) {
                    if ($i == $argumentos[6] && $j == $argumentos[7]) {
                        continue;
                    } else if ($argumentos[5][$i][$j] == $argumentos[4]) {
                        $resultado = true;
                        return $resultado;
                    }
                
                }
                return $resultado;
            }
        }elseif(count($argumentos) == 5){
            for($i = $argumentos[0];$i <= $argumentos[1];$i++){
                for($j = $argumentos[2]; $j<=$argumentos[3];$j++){
                    if($this->$Sudoku[$i][$j] == $argumentos[4]){
                        return true;
                    }                
                }
            }
            return false;
        }
    }
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
                $this->$Sudoku[$i][$j] = 0;
            }
        }
    }

    public function buscarCeros() {
        for ($i = 0; $i < 10; $i++) {
            for ($j = 0; $j < 10; $j++) {
                if ($this->$Sudoku[$i][$j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public function generar() {
        $this->llenarSudokuCero();
        for ($i = 0; $i < 17; $i++) {
            while (true) {
                $numeroAleatorio = rand(1,9);
                $fila = rand(0,8);
                $columna = rand(0,8);
                if ($this->$Sudoku[$fila][$columna] == 0) {
                    $cuadrante = $this->conocerCuadrante($fila, $columna);
                    if (!$this->comprobarEntradaCuadrante($cuadrante, $numeroAleatorio)) {
                        if (!$this->comprobarFilas($fila, $numeroAleatorio)) {
                            if (!$this->comprobarColumnas($columna, $numeroAleatorio)) {
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
        $cuadrante = 0;
        $aciertos = 0;
        $pareja = array();
        for ($i = 0; $i < 9; $i++) {
            for ($j = 0; $j < 9; $j++) {
                $cuadrante = $this->conocerCuadrante($i, $j);
                if (!$this->comprobarEntradaCuadrante($cuadrante, $posibleSolucion[$i][$j], $posibleSolucion, $i, $j)) {
                    if (!$this->comprobarFilas($i, $posibleSolucion[$i][$j], $posibleSolucion, $j)) {
                        if (!$this->comprobarColumnas($j, $posibleSolucion[$i][$j], $posibleSolucion, $i)) {
                            $aciertos++;
                        } else {
                            array_push($pareja,$i);
                            array_push($pareja,$j);
                            array_push($pareja,$s = "col"); 
                        }
                    } else {
                        array_push($pareja,$i);
                        array_push($pareja,$j); 
                        array_push($pareja,$s = "fil");  
                    }
                } else {
                    array_push($pareja,$i);
                    array_push($pareja,$j);
                    array_push($pareja,$s = "cua");  
                }
            }
        }
        if ($aciertos == 81) {
            $a = 1;
            array_push($pareja,$a);
            return $pareja;
        } else {
            $a = 0;
            array_push($pareja,$a);
            return $pareja;
        }
    }

    public function getSudoku() {
        return $this->$Sudoku;
    }

    public function getDificultad() {
        return $dificultad;
    }

    public function setDificultad($dificultad1) {
        $dificultad = $dificultad1;
    }
}
?>