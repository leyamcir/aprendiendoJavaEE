package es.curso.mvc.models.dao;

import java.util.List;

import es.curso.mvc.models.bean.Trabajador;


public interface ITrabajadorDAO {
	
	public int save(Trabajador t);
	public int delete(int numero);
	public int update(Trabajador t);
	public Trabajador get(int numero);
	public List<Trabajador> getAll();
	public List<Trabajador> getAll(Trabajador t);
	public int numTrabajadores();
}
