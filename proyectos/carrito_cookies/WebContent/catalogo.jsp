<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,es.curso.app.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cat�logo</title>
</head>
<body>
	<h1>Cat�logo de productos</h1>
	<table>
		<tr>
			<th>Seleccionar</th>
			<th>Art�culo</th>
			<th>Precio</th>
		</tr>
		<% List<Articulo> articulos = (List<Articulo>)request.getAttribute("articulos"); %>
		<% for(int i=0; i<articulos.size(); i++){ %>
		<% } %>
	</table>
</body>
</html>