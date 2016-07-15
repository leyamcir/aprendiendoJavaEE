<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado trabajadores</title>
</head>
<body>
	<h1>Listado trabajadores</h1>
	
	<c:if test="${not empty message }">
		<div class="message">
			<b>${ message }</b>
		</div>
	</c:if>
	
	<table>
		<tr>
			<th>Id del trabajador</th>
			<th>Nombre</th>
			<th>Departamento</th>
			<!--  th colspan=2></th>-->
		</tr>
		<c:forEach items="${ trabajadores }" var="tr">
			<tr>
				<td><c:out value="${ tr.id }"></c:out></td>
				<td><c:out value="${ tr.nombre }"></c:out></td>
				<td><c:out value="${ tr.departamento }"></c:out></td>
				<!-- td>
					<a href="nuevoCliente.do?idcliente=${ cli.idcliente }"><img alt="editar" src="img/modificar.bmp"></a>
				</td>
				<td>
					<a href="eliminarCliente.do?idcliente=${ cli.idcliente }"><img alt="eliminar" src="img/eliminar.bmp"></a>
				</td> -->
			</tr>
		</c:forEach>

	</table>
</body>
</html>