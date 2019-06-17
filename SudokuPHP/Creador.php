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
);
 
echo json_encode($datos);

?>