<?php
    include ("Logica.php");

    $usuario = $_POST['usuario'];

    $respuesta = Logica::consultarSaldo($usuario);
    $datos = array(
        'estado' => 'ok',
        'res' => $respuesta,
    );
    
    echo json_encode($datos);


?>