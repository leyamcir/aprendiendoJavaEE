package es.curso.app.modelo.bo;

import java.util.List;

import org.springframework.transaction.TransactionDefinition;
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

	public int deleteBO(final int numero) {
		//return dao.delete(numero);
		
		// Most restrictive isolation level
		txTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_SERIALIZABLE);
		
		// Execute in transacction force (if there's already one fired)
		txTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_NESTED);
		
		
		// Transaction
		return txTemplate.execute(new TransactionCallback<Integer>() {
			
			// Integer to return number. 
			// If not return necesssary, use Void class

			public Integer doInTransaction(TransactionStatus status) {
				try{
					return dao.delete(numero);
				} catch (RuntimeException e) {
					status.setRollbackOnly();
					throw e;
				}
				 
			}
			
		});
	}

	public int updateBO(final Trabajador t) {
		//return dao.update(t);
		// Transaction
		return txTemplate.execute(new TransactionCallback<Integer>() {
			
			// Integer to return number. 
			// If not return necesssary, use Void class

			public Integer doInTransaction(TransactionStatus status) {
				try{
					return dao.update(t);
				} catch (RuntimeException e) {
					status.setRollbackOnly();
					throw e;
				}
				 
			}
			
		});
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
