<?php

public class sudoku{
    private  $Dificultad;
    private  $Sudoku;

    function __construct() {
        $Dificultad = 45;
        $Sudoku = [][];
    }

    function comprobarExistencia($filaInicial,$filaFinal,$columnaInicial,$columnaFinal,$numero){
        for($i = $filaInicial;$i <= $filaFinal;$i++){
            for($j = $columnaInicial; $j<=$columnaFinal;$j++){
                if($Sudoku[i][j] == $numero){
                    return true;
                }
            }
        }
        return false;
    }

}

?>