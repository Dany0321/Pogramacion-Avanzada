<?php
include("Logica.php");

$s = new Sudoku();

$dificultad = $_POST['dificultad'];
$s->setDificultad($dificultad);
$s->generar();
$sudoku = $s->getSudoku();

$datos = array(
    'estado' => 'ok',
    'matrizSudoku' => $sudoku,
    'dificultad' => $dificultad
);
 
echo json_encode($datos);

?>