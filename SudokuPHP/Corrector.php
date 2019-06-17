<?php
include("Logica.php");

$s = new Sudoku();

$matrizSolucion = $_POST['matriz'];
$matrizSolucion = json_decode($matrizSolucion,true);
$solucion = $s->comprobarSolucion($matrizSolucion);

$datos = array(
    'estado' => 'ok',
    'solucion' => array_pop($solucion), 
    'resto' => $solucion,
    'prueba' => $matrizSolucion,
);
 
echo json_encode($datos);

function pasarAMatriz($string){
    $arrays = str_split($matrizSolucion);
    $matriz = [];
    for($i=0; $i<81;$i++){
        if($arrays[$i]==","){
            continue;
        }
        $array[$i] = (int) $arrays[$i];
    }
    $contador = 0;
    for($i=0;$i<9;$i++){
        for($j=0;$j<9;$j++){
            $matriz[$i][$j] = $array[$contador];
        }
        $contador = 0;
    }
    return $matriz;
}
?>