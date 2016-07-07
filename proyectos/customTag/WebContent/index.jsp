<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="e" uri="/myTLD" %>
<%@taglib prefix="f" uri="/SumaTLD" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Prueba de etiquetas</h3>
        <e:myTag /><br />
        <f:sumaTag num1="9" num2="5"/>
    </body>
</html>
