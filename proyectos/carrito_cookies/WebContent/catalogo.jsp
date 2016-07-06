<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,es.curso.app.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Catálogo</title>
</head>
<body>
	<h1>Catálogo de productos</h1>
	<h3>Seleccionar artículos</h3>
		<% 
			List<Articulo> articulos = (List<Articulo>)request.getAttribute("articulos"); 
			String cod;
		%>
		<form name="datos" method="post" action="procesar.do">
			<input type="hidden" name="num" value="<%=articulos.size()%>">
			<% for (Articulo a: articulos) { 
				cod = "ck" + a.getCodigo();
			%> 
				<input type="checkbox" name="ck" value="<%=cod%>">
				<%=a.getDescripcion() %>&nbsp;<%= a.getImporte() %><br/>
			<% } %>
			<input type="submit" value="enviar">
		</form>
		
</body>
</html>