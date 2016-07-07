<%-- 
    Document   : index
    Created on : 28-dic-2011, 10:59:41
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="fecha" class="java.util.Date"></jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Ejemplos Formating</h2>
        <h4>Formating Number</h4>
        <c:set var="numero" value="1200"></c:set>
        <p>Sin formatear: <c:out value="${numero}"></c:out></p>
        <p>Formateado: <fmt:formatNumber value="${numero}" type="currency" currencySymbol="€"></fmt:formatNumber></p>
        <p>Porcentaje: <fmt:formatNumber value="0.67" type="percent"></fmt:formatNumber></p>
        <p>Grouping: <fmt:formatNumber value="12345678.99" groupingUsed="true"></fmt:formatNumber></p>
        <h4>Formating Date</h4>
        <p>Sin formatear: <c:out value="${fecha}"></c:out></p>
        <p>Formateada: <fmt:formatDate value="${fecha}" type="date" dateStyle="medium"></fmt:formatDate> 
        <p>Formateada: <fmt:formatDate value="${fecha}" type="time" timeStyle="medium"></fmt:formatDate>     
        <p>Formateada: <fmt:formatDate value="${fecha}" type="both" pattern="dd/MM/yyyy hh:mm"></fmt:formatDate>  
        <h4>Parse number</h4>
        <p>Número parseado: <fmt:formatNumber var="numero" value="44"></fmt:formatNumber></p>
        <p><c:out value="${numero}"></c:out></p>
        <h4>Parse date</h4>
        <p><fmt:parseDate var="miFecha" value="13/06/2009" type="date" pattern="dd/MM/yyyy"></fmt:parseDate></p>
        <p><c:out value="${miFecha}"></c:out></p>
       
        
    </body>
</html>
