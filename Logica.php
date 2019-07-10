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
        }

        $sql =<<<EOF
            SELECT * FROM Tarjeta WHERE nombre = $nombre;
EOF;

        $ret =$db->query($sql);
        $contador = 0;
        $contra = "fail";
        while($row = $ret->fetchArray(SQLITE3_ASSOC)){
            $contador = $contador + 1;
            if($contador != 0){
                $contra = $row['clave'];
            }
        }
        $db->close();
        return $contra;
    }

    public static function retirarDinero($valor,$nombre){
        $db = new BaseDatos();

        if(!$db){
            echo $db->lastErrorMsg();
        }else{
        }

        $sql =<<<EOF
            SELECT Cuenta.id,saldo FROM Tarjeta,Cuenta WHERE nombre = $nombre and Tarjeta.id_cuenta = Cuenta.id;
EOF;
    $ret =$db->query($sql);
    while($row = $ret->fetchArray(SQLITE3_ASSOC)){
        $id = $row['id'];
        $saldoActual = $row['saldo'];
    }


    if(($saldoActual - $valor) < 0){
        return "error1";
    }

    $sql =<<<EOF
            UPDATE Cuenta SET saldo = $saldoActual - $valor WHERE id = $id
EOF;

    $ret = $db->exec($sql);

    $db->close();
    return "ok";
    }

}

?>