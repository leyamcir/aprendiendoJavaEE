<html>
<head>
<title>Lista Programas</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<meta name="copyright" content="Curso J2EE JDBC/JSP 2004">
<link rel="stylesheet" type="text/css" href="estilos.css">
</head>

<%@ page errorPage="error.jsp" %> 

<% // jsp:useBean id="usr" class="progtv.UserBean" scope="session" /%>

<jsp:useBean id="cad" class="progtv.CadenaBean" scope="request" />

<%@ page import="progtv.*" %>

<% ProgramaBean[] progs = (ProgramaBean[])request.getAttribute("progs"); %>

<table  width="90%" border="0" align="center"
         cellpadding="0" cellspacing="0" class="principalcabecera">
 <tr>
   <td colspan="3"><img src="imagenes/transparente.gif" width="2" height="2"></td>
 </tr>
 <tr>
   <td height="10px"> <div align="center"></div></td>
   <td width="*" class="titulo_centrado2">Lista de Programas de la Cadena: <%= cad.getNombre() %></td>
     <tr>
       <td colspan="3"><img src="imagenes/transparente.gif" width="2" height="2"></td>
     </tr>
     <tr>
       <td><img src="imagenes/transparente.gif" width="2"
            height="2"></td>
       <td>
       <table class="principaldatos" width="100%" border="1" align="center" cellpadding="3" cellspacing="5px" >
         <tr>
           <td colspan="4"></td>
         </tr>
         <tr align="center" class="principaldatostitulos">
           <th width="40%">Programa</th>
           <th width="40%">Hora Inicio</th>
           <th width="20%">Hora Fin</th>
         </tr>
         <tr>
           <td colspan="4"><div align="left"></div></td>
         </tr>

<%
   if (progs != null)
   for (int i=0; i<progs.length; i++) {
       ProgramaBean prog = progs[i];
%>
   <tr>

    <td>
    <%= prog.getPrograma() %>
    </td>

    <td width="30%">
    <%= prog.getHoraInicio() %>
    </td>

    <td width="30%">
    <%= prog.getHoraFin() %>
    </td>

   </tr>
<% } %>

 </table>

<br>
<table width="95%" border="0" cellspacing="1" cellpadding="0" align="center">
   <tr><td>
       <table border="0" cellspacing="1" cellpadding="1" align="center">
         <tr><td align="center">
           <input type="button" value="Inicio"
            onClick="location='inicio.do'">
         </td></tr>
       </table>
     </td></tr>
</table>

</table>

