<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>Fill user data</h1>
	<form:form action="process" method="POST" commandName="user">
		Name: <form:input path="name"/><br/>
		Address: <form:input path="address"/><br/>
		Password: <form:password path="password"/><br/>
		Confirm password: <form:password path="password2"/><br/>
		Subscribe to newsletter? <form:checkbox path="subscribe"/><br/>
		Favourite Web Frameworks: <form:checkboxes items="${ frameworks }" path="frameworks"/><br/>
		Sex: <form:radiobuttons path="sex" items="${ genders }"/><br/>
		Number: <form:radiobuttons path="number" items="${ numbers }"/><br/>
		Country: <form:select path="country" items="${ countries }"></form:select><br/>
		Java skills: <form:select multiple="true" path="jSkills">
		    <form:options items="${skillOptionList}"/>
		</form:select>
		<form:button value="Enviar" name="enviar">Enviar</form:button>
	</form:form>
</body>
</html>
