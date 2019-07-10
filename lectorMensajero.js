var estado = false;

var tiempo;

tiempo = setInterval(preguntarBack,15000);





function preguntarBack(){
    var datos = new FormData();
    datos.append("tarjeta",JSON.stringify("basura"));
    enviarInfo(datos,'Negociador.php')
    .then(res => {
        console.log(res)
        if(res.contra != "fail" && res.contra != false){
                var a = [res.nombre,res.contra];
                postMessage(a);
                clearInterval(tiempo);
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

