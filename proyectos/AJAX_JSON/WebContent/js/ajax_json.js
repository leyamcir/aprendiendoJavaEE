//Petición HTTP:
var http_request = false;
/* Código para cargar el Motor AJAX */
function cargarAJAX(url) {
	// 1. Comprobamos si podemos cargar el objeto de la especificación W3C.
	// Será para navegadores <> de IE.
	if (window.XMLHttpRequest) {
		// Creamos el objeto:
		http_request = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		// Instanciamos el ActiveX, estamos con IE.
		http_request = new ActiveXObject("Microsoft.XMLHTTP");
	}

	// 2. ¿Ha ido todo bien?
	if (http_request == null) {
		// No.
		window.alert("Error no se puede cargar el objeto XMLHttRequest ...");
		return false;
	}
	// 3. Hemos conseguido instanciar el objeto, le asignamos la función
	// manejadora:
	http_request.onreadystatechange = funcionProcesamiento;
	// 4. Se inicia la petición asíncrona:
	http_request.open('GET', url, true);
	// 5. Se envía la petición:
	http_request.send(null);
}

function funcionProcesamiento(){
	if (http_request.readyState == 4){
//		Carga completada:
		if (http_request.status == 200){ // OK
			var nuevoTitulo;
//			Respuesta del Servidor:
			var json_doc = http_request.responseText;
			//console.log(json_doc);

			var datos = eval("(" + json_doc + ")");
			procesarRespuesta(datos)
		} else
			muestraError(http_request.status);
	}
}

function procesarRespuesta(datos) {
//	Obtengo la información deseada:
	console.log(datos);
	console.log(".- id: " + datos.menu.id);
	console.log(".- valor: " + datos.menu.valor);
	
	for (var i=0; i < datos.menu.popup.menuitem.length; i++)
		console.log(datos.menu.popup.menuitem[i].id + " = " + datos.menu.popup.menuitem[0].value);
}

function muestraError(error){
	console.log("respuesta del Servidor: " + error);
}

function cargarAJAX2(url) {
	$.ajax({ 
		url: url,
		type: 'POST',
		async: true,
		//data: 'parametro1=valor1&parametro2=valor2',
		success: procesarRespuesta,
		error: muestraError 
	});
}