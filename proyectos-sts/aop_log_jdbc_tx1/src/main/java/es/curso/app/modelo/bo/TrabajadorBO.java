package es.curso.app.modelo.bo;

import java.util.List;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
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
	public int saveBO(final Trabajador t) {
		// Transaction
		return txTemplate.execute(new TransactionCallback<Integer>() {
			
			// Integer to return number. 
			// If not return necesssary, use Void class

			public Integer doInTransaction(TransactionStatus status) {
				try{
					return dao.save(t);
				} catch (RuntimeException e) {
					status.setRollbackOnly();
					throw e;
				}
				 
			}
			
		});
		
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
