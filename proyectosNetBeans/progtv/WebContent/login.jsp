<html>
<head>
<title>Login</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<meta name="copyright" content="Curso Java/J2EE">
<link rel="stylesheet" type="text/css" href="estilos.css">
</head>

<script language="JavaScript">
    function sendlogin () {
        if (document.login.Usuario.value=="") {
            alert("Debe introducir Usuario.");
            document.login.Usuario.focus();
        }
        else {
            document.login.action="login.do";
            document.login.submit();
        }
    }
</script>

<body>
<center>
   <br>
   <h2>Identificación</h2>
   <p class="titulo_centrado2">Por favor introduzca su Usuario y Clave de Acceso:
   <form name="login" method="post">
   <table class="principaldatos" cellspacing="16">
   <tr>
    <td width="50"> Usuario: </td>
    <td> <input type="text" name="Usuario"> </td>
   </tr>
   <tr>
    <td> Clave: </td>
    <td> <input type="password" name="Password"> </td>
   </tr>
   </table>
   <br>
    <P>
    <input type="button" value=" Enviar " onClick="javascript:sendlogin()">&nbsp;
    <input type="reset" value=" Borrar ">
   </form>
 </center>
</body>

</html>
