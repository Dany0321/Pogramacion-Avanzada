<?php

    include("Logica.php");

    $informacion = $_POST['tarjeta'];

    $resultado = Logica::buscarTarjeta($informacion);

    $datos = array(
        'estado' => 'ok',
        'contra' => $resultado,
    );

    echo json_encode($datos);
?>