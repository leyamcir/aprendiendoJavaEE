<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nuevo Trabajador</title>
</head>
<body>
	<h1>Nuevo Trabajador</h1>
	<form method="post" action="addTrabajador">
		<table>
			<tr>
				<td>Id Trabajador</td>
				<td>
					<input type="text" name="id">
				</td>
			</tr>
			<tr>
				<td>Nombre</td>				
				<td><input type="text" name="nombre"></td>
			</tr>
			<tr>
				<td>Departamento</td>
				<td><input type="text" name="departamento"></td>
			</tr>
		</table>
		<input type="submit" value="Grabar">
		<input type="reset" value="Reset">
	</form>
</body>
</html>