<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>P�gina principal</title>
</head>
<body>
	<% 
		String user = (String) session.getAttribute("user");
		if (user == null) {
			// Usuario no registrado, ir al inicio
			response.sendRedirect("index.html");
		}
	%>
	<h3>Men� principal APP</h3>
	<h5>Usuario conectado: <%=user%></h5>
	<a href="logout.do">Cerrar conexi�n</a>
</body>
</html>