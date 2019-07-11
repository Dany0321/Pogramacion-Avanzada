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
            UPDATE Cuenta SET saldo = ($saldoActual - $valor) WHERE id = $id;
EOF;

    $ret = $db->exec($sql);
    if(!$ret){
        echo $db->lastErrorMsg();
    }
    $db->close();
    return "ok";
    }

    public static function consultarSaldo($nombre){
        $db = new BaseDatos();

        if(!$db){
            echo $db->lastErrorMsg();
        }else{
        }

        $sql =<<<EOF
            SELECT saldo FROM Tarjeta,Cuenta WHERE nombre = $nombre and Tarjeta.id_cuenta = Cuenta.id;
EOF;
    $ret =$db->query($sql);
    while($row = $ret->fetchArray(SQLITE3_ASSOC)){
       return $saldoActual = $row['saldo'];
        }
    }

    public static function cambiarContra($nombre,$contrau){
        $db = new BaseDatos();

        if(!$db){
            echo $db->lastErrorMsg();
        }else{
        }

        $sql =<<<EOF
        UPDATE Tarjeta SET clave = $contrau WHERE Tarjeta.nombre = $nombre;
EOF;
    $ret = $db->exec($sql);
        return "ok";
    }


    public static function confirmarContraseña($nombre,$contra){
        $db = new BaseDatos();

        if(!$db){
            echo $db->lastErrorMsg();
        }else{
        }
        $sql =<<<EOF
            SELECT * FROM Tarjeta WHERE nombre = $nombre AND clave=$contra;
            
EOF;

        $ret =$db->query($sql);
        $contador = 0;
        while($row = $ret->fetchArray(SQLITE3_ASSOC)){
            $contador = $contador + 1;
            if($contador != 0){
                $db->close();
                return true;
            }else{
                $db->close();
                return false;
            }
        }
    }

}

?>