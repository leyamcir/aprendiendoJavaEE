<%-- 
    Document   : quote
    Created on : Oct 19, 2009, 3:41:22 PM
    Author     : Simon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Here's a quotation!</h1>
        <c:if test="${not empty user}">
            <h2>Hola ${user}</h2>
        </c:if>
    </body>
    ${quote}
</html>
