var contraseña;

let url = 'http://localhost/cajero/Negociador.php';

fetch(url)
.then(res => res.json())
.then( res => {
    console.log(res);
        if(res.contra == "fail"){
            alert("Ingrese una tarjeta valida");
        }else{
            contraseña = res.contra;
            window.open("http://localhost/cajero/Cuenta.html","_self")
        }
})
.then((out) => {
  console.log('Checkout this JSON! ', out);
})
.catch(err => { throw err });