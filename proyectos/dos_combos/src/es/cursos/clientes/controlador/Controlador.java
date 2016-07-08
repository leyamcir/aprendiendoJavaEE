package es.cursos.clientes.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.curso.clientes.beans.Cliente;
import es.curso.clientes.dao.ClienteDAO;
import es.curso.clientes.dao.DAOException;
import es.curso.clientes.dao.IClienteDAO;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("*.do")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private IClienteDAO clienteDAO;
	
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
		clienteDAO = new ClienteDAO();
		try {
			clienteDAO.conectar("root", "root");
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			clienteDAO.cerrar();
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rq;
		String pais = request.getParameter("pais");
		try{
			// Primera vez, cargar TODOS los países
			List<String> paises = clienteDAO.getPaises();
			request.setAttribute("paises", paises);
			
			PrintWriter out;
			
			if (pais == null) {
				rq = request.getRequestDispatcher("combos.jsp");
				rq.forward(request, response);
			} else {
			
				// Ha cambiado el país, cargar clientes de ese país
				
				//out = response.getWriter();
			//	out.print("hola");
			//	out.close();
				List<Cliente> clientes = clienteDAO.clientesEnPais(pais);
				request.setAttribute("clientes", clientes);
				rq = request.getRequestDispatcher("combo_cliente.jsp");
				rq.forward(request, response);
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
	}

}
