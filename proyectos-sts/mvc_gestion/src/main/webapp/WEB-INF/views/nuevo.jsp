<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Nuevo Pedido</h3>
	<form:form action="grabarPedido" method="post" commandName="pedido">
		<table>
			<tr>
				<td>ID PEDIDO</td>
				<td><form:input path="idPedido"/>
			</td>
			<tr>
				<td>CLIENTE</td>
				<td><form:select path="cliente.idCliente" 
				items="${clientes}" 
				itemLabel="nombre" 
				itemValue="idCliente"></form:select>
			</tr>
			<tr>
				<td>EMPLEADO</td>
				<td><form:select path="empleado.idEmpleado" 
				items="${empleados}" 
				itemLabel="nombre" 
				itemValue="idEmpleado"></form:select>
			</tr>
			<tr>
				<td>EMPRESA</td>
				<td><form:select path="empresa.idEmpresa" 
				items="${empresas}" 
				itemLabel="nombre" 
				itemValue="idEmpresa"></form:select>
			</tr>
			<tr>
				<td>PRECIO</td>
				<td><form:input path="precio"/></td>
			</tr>
			<tr>
				<td>PAIS</td>
				<td><form:input path="pais"/></td>
			</tr>			
		</table>
		<input type="submit" name="enviar" value="enviar">
	</form:form>
	<p><a href="home">Volver</a></p>
</body>
</html>