package es.curso.ejemplo.modelo.daos;


import java.util.List;

import es.curso.ejemplo.modelo.beans.Cliente;



public interface IClienteDAO {
	public List<Cliente> listarClientes();
}
