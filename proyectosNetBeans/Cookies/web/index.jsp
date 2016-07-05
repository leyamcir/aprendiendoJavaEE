<%-- 
    Document   : index
    Created on : 24-dic-2011, 17:21:39
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Prueba de Cookies</h2>
        <form name="datos" action="ServletGrabarCookie" method="post">
            Nombre Cookie: <input type="text" name="nombre" /><br />
            Valor Cookie:  <input type="text" name="valor" /><br />
            <input type="submit" name="submit" value="submit" />            
        </form>
        <a href="ServletListarCookies">Listar Cookies</a>
    </body>
</html>
