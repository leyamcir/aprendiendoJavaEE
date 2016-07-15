<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
	<h1>Rellena datos del vehículo</h1>
		
	<form:form action="procesar" commandName="coche" method="POST">
		Matrícula: <form:input path="matricula"/><form:errors path="matricula" cssClass="error" /><br/>
		Modelo: <form:input path="modelo"/><form:errors path="modelo" cssClass="error" /><br/>
		Año: <form:input path="año"/><form:errors path="año" cssClass="error" /><br/>
		KM: <form:input path="km"/><form:errors path="km" cssClass="error" /><br/>
		<form:button>PROCSESAR</form:button>
	</form:form>
</body>
</html>
