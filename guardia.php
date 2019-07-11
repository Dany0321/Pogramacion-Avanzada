<?php

include("Logica.php");

$contrau = $_POST['contraU'];
$usuario = $_POST['usuario'];
$resultado = Logica::confirmarContraseña($usuario,$contrau);

$datos = array(
    'estado' => 'ok',
    'res' => $resultado,
);

echo json_encode($datos);

?>