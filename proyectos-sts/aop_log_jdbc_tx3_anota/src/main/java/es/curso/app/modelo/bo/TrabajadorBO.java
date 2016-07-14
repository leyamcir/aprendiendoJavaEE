package es.curso.app.modelo.bo;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import es.curso.app.modelo.beans.Trabajador;
import es.curso.app.modelo.dao.ITrabajadorDAO;

@Transactional(timeout=60, propagation=Propagation.SUPPORTS)
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
	@Transactional(propagation=Propagation.REQUIRED)
	public int saveBO(Trabajador t) {
		return dao.save(t);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public int deleteBO(int numero) {
		return dao.delete(numero);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public int updateBO(Trabajador t) {
		return dao.update(t);
	}

	public Trabajador getBO(int numero) {
		return dao.get(numero);
	}

	@Transactional(timeout=30)
	public List<Trabajador> getAllBO() {
		return dao.getAll();
	}
	
	@Transactional(timeout=30)
	public List<Trabajador> getAllBO(Trabajador t) {
		return dao.getAll(t);
	}

	public int numTrabajadoresBO() {
		return dao.numTrabajadores();
	}

}
