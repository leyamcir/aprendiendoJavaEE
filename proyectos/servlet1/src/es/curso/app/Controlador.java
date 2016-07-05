package es.curso.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
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

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String nombre;
		
		nombre = request.getParameter("nombre");
		System.out.println("doGet -> " + nombre);
		generarRespuesta(nombre, request, response);
	}
*/
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		String nombre;
		
		nombre = request.getParameter("nombreCaja");
		System.out.println("doPost -> " + nombre);
		generarRespuesta(nombre,request,response);
	}
*/
	private void generarRespuesta(String nombre, 
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out;
		
		// Capturar un canal para escribir al cliente:
		out = response.getWriter();
		
		// Tipo de información que se vuelca al cliente
		response.setContentType("text/html");
		out.write("<h3>Hola " + nombre + "</h3>");
		
		out.close();
	}
	

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//super.service(arg0, arg1);
		String nombre;
		
		nombre = request.getParameter("nombre");
		System.out.println("Service -> " + nombre);
		generarRespuesta(nombre,request,response);
	}

}
