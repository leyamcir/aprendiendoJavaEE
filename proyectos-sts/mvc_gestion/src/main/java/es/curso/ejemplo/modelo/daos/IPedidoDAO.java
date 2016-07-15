package es.curso.ejemplo.modelo.daos;

import java.util.List;

import es.curso.ejemplo.modelo.beans.Pedido;


public interface IPedidoDAO {
	
	public boolean grabar(Pedido pedido);
	public List<Pedido> listar();
}
