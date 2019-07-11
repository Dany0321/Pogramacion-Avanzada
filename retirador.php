<?php
    include ("Logica.php");

    $cantidad = json_decode($_POST['cantidad']);
    $usuario = $_POST['usuario'];

    $respuesta = Logica::retirarDinero($cantidad,$usuario);

    $datos = array(
        'estado' => 'ok',
        'res' => $respuesta,
    );
    
    echo json_encode($datos);


?>