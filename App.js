var cantidad;
var cantidadConcreta = document.getElementById("cantidadConcreta");
var retiro = document.getElementById("retiro");
var consulta = document.getElementById("consulta");
var cambiarContra = document.getElementById("contra");
var confirmarContranueva = document.getElementById("cambiarcontra");
var nombre = getUrlVars()['nombreE']


if(confirmarContranueva != null){
    confirmarContranueva.addEventListener('submit',function(e){
        e.preventDefault();
        cantidad = getUrlVars()['cantidad'];
        var datos = new FormData(confirmarContranueva);
        cambiarContrase(datos.get('con'));
    });
}

if(cambiarContra != null){
    cambiarContra.addEventListener('submit',function(e){
        e.preventDefault();
        var datos = new FormData(cambiarContra);
        cantidad = datos.get('con');
        cambiarPag("http://localhost/Cajero/ContraContra.html")
    });
}

if(consulta != null){
    consulta.addEventListener('submit',function(e){
        e.preventDefault();
        var datos = new FormData(consulta);
        consultaSaldo(datos.get('con'));
    });
}

if(retiro != null){
    cantidad = getUrlVars()['cantidad'];
    retiro.addEventListener('submit', function(e){
        e.preventDefault();
        var datos = new FormData(retiro);
        retirarDinero(datos.get('con'));
    });
}

if(cantidadConcreta != null){
    cantidadConcreta.addEventListener('submit', function(e){
        e.preventDefault();
        var datos = new FormData(cantidadConcreta);
        cantidad =  parseInt(datos.get('cant'));
        cambiarPag("http://localhost/Cajero/ContraRetiro.html")
    });
}



function setCantidad(valor){
    cantidad = valor;
    cambiarPag("http://localhost/Cajero/ContraRetiro.html");
}


function retirarDinero(contraUsuario){

    var datos = new FormData();
    datos.append("contraU",JSON.stringify(contraUsuario));
    datos.append("usuario",JSON.stringify(nombre));
    enviarInfo(datos,'guardia.php')
    .then(res => {
        console.log(res)
        if(res.res){
            var datos = new FormData();
        datos.append("cantidad",JSON.stringify(cantidad));
        datos.append("usuario",JSON.stringify(nombre));
        enviarInfo(datos,'retirador.php')
        .then(res => {
            console.log(res)
                if(res.res == "ok"){
                    window.alert("Retiro realizado");
                    nombre = "";
                    contra = "";
                    window.location.replace("http://localhost/Cajero");
                }else if(res.res == "error1"){
                    window.alert("saldo insuficiente");
                    cambiarPag("http://localhost/Cajero/Cuenta.html");
                }else{
                    window.alert("error en el retiro");
                    cambiarPag("http://localhost/Cajero/Cuenta.html");
                }
            }
            )
        }else{
            window.alert("Contraseña invalida");
        }
        }
        )
}

function consultaSaldo(contraUsuario){
    var datos = new FormData();
    datos.append("contraU",JSON.stringify(contraUsuario));
    datos.append("usuario",JSON.stringify(nombre));
    enviarInfo(datos,'guardia.php')
    .then(res => {
        console.log(res)
        if(res.res){
            var datos = new FormData();
        datos.append("usuario",JSON.stringify(nombre));
        enviarInfo(datos,'buscador.php')
        .then(res => {
            console.log(res)
            window.alert("Su saldo es: "+res.res);
            window.location.replace("http://localhost/Cajero");
            }
            )
        }else{
            window.alert("Contraseña invalida");
            window.location.replace("http://localhost/Cajero");
        }
        }
        )
}

function cambiarContrase(contraUsuario){
    var datos = new FormData();
    datos.append("contraU",JSON.stringify(contraUsuario));
    datos.append("usuario",JSON.stringify(nombre));
    enviarInfo(datos,'guardia.php')
    .then(res => {
        console.log(res)
        if(res.res){
            var datos = new FormData();
        datos.append("contrau",JSON.stringify(cantidad));
        datos.append("usuario",JSON.stringify(nombre));
        enviarInfo(datos,'llavero.php')
        .then(res => {
            console.log(res)
            if(res.res == "ok"){
                window.alert("Ha cambiado su contraseña");
            }
            }
            )
        }else{
            window.alert("Contraseña invalida");
            window.location.replace("http://localhost/Cajero");
        }
        }
        )
}

async function enviarInfo(datosEnviados,archivo){
    respuesta = await fetch(archivo,{
        method: 'POST',
        body: datosEnviados,
        mode: "cors"
    });

    recibe = await respuesta.json(); // sé que recibo un json
    return recibe;
}


function cambiarPag(url){
    if(document.getElementById("retiroR") != null || document.getElementById("retiroG") != null || document.getElementById("contra")){
        window.location.replace(url+"?nombreE="+nombre+"&"+"cantidad="+cantidad);
    }else{
        window.location.replace(url+"?nombreE="+nombre);
    }    
}

function getUrlVars() {
    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
        vars[key] = value;
    });
    return vars;
}