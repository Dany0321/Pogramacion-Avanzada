console.log("algo");
document.body.onload = generarInputs();
var formulario = document.getElementById("formulario");
var matrizInterfaz;
var matrizSolucion;
var tiempoM;
var tiempoS;
var tiempo;

function generarInputs(){
	matrizInterfaz = new Array(9);
	for (var i = 0; i<9;i++){
		matrizInterfaz[i] = new Array(9);
	}
	var contador = 81;
	var input;
	for(var i = 0; i < 9;i++){
		for(var j=0; j< 9; j++){
			input = document.createElement("input",{class:"campo"});
			input.id = "campo"+contador.toString();
			input.size = 3;
			console.log(input.id);
			document.getElementById("sudoku").insertAdjacentElement("afterbegin",input);
			contador--;
			matrizInterfaz[i][j] = input.id;
		}
		document.getElementById("sudoku").insertAdjacentHTML("afterbegin","<br>")
	}
}

function rellenarSudoku(matrizSudoku){
	vaciarSudoku();
	if(tiempo != null)
		clearInterval(tiempo);
	for(var i = 0; i<9;i++){
		for(var j=0;j<9;j++){
			if(matrizSudoku[i][j] == 0){
				continue;
			}
			document.getElementById(matrizInterfaz[8-i][8-j]).value = matrizSudoku[i][j];
			document.getElementById(matrizInterfaz[8-i][8-j]).style.color = "blue";
			document.getElementById(matrizInterfaz[8-i][8-j]).setAttribute("disabled", true);
		}
	}
}

function vaciarSudoku(){
	for(var i = 0; i<9;i++){
		for(var j=0;j<9;j++){
			document.getElementById(matrizInterfaz[8-i][8-j]).value = "";
			document.getElementById(matrizInterfaz[8-i][8-j]).style.color = "black";
			document.getElementById(matrizInterfaz[8-i][8-j]).removeAttribute('disabled');
		}
	}
}


function revisar(){
	matrizSolucion = new Array(9);
	for (var i = 0; i<9;i++){
		matrizSolucion[i] = new Array(9);
	}
	for(var i=0;i<9;i++){
		for(var j=0;j<9;j++){
			var x =  document.getElementById(matrizInterfaz[8-i][8-j]).value.toString();
			matrizSolucion[i][j] = parseInt(x);
		}
	}
	console.log(matrizSolucion[0][0]);
	var datos = new FormData();
	datos.append("matriz",JSON.stringify(matrizSolucion));
	enviarInfo(datos)
	.then(res => {
		console.log(res)
		if(res.solucion == 1){
			alert("Felicitaciones, es usted un genio");
			location.reload();
		}else{
			alert("Esta mal, por favor confirme su solucion")
		}

	}
		)
}

function controlTiempo(){
	console.log("a pasado 1 seg")
	tiempoS--;
	if(tiempoS<0){
		tiempoS = 59;
		tiempoM--;
	}
	if(tiempoS == 0 && tiempoM == 0){
		alert("Se ha queedado sin tiempo");
		location.reload();
	}else{
		$('#tMinutos').html(tiempoM.toString());
		$('#tSegundos').html(tiempoS.toString());
	}
}

formulario.addEventListener('submit', function(e){
    e.preventDefault();
    console.log('me diste un click')

	var datos = new FormData(formulario);

    console.log(datos)
	console.log(datos.get('dificultad'))
	var dif = datos.get('dificultad')
    return fetch('Creador.php',{
		method: 'POST',
        body: datos
	})
		.then( res => res.json())
        .then( res => {
            console.log(res);
				rellenarSudoku(res.matrizSudoku);
				tiempoM =  dif;
				tiempoS = 0;
				tiempo = setInterval(controlTiempo,1000);
		})
})

function algo(){
	console.log("sirvo");
}

async function enviarInfo(datosEnviados){
    respuesta = await fetch('Corrector.php',{
        method: 'POST',
        body: datosEnviados,
        mode: "cors"
    });

    recibe = await respuesta.json(); // sé que recibo un json
    return recibe;
}

