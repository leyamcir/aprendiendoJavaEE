<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ejemplo JSP, generar tabla</title>
</head>
<body>
	<% 
	 int filas, cols; 
	 String contenido;
	 
	 try{
		 filas = Integer.parseInt(request.getParameter("filas")); 
		 cols = Integer.parseInt(request.getParameter("cols")); 
		 contenido =  request.getParameter("contenido"); 
		
	%>
		<table>
			<% for (int i=0; i<filas; i++) { %>
				<tr>
					<% for (int j=0; j<cols; j++) { %>
						<td><%=contenido %></td>
					<% } %>
				</tr>
			<% } %>
		</table>
	<%
	 } catch (Exception e) {
		 out.print("<h3>" + e.getMessage() + "</h3>");
	 }
	 %>
	
	
</body>
</html>