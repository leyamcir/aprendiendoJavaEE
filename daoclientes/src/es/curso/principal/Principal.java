package es.curso.principal;

import java.util.List;

import es.curso.clientes.Cliente;
import es.curso.clientes.ClienteDAO;
import es.curso.clientes.DAOException;
import es.curso.clientes.IClienteDAO;

public class Principal {
	

	public static void main(String[] args) {
		IClienteDAO clienteDAO;
		List<Cliente> clientes;

		try {
			clienteDAO = new ClienteDAO();
			clienteDAO.conectar("root", "root");
			clientes = clienteDAO.leerTodos();
			
			for (Cliente c : clientes){
				System.out.println(c);
			}
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}
	}

}
