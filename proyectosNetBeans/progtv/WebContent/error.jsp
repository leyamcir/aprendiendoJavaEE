<!--sgs 11.04.14 -->
<%@ page isErrorPage="true" %>
<html>
<head>
<title>P�gina de Error</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<meta name="descripcion" content="P�gina gen�rica de error">
</head>

<body bgcolor="#000000" text="#ffffff" link="#ffffff" vlink="#ffffff">
  <table width="100%" cellspacing="0" cellpadding="0" border="0">
    <tr><td colspan="2" align="left">
      <img src="imagenes/error.gif" width="160" height="120"></td>
    </tr>
    <tr>
      <td width="10%">&nbsp;</td>
      <td width="90%"><font face="Verdana,Helvetica" size="2"><b>
        <%
            String msg = "";
            try {
                //if (exception != null)
                    msg = exception.getMessage();
            }
            catch (Throwable ex) {}
            if (msg == null || msg == "")
                msg = (String)request.getAttribute("mensaje");
            if (msg == null || msg == "")
                msg = "Error no especificado";
            out.write(msg);
         %>
      </b></font></td>
    </tr>
  </table>
</body>

</html>
