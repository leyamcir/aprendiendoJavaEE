package es.curso.modelo.dao;

import java.util.List;

import es.curso.modelo.beans.Trabajador;

public interface ITrabajadorDAO {
	
	public void insert(Trabajador t);
	public void delete(int id);
	public void update(Trabajador t);
	public Trabajador get(int id);
	public List<Trabajador> getAll();
	public List<Trabajador> getAll(Trabajador t);
}
