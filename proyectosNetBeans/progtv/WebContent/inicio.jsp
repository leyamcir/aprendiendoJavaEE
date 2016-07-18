<html>
<head>
<title>Test jsp</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<meta name="copyright" content="Curso jsp 2004">
<link rel="stylesheet" type="text/css" href="estilos.css">
</head>

<%@ page errorPage="error.jsp" %>

<%@ page import="progtv.*" %>

<jsp:useBean id="usr" class="progtv.UserBean" scope="session" />

<%// La linea anterior jsp:useBean equivale básicamente a: %>
<%// UserBean usr = (UserBean)session.getAttribute("usr"); %>

<% CadenaBean[] cads = (CadenaBean[])request.getAttribute("cads"); %>

<script language="javascript">
    function send () {
        if (document.form1.cadena.value=="0") {
            alert("Debe seleccionar Cadena.");
            document.form1.cadena.focus();
        }
        else {
            document.form1.action="programas.do";
            document.form1.submit();
        }
    }
</script>

<center>
  <h2>Bienvenido a la página de prueba - Curso Java EE</h2>

    <table align="center" width="90%" border="2" bordercolor="#cccccc" cellspacing="2" cellpadding="4">

    <tr>
      <td width="25%">
        <b><font color="#666666" size="2" face="Arial, Helvetica, sans-serif">
            Usuario:</font></b>
      </td>
      <td >
        <b><font color="#333333" size="2" face="Arial, Helvetica, sans-serif">
            <%= usr.getUser() %>
       </font> </b>
      </td>
    </tr>

    <tr>
      <td width="25%">
        <b><font color="#666666" size="2" face="Arial, Helvetica, sans-serif">
            Nombre:</font></b>
      </td>
      <td >
        <b><font color="#333333" size="2" face="Arial, Helvetica, sans-serif">
            <%= usr.getNombre() %>
        </font></b>
      </td>
    </tr>

    <tr>
      <td width="25%">
        <b><font color="#666666" size="2" face="Arial, Helvetica, sans-serif">
            Ultimo acceso: </font></b>
      </td>
      <td >
        <b><font color="#333333" size="2" face="Arial, Helvetica, sans-serif">
            <%= usr.getLastLoginLiteral() %>
       </font> </b>
      </td>
    </tr>

    <tr>
      <td width="25%">
        <b><font color="#666666" size="2" face="Arial, Helvetica, sans-serif">
            Servidor: </font></b>
      </td>
      <td >
        <b><font color="#333333" size="2" face="Arial, Helvetica, sans-serif">
        <%
          String host = request.getServerName() + ":" + request.getServerPort();
          host = host + "  " + application.getRealPath("/");
          out.write(host);
        %>
        </font></b>
      </td>
    </tr>

    <tr>
      <td width="25%">
        <b><font color="#666666" size="2" face="Arial, Helvetica, sans-serif">
            Conectado desde: </font></b>
      </td>
      <td >
        <b><font color="#333333" size="2" face="Arial, Helvetica, sans-serif">
        <%
          String ip = request.getRemoteAddr();
          String hs = request.getRemoteHost();
          String str = "";
          if (!hs.equals(ip))
              str = hs + " ("+ip+")";
          else
              str = ip;
          str += "      " + request.getAttribute("context");
          out.write(str);
        %>
        </font></b>
      </td>
    </tr>

    <tr>
      <td width="25%">
        <b><font color="#666666" size="2" face="Arial, Helvetica, sans-serif">
           Navegador:</font></b>
      </td>
      <td >
        <b><font color="#333333" size="2" face="Arial, Helvetica, sans-serif">
        <script>
            document.writeln(navigator.appName+ " " + navigator.appVersion);
        </script>
       </font> </b>
      </td>
    </tr>

    <tr>
      <td width="25%">
        <b><font color="#666666" size="2" face="Arial, Helvetica, sans-serif">
            Resolución:</font></b>
      </td>
      <td >
        <b><font color="#333333" size="2" face="Arial, Helvetica, sans-serif">
         <script>
           document.writeln(screen.width+ " x " + screen.height);
         </script>
        </font></b>
      </td>
    </tr>

    </table>

    <br>
    <br>
    <br>

    <form name="form1" method="post">

      <select name="cadena">
      <option selected value="0">Seleccione Cadena</option>
      <%
        if (cads != null) {
            for (int i=0; i<cads.length; i++) {
                CadenaBean cad = cads[i];
                out.println("<option value='"+cad.getId()+"'>"
                            +cad.getNombre()+"</option>");
            }
        }
      %>
     </select>

    <br>
    <br>

     <input type="button" value="Programas"
      onClick="javascript:send()">
 
  </form>

</center>

