<?php
    include ("Logica.php");

    $contrau = $_POST['contrau'];
    $usuario = $_POST['usuario'];

    $respuesta = Logica::cambiarContra($usuario,$contrau);

    $datos = array(
        'estado' => 'ok',
        'res' => $respuesta,
    );
    
    echo json_encode($datos);


?>