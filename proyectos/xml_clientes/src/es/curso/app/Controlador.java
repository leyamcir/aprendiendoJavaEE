package es.curso.app;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.curso.clientes.Cliente;
import es.curso.clientes.ClienteDAO;
import es.curso.clientes.DAOException;
import es.curso.clientes.IClienteDAO;

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
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IClienteDAO cliente = new ClienteDAO();
		try {
			cliente.conectar("root", "root");
			List<Cliente> clientes = cliente.leerTodos();
			request.setAttribute("clientes", clientes);
			RequestDispatcher rq = request.getRequestDispatcher("clientes.jsp");
			rq.forward(request, response);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
