package es.curso.app.modelo.bo;

import java.util.List;

import org.springframework.transaction.support.TransactionTemplate;

import es.curso.app.modelo.beans.Trabajador;
import es.curso.app.modelo.dao.ITrabajadorDAO;

public class TrabajadorBO implements ITrabajadorBO{
	
	private ITrabajadorDAO dao;
	

	// Getters & setter
	public ITrabajadorDAO getDao() {
		return dao;
	}

	public void setDao(ITrabajadorDAO dao) {
		this.dao = dao;
	}
	
	// Interface methods 
	public int saveBO(Trabajador t) {
		return dao.save(t);
	}

	public int deleteBO(int numero) {
		return dao.delete(numero);
	}

	public int updateBO(Trabajador t) {
		return dao.update(t);
	}

	public Trabajador getBO(int numero) {
		return dao.get(numero);
	}

	public List<Trabajador> getAllBO() {
		return dao.getAll();
	}

	public List<Trabajador> getAllBO(Trabajador t) {
		return dao.getAll(t);
	}

	public int numTrabajadoresBO() {
		return dao.numTrabajadores();
	}

}
