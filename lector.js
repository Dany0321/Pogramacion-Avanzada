var nombre;
var contra;

var esclavo = new Worker('lectorMensajero.js')



esclavo.onmessage = function(oEvent){
    nombrelocal = oEvent.data[0];
    window.alert(nombrelocal);
    window.location.replace("http://localhost/Cajero/Cuenta.html?nombreE="+nombrelocal);
}




