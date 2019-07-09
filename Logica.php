<?php

class BaseDatos extends SQLite3{

    function __construct(){
        $this->open("Banco.db");
    }
}

class Logica{

    public static function buscarTarjeta($nombre){
        $db = new BaseDatos();

        if(!$db){
            echo $db->lastErrorMsg();
        }else{
            echo "Me conecte a la base de datos";
        }

        $sql =<<<EOF
            SELECT * FROM Tarjeta WHERE nombre = $nombre;
EOF;

        $ret =$db->query($sql);
        $contador = 0;
        $contra = "fail";
        while($row = $ret->fetchArray(SQLITE3_ASSOC)){
            echo "wii";
            $contador = $contador + 1;
            if($contador != 0){
                $contra = $row['clave'];
            }
        }
        $db->close();
        return $contra;
    }

}

?>