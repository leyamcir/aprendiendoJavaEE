package es.curso.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.curso.app.Articulo;
import es.curso.app.ArticulosBD;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("*.do")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String peticion = request.getServletPath();
		switch (peticion) {
		case "/catalogo.do":
			// Llamar al JSP y pasarle los productos
			ArticulosBD articulosBD = new ArticulosBD();
			List<Articulo> articulos = articulosBD.getArticulos();
			
			request.setAttribute("articulos", articulos);
			RequestDispatcher rq = request.getRequestDispatcher("catalogo.jsp");
			rq.forward(request, response);
			break;
		case "/consulta.do":
			// Mostrar las cookies
			break;
		default:
			System.out.println("Error");
			break;
		}
	}

}
