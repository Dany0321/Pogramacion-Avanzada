var nombre;
var contra;

var esclavo = new Worker('lectorMensajero.js')



esclavo.onmessage = function(oEvent){
    nombre = oEvent.data[0];
    contra = oEvent.data[1];
    window.location.replace("http://localhost/Cajero/Cuenta.html");
}




