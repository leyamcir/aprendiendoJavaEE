function procesarRespuesta(datos) {
	$('#clientes').html(datos);
}

function mostrarError(error){
	console.log("respuesta del Servidor: " + error);
}

function cargarAJAX(pais) {	
	$.ajax({ 
		url: 'init.do',
		type: 'POST',
		async: true,
		data: 'pais='+pais,
		success: procesarRespuesta,
		error: mostrarError 
	});
	
}