package es.curso.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
			mostrarCatalogo(request,response);
			break;
		case "/consulta.do":
			// Mostrar las cookies
			consultarCompras(request, response);
			break;
		case "/procesar.do":
			// Procesar productos
			procesarForm(request, response);
			break;
		default:
			System.out.println("Error");
			break;
		}
	}

	private void mostrarCatalogo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArticulosBD articulosBD = new ArticulosBD();
		List<Articulo> articulos = articulosBD.getArticulos();
		
		request.setAttribute("articulos", articulos);
		RequestDispatcher rq = request.getRequestDispatcher("catalogo.jsp");
		rq.forward(request, response);
	}

	private void procesarForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num;
		String[] params = request.getParameterValues("ck");
		Cookie cookie;
		String nombre;
		
		// Ejemplo input hidden
		num = Integer.parseInt(request.getParameter("num"));
		System.out.println("Total: "+num);
		
		for (int i=0; i<params.length; i++) {
			nombre = "art" + params[i];
			// Grabar las cookies en el cliente
			cookie = new Cookie(nombre, params[i]);
			cookie.setMaxAge(24 * 3600 * 365);
			
			// Enviar la cookie al cliente
			response.addCookie(cookie);
		}
		
		RequestDispatcher rq = request.getRequestDispatcher("index.html");
		rq.forward(request, response);
	}

	private void consultarCompras(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie: cookies) {
			if (cookie.getName().startsWith("art")){
				System.out.println(cookie.getName() + " => " + cookie.getValue());
			}
		}
		
	}

}
