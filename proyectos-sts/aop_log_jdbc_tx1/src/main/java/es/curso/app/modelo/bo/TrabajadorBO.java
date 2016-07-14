package es.curso.app.modelo.bo;

import java.util.List;

import org.springframework.transaction.support.TransactionTemplate;

import es.curso.app.modelo.beans.Trabajador;
import es.curso.app.modelo.dao.ITrabajadorDAO;

public class TrabajadorBO implements ITrabajadorBO{
	
	private ITrabajadorDAO dao;
	private TransactionTemplate txTemplate;
	

	// Getters & setter
	public ITrabajadorDAO getDao() {
		return dao;
	}

	public void setDao(ITrabajadorDAO dao) {
		this.dao = dao;
	}

	public TransactionTemplate getTxTemplate() {
		return txTemplate;
	}

	public void setTxTemplate(TransactionTemplate txTemplate) {
		this.txTemplate = txTemplate;
	}
	
	// Interface methods 
	public int saveBO(Trabajador t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteBO(int numero) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateBO(Trabajador t) {
		// TODO Auto-generated method stub
		return 0;
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
