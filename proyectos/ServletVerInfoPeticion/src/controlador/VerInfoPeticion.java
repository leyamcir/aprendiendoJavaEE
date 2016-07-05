package controlador;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class VerInfoPeticion extends HttpServlet { 
// Maneja el método GET de HTTP para 
// construir una sencilla página Web. 

public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	PrintWriter out; 
	String title = "LA PETICION"; 
	
	// primero selecciona el tipo de contenidos y otros campos de cabecera de la respuesta 
	response.setContentType("text/html"); 
	// Luego escribe los datos de la respuesta 
	out = response.getWriter(); 
	out.println("<HTML><HEAD><TITLE>"); 
	out.println(title); 
	out.println("</TITLE></HEAD><BODY>"); 
	out.println("<H1>" + title + "</H1>"); 
	out.println("<P>NOMBRE DEL PROTOCOLO:" + request.getProtocol()+ "</p>"); 
	out.println("<P>NOMBRE DEL HOST:" + request.getRemoteHost()+ "</p>"); 
	out.println("<P>Caracter de Encoding:" + request.getCharacterEncoding()+ "</p>"); 
	out.println("<P>La dirección IP:" + request.getRemoteAddr()+ "</p>"); 
	out.println("<P>El nombre del Esquema:" + request.getScheme()+ "</p>");
    out.println("<P>Longitud:" + request.getContentLength()+ "</p>");
    out.println("<P>Tipo:" + request.getContentType()+ "</p>");
    out.println("<p>Nombre del servidor que recibio la respuesta " + request.getServerName() + "</p>");
    out.println("<p>Numero de puerto:" + request.getServerPort() + "</p>");
    out.println("<p>ServletPath:" + request.getServletPath()+"</p>" );
    out.println("<p>ServletContext (ContextPath): " + getServletContext().getContextPath());
    out.println("<p>Parametro global: " + this.getServletContext().getInitParameter("paramGlobal"));
    out.println("<p>Parametro init servlet: " + this.getInitParameter("paramServlet"));
    
   //enum = request.getParameterNames();

	
	//enum2 = request.getAttributeNames();
	
	out.println("</body></html>");
	out.close();
} 
} 
