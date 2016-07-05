package es.curso.app;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//super.service(arg0, arg1);
		String nombre = request.getParameter("nombre");
		RequestDispatcher rq;
		
		// Cambiar la cadena
		nombre = ("Hola " + nombre).toUpperCase();
		
		// Cargar un atributo a nivel de request:
		request.setAttribute("nombre", nombre);
		
		// Cargar el nuevo recurso:
		rq = request.getRequestDispatcher("resultado.jsp");
		rq.forward(request, response);
	}

	

}
