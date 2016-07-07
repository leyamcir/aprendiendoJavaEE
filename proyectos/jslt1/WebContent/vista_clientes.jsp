<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="es.curso.clientes.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ejemplos JSLT</title>
</head>
<body>
	<h1>Ejemplos JSLT</h1>
	
	<!-- Mostrar parámetro (se coge automáticamente) -->
	<h3>Número de clientes: ${clientes.size()}</h3>
	
	<!-- Recoger parámetro por URL -->
	<h4>Mensaje recibido por parámetro URL: <c:out value="${ param.mensaje }"></c:out></h4>
	
	<!-- Iterar por una colección -->
	<h3>Nombre clientes:</h3>
	<ul>
		<c:forEach items="${ clientes }" var="cli">
			<li><c:out value="${ cli.nombre }"></c:out></li>
		</c:forEach>
	</ul>
	
	<!-- Filtrar resultados -->
	<h3>Clientes Franceses</h3>
	<select name="clienteFrances">
		<c:forEach items="${ clientes }" var="cli">
			<c:if test="${cli.pais == 'Francia'}">
				<option value="${cli.idcliente}">${cli.nombre}</option>
			</c:if>
		</c:forEach>
	</select>
	
	<!-- Ejemplo forTokens -->
	<h3>Ejemplo forTokens</h3>
	<ul>
		<c:forTokens items="id,nombre,tno" delims="," var="cab">
			<li>${ cab }</li>
		</c:forTokens>
	</ul>
	
	<!-- Ejemplo c:choose -->
	<h3>Ejemplo c:choose</h3>
	<ul>
		<c:forEach items="${ clientes }" var="cli">
			<c:choose> 
				<c:when test="${cli.pais == 'Alemania'}">
					<li><b>Alemán --></b> ${ cli.nombre }</li>
				</c:when>
				<c:when test="${cli.pais == 'Francia'}">
					<li><b>Francés --></b> ${ cli.nombre }</li>
				</c:when>
				<c:when test="${cli.pais == 'Reino Unido'}">
					<li><b>Inglés --></b> ${ cli.nombre }</li>
				</c:when>
				<c:otherwise>
					<li><b>Otro país --></b> ${ cli.nombre }</li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</ul>
	
	<!-- Ejemplo c:import -->
	<h3>Ejemplo c:import</h3>
	<c:import url="https://www.google.es"></c:import>
	
	<!-- Ejemplo de catch -->
	<h3>Ejemplo de catch</h3>
	<c:catch var="error">
		<fmt:formatNumber var="numero" value="44rr"></fmt:formatNumber>
	</c:catch>
	<c:if test="${not empty error}">
		<p>Se ha producido el error: <c:out value="${error}"></c:out></p>
	</c:if>
	<c:if test="${empty error}">
		<p>El numero es: <c:out value="${numero}"></c:out></p>
	</c:if>
	
</body>
</html>