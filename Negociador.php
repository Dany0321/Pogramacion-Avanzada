<?php

    include("Logica.php");

    $informacion = $_POST['tarjeta'];
    $resultado = Logica::buscarTarjeta($informacion);
    $nombre = "defaut";
    if(file_exists("basura.txt")){
        $fichero = fopen("basura.txt","r");
        $fichero2 = fopen("basura2.txt","r");
        $resultado = fgets($fichero);
        $nombre = fgets($fichero2);
        fclose($fichero);
        fclose($fichero2);
        unlink("basura.txt");
        unlink("basura2.txt");
    }else if($informacion != "basura"){
        $fichero = fopen("basura.txt","c+");
        $fichero2 = fopen("basura2.txt","c+");
        $nombre = $informacion;
        fputs($fichero2,$nombre);
        fputs($fichero,$resultado);
        fclose($fichero);
        fclose($fichero2);
    }
    $datos = array(
        'estado' => 'ok',
        'contra' => $resultado,
        'nombre' => $nombre,
    );
    
    echo json_encode($datos);
?>