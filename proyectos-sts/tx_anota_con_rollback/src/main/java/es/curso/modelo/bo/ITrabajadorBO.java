package es.curso.modelo.bo;

import java.util.List;

import es.curso.modelo.beans.Trabajador;

public interface ITrabajadorBO {
	
	public boolean insert(Trabajador t);
	public boolean delete(int id);
	public boolean update(Trabajador t);
	public Trabajador get(int id);
	public List<Trabajador> getAll();
	public List<Trabajador> getAll(Trabajador t);

}
