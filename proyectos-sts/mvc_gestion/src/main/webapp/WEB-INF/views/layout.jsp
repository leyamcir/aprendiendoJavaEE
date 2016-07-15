<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:insertAttribute  name="title"></tiles:insertAttribute></title>
<link rel="stylesheet" type="text/css" href="resources/css/estilos.css">
</head>
<body>
	<div id="contenedor2">
		<div id="cabecera">
			<tiles:insertAttribute name="header"></tiles:insertAttribute>
		</div>
		<div id="contenido">
			<div id="left">
				<tiles:insertAttribute name="menu"></tiles:insertAttribute>
			</div>
			<div id="right">
				<tiles:insertAttribute name="body"></tiles:insertAttribute>
			</div>
			<div id="clear"></div>
		</div>
		<div id="pie">
			<tiles:insertAttribute name="footer"></tiles:insertAttribute>
		</div>
	</div>
</body>
</html>