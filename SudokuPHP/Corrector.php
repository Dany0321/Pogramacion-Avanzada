<?php
include("Logica.php");

$s = new Sudoku();

$matrizSolucion = $_POST['matriz'];
$solucion = $s->comprobarSolucion($matrizSolucion);

$datos = array(
    'estado' => 'ok',
    'solucion' => array_pop($solucion), 
    'resto' => $solucion,
    'prueba' => $matrizSolucion,
);
 
echo json_encode($datos);

?>