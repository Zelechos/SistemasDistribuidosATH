<?php
require_once 'vendor/autoload.php';

use Firebase\JWT\JWT;

$key = 'Laversecreta';


include('conexion.php');

if (!isset($_SERVER['PATH_INFO'])) {
    $ruta = "/";
} else {
    $ruta = $_SERVER['PATH_INFO'];
}


$arregloRuta = explode('/', $ruta);

$recurso = $arregloRuta[1];

if (isset($arregloRuta[1])) {
    $id = $arregloRuta[1];
    // echo ' recurso= ' . $recurso . ' id=' . $id;
}
// var_dump($_SERVER['argv']);
// var_dump($_POST);
// var_dump($_REQUEST);

// parse_str(file_get_contents("php://input"),$put_vars);
// var_dump($put_vars);

// $authHeader = $_SERVER['HTTP_AUTHORIZATION'];
// echo $authHeader;

//foreach ($_SERVER as $s => $valor) {
//   echo $s.'=>'.$valor,"\n";
//}
$cabeceras = getallheaders();
//if (isset($cabeceras['Authorization'])) {
   // $autorizacion = $cabeceras['Authorization'];
    
   // $jwt = substr($autorizacion, 7);
    try {
        
       // $data = JWT::decode($jwt, $key, array('HS256'));
       // echo "autorizado";
        if ($recurso == 'bancobnb') {
            switch ($_SERVER['REQUEST_METHOD']) {
                case 'GET': //Recuperar
                    if (isset($nrocuenta)) {
                        echo "entro el if";

                        $sql = "SELECT saldo from bancobnb WHERE nrocuenta = '$nrocuenta' ";
                        $resultado = $con->query($sql);

                        $r = mysqli_fetch_assoc($resultado);
                        print json_encode($r);
                    } else {
                        echo "entro al else";
                        $sql = "SELECT id, nrocuenta, monto, saldo from bancobnb";
                        $resultado = $con->query($sql);

                        $filas = array();
                        while ($r = mysqli_fetch_assoc($resultado)) {
                            $filas[] = $r;
                        }
                        print json_encode($filas);
                    }

                    break;
                case 'POST': //Grabar
                    $nrocuenta= $_POST['nrocuenta'];
                    $monto = $_POST['monto'];
                    $saldo = $_POST['saldo'];
                    $sql = "insert into bancobnb(nrocuenta, monto ,saldo) values( '$nrocuenta', '$monto','$saldo')";
                    $resultado = $con->query($sql);
                    if ($resultado)
                        echo 'se inserto con exito';
                    else
                        echo "hubo un error";
                    break;
                case 'PATCH': //actualizacion parcial
                    parse_str(file_get_contents("php://input"), $put_vars);
                    if (isset($id)) {
                        if (isset($put_vars['nrocuenta'])) {
                            $nrocuenta = $put_vars['nrocuenta'];
                            $sql = "UPDATE bancobnb set nrocuenta ='$nrocuenta' WHERE id=$id";
                        }
                        if (isset($put_vars['monto'])) {
                            $monto = $put_vars['monto'];
                            $sql = "UPDATE bancobnb set monto ='$monto'*7 WHERE id=$id";
                        }
                        $resultado = $con->query($sql);
                        $sql2 = "SELECT saldo from bancobnb WHERE id=$id";
                        $resultado2 = $con->query($sql2);
                        print json_encode(mysqli_fetch_assoc($resultado2));
                    } else {
                        http_response_code(404);
                    }
                    break;
                case 'DELETE': //Borrar
                    if (isset($nrocuenta)) {
                        echo "entro a delete";
                        $sql2 = "SELECT nrocuenta, monto ,saldo from bancobnb WHERE nrocuenta = $nrocuenta";
                        $resultado2 = $con->query($sql2);
                        // var_dump($resultado2);
                        if ($resultado2) {
                            print json_encode(mysqli_fetch_assoc($resultado2));
                            $sql = "DELETE from bancobnb WHERE nrocuenta = $nrocuenta";
                            $resultado = $con->query($sql);
                        } else {
                            http_response_code(404);
                        }
                    } else {
                        http_response_code(404);
                    }
                    break;
            }
        }
    } catch (Exception $e) {
        var_dump($e);
    }
//} else{

  //  echo "no se proporciono el token";
//}
