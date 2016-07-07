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

function funcionProcesamiento() {
	if (http_request.readyState == 4) { // Carga completada:
		if (http_request.status == 200) { // OK

			// Respuesta del Servidor:
			var content = http_request.responseText;
			var capa = document.getElementById('capa');
			capa.innerHTML = content;
		} else
			window.alert("respuesta del Servidor: " + http_request.status);
	}
}

function agregar() {
	var f = document.getElementById('fichero').value;

	cargarAJAX(f);
}