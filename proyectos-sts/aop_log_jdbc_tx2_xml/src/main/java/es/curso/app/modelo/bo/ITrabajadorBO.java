package es.curso.app.modelo.bo;

import java.util.List;

import es.curso.app.modelo.beans.Trabajador;

public interface ITrabajadorBO {

	public int saveBO(Trabajador t);
	public int deleteBO(int numero);
	public int updateBO(Trabajador t);
	public Trabajador getBO(int numero);
	public List<Trabajador> getAllBO();
	public List<Trabajador> getAllBO(Trabajador t);
	public int numTrabajadoresBO();
}
