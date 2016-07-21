<%-- 
    Document   : login
    Created on : 21-jul-2016, 11:28:43
    Author     : cas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="ApplicationController" method="POST">
            User: <input type="text" name="user">
            <!--Password: <input type="password" name="password">-->
            <input type="hidden" name="operation" value="Login">
            <input type="submit"/>
        </form>
    </body>
</html>
