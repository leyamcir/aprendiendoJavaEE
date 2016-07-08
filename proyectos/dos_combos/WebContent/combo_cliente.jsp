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
		<c:if test="${not empty clientes}">
			<select name="cliente">
				<option value="">Selecciona un cliente</option>
				<c:forEach items="${ clientes }" var="cli">
					<option value="${ cli.idcliente }">${ cli.nombre }</option>
				</c:forEach>
			</select>
		</c:if>
</body>
</html>