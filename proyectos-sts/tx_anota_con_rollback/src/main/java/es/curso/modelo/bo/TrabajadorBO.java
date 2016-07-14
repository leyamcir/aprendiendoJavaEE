package es.curso.modelo.bo;

import java.util.List;

import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import es.curso.modelo.beans.Trabajador;
import es.curso.modelo.dao.ITrabajadorDAO;

public class TrabajadorBO implements ITrabajadorBO {
	
	private ITrabajadorDAO trabajadorDao;
	private TransactionTemplate transactionTemplate;
	

	public ITrabajadorDAO getTrabajadorDao() {
		return trabajadorDao;
	}

	public void setTrabajadorDao(ITrabajadorDAO trabajadorDao) {
		this.trabajadorDao = trabajadorDao;
	}

	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	@Override
	public boolean insert(final Trabajador t) {
		return transactionTemplate.execute(new TransactionCallback<Boolean>(){

			@Override
			public Boolean doInTransaction(TransactionStatus tx) {
				Boolean ok = true;
				
				try {
					trabajadorDao.insert(t);
					
				} catch (RuntimeException e) {
					tx.setRollbackOnly();
					ok = false;
					
				}				
				return ok;
			}
			
		});
		
	}

	@Override
	public boolean delete(final int id) {
		return transactionTemplate.execute(new TransactionCallback<Boolean>(){

			@Override
			public Boolean doInTransaction(TransactionStatus tx) {
				Boolean ok = true;
				
				try {
					trabajadorDao.delete(id);
					
				} catch (RuntimeException e) {
					tx.setRollbackOnly();
					ok = false;
					
				}				
				return ok;
			}
			
		});
		
	}

	@Override
	public boolean update(final Trabajador t) {
		transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_SERIALIZABLE);
		return transactionTemplate.execute(new TransactionCallback<Boolean>(){

			@Override
			public Boolean doInTransaction(TransactionStatus tx) {
				Boolean ok = true;
				
				try {
					trabajadorDao.update(t);
					
				} catch (RuntimeException e) {
					tx.setRollbackOnly();
					ok = false;
					
				}				
				return ok;
			}
			
		});
		
		
	}

	@Override
	public Trabajador get(int id) {
		return trabajadorDao.get(id);
	}

	@Override
	public List<Trabajador> getAll() {
		// TODO Auto-generated method stub
		return trabajadorDao.getAll();
	}

	@Override
	public List<Trabajador> getAll(Trabajador t) {
		return trabajadorDao.getAll(t);
	}

}
