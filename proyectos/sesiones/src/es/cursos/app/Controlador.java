package es.cursos.app;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		String paginaDestino;
		
		switch (request.getServletPath()) {
		case "/login.do":
			paginaDestino = doLogin(request,response);
			break;
		case "/logout.do":
			paginaDestino = doLogout(request,response);
			break;
		default:
			paginaDestino = "index.html";
			break;
		}
		RequestDispatcher rq = request.getRequestDispatcher(paginaDestino);
		rq.forward(request, response);
	}

	private String doLogin(HttpServletRequest request, HttpServletResponse response) {
		String login = request.getParameter("login");
		String pass = request.getParameter("pass");
		String paginaDestino;
		
		if (login!= null && pass != null &&
			login.equals("admin") && pass.equals("123")) {
			// Crear sesión
			HttpSession sesion = request.getSession(true);
			
			// Almacenar login en la sesión
			sesion.setAttribute("user", login);
			
			// Ir a la página de sesión iniciada
			paginaDestino = "principal.jsp";
			
		} else {
			// Ir al formulario de inicio
			paginaDestino = "index.html";
		}
		return paginaDestino;
	}

	private String doLogout(HttpServletRequest request, HttpServletResponse response) {
		request.getSession(true).invalidate();
		return "index.html";
	}

}
