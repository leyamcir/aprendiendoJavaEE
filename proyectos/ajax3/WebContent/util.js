/* Variables globales */
/* Almacena el árbol DOM del XML */
var texto;

/* Objeto para las peticiones AJAX */
var httpRequest=false;

function motorAjax() {
	
	// (1) Carga de XMLHTTPRequest en navegadores que respeten la especificación W3C
	if (window.XMLHttpRequest) {
		// Existe el objeto, lo instanciamos
		httpRequest=new XMLHttpRequest();
	
	} else if (window.ActiveXObject) { // Esto sería para MSIE
		// Instanciamos el objeto MSXMLHTTP
		httpRequest=new ActiveXObject("Microsoft.XMLHTTP");
	
	}
	
	// (2) Después de instanciar, comprobamos si está correcto
	if (!httpRequest) {
		window.alert("Este navegador no tiene implementación de AJAX");
	}
	
	// (3) Se ha de indicar al objeto httpRequest la función JS que se va a encargar
	//     de gestionar las respuestas asíncronas
	httpRequest.onreadystatechange=funcionProcesamiento;
	
}


function solicitarTexto(){
	var nombreFichero;
	var combo = document.getElementById("selector");
	
	if (httpRequest) {
		// Seleccionar el nombre del fichero:
		nombreFichero = combo.value;
				
		if (nombreFichero != ""){
			
			// (4) Se realiza la petición asíncrona al servidor
			httpRequest.open("GET", nombreFichero, true);
			httpRequest.send(null);
		}
		
	} else 
		alert("No se ha creado el objeto: XMLHttpRequest");
}


function funcionProcesamiento() {
	// Primero se comprueba si la respuesta está completada
	var capa;
	
	
	if (httpRequest.readyState==4) {
		// Ahora se comprueba si la respuesta HTTP es correcta (200 OK)
		
			
		if (httpRequest.status==200) {
			// Si todo es correcto, recogemos la respuesta "text" en nuestra variable			
			texto=httpRequest.responseText;
					
			// Si ya tenemos el contenido del fichero, cambiamos el contenido:
			
			// Capturo la capa:
			capa = document.getElementById("contenidoTexto");	
			capa.innerHTML = texto	
		}
	}
}

