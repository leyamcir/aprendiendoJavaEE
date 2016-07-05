package es.curso.clientes;

import java.util.List;

public interface IClienteDAO {
	
	public void conectar(String login, String pass) throws DAOException;

	public int grabar(Cliente c) throws DAOException;
	
	public int borrar(String idcliente) throws DAOException;
	
	public int actualizar(Cliente cliente) throws DAOException;
	
	public Cliente leer(String idcliente) throws DAOException;
	
	public List<Cliente> leerTodos() throws DAOException;
	
	public void cerrar() throws DAOException;
}
