package es.curso.modelo.bo2;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import es.curso.modelo.beans.Trabajador;
import es.curso.modelo.dao.ITrabajadorDAO;

@Transactional(propagation=Propagation.REQUIRED, rollbackFor=RuntimeException.class)
public class TrabajadorBO2 implements ITrabajadorBO2 {
	
	private ITrabajadorDAO trabajadorDao;
	
	public ITrabajadorDAO getTrabajadorDao() {
		return trabajadorDao;
	}

	public void setTrabajadorDao(ITrabajadorDAO trabajadorDao) {
		this.trabajadorDao = trabajadorDao;
	}


	@Override
	public boolean insert(final Trabajador t) {
		boolean ok;
		
	
			trabajadorDao.insert(t);
			trabajadorDao.insert(t);
			ok = true;
			
			
		return ok;
		
	}

	@Override
	public boolean delete(final int id) {	
		Boolean ok = true;
		
		try {
			trabajadorDao.delete(id);
			
		} catch (RuntimeException e) {
		
			ok = false;
			
		}				
		return ok;
		
	}

	@Override
	public boolean update(final Trabajador t) {
		Boolean ok = true;
		
		try {
			trabajadorDao.update(t);
			
		} catch (RuntimeException e) {			
			ok = false;
			
		}				
		return ok;
	}

	@Override
	@Transactional(readOnly=true)
	public Trabajador get(int id) {
		return trabajadorDao.get(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Trabajador> getAll() {
		// TODO Auto-generated method stub
		return trabajadorDao.getAll();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Trabajador> getAll(Trabajador t) {
		return trabajadorDao.getAll(t);
	}

}
