<%-- 
    Document   : login
    Created on : Oct 19, 2009, 4:31:06 PM
    Author     : Simon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>What's your name!</h1>
        <form action="j_security_check">
            <p>Username: <input type="text" name="j_username"/></p>
            <p>Password: <input type="password" name="j_password"></p>
            <input type="submit" value="Login"/>            
            <input type="reset" value="Clear"/>
        </form>
    </body>
</html>
