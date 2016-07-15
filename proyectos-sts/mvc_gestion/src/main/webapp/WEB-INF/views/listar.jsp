<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/css/estilos.css">
<title>Insert title here</title>
</head>
<body>
	<div id="contenedor">
	<h3 id="titulo">LISTADO DE PEDIDOS (${pedidos.size()})</h3>	
	<table>
		<tr>
			<c:forTokens items="ID_PEDIDO,CLIENTE,EMPLEADO,EMPRESA,CARGO,PAIS" 
			delims="," var="p">
				<td>${p}</td>
			</c:forTokens>
		</tr>	
		<c:forEach items="${pedidos}" var="p" varStatus="status">
			<c:if test="${status.count mod 2 == 0}">
				<c:set var="clase" value="fila" />
			</c:if>
			<c:if test="${status.count mod 2 != 0}">
				<c:set var="clase" value="fila_impar" />
			</c:if>
			<tr class="${clase}">
				<td>${p.idPedido}</td>
				<td>${p.cliente.nombre}</td>
				<td>${p.empleado.nombre}</td>
				<td>${p.empresa.nombre}</td>
				<td>${p.precio}</td>
				<td>${p.pais}</td>
			</tr>
		</c:forEach>	
	</table>
	<p><a href="home">Volver</a></p>
	</div>
</body>
</html>