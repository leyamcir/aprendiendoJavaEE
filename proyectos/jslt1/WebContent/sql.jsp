<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ejemplo SQL</title>
</head>
<body>
	<h1>Ejemplo SQL</h1>
	
	<!-- Inicialización -->
	<sql:setDataSource driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/empresa3"
		user="root"
		password="root"
		var="conexion"/>
	
	<!-- Ejemplo update (insert) -->
	<c:set var ="sqlUpdate" value="INSERT INTO empleados(nombre, cargo) values (?,?)"></c:set>
	<sql:update var="num" sql="${ sqlUpdate }" dataSource="${ conexion }">
		<sql:param value="${ param.nombre }" />
		<sql:param value="${ param.cargo }" />
	</sql:update>

	<!-- Ejemplo select -->
	<c:set var ="sql" value="SELECT * FROM empleados"></c:set>
	<sql:query var="empleados" sql="${ sql }" dataSource="${ conexion }"></sql:query>
	<c:forEach items="${ empleados.rows }" var="emp">
		<c:out value="${ emp.nombre }"></c:out><br/>
	</c:forEach>
	
	<!-- Ejemplo transacción -->
	<c:catch>
		<sql:transaction dataSource="${conexion}">
		
			<c:set var ="sqlInsert" value="INSERT INTO clientes(idcliente, nombre, pais) values ('ALFKI', 'prueba', 'prueba')"></c:set>
			<sql:update var="m" sql="${ sqlInsert }" >
			</sql:update>
		
			<sql:update var="n"  sql="delete from empleados where nombre='Pepe'">
			</sql:update>
			<p>Filas borradas: <c:out value="${n}"></c:out></p>
		</sql:transaction>
	</c:catch>
	<c:out value="${ error }"></c:out>
</body>
</html>