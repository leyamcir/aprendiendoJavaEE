<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,es.curso.clientes.beans.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Combos</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/ajax.js"></script>
</head>
<body>
	<h1>Combos</h1>
	<form action="guardar.do">
		<select name="pais" onchange="cargarAJAX(this.value)">
			<option value=""></option>
			<c:forEach items="${ paises }" var="pais">
				<option value="${ pais }">${ pais }</option>
			</c:forEach>
		</select>
		<div id="clientes"></div>
		<input type="submit" value="Grabar">
	</form>
</body>
</html>