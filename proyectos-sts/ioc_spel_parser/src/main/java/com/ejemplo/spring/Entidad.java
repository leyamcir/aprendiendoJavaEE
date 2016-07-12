package com.ejemplo.spring;

import java.util.List;

public class Entidad {
	
	private User usuario;
	private List<String> nombreUsuarios;
	private List<User> mayores18;
	private User mayor;
	
	public User getUsuario() {
		return usuario;
	}
	
	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
	
	public List<String> getNombreUsuarios() {
		return nombreUsuarios;
	}
	
	public void setNombreUsuarios(List<String> nombreUsuarios) {
		this.nombreUsuarios = nombreUsuarios;
	}
	
	public List<User> getMayores18() {
		return mayores18;
	}
	
	public void setMayores18(List<User> mayores18) {
		this.mayores18 = mayores18;
	}
	
	public User getMayor() {
		return mayor;
	}
	
	public void setMayor(User mayor) {
		this.mayor = mayor;
	}

	@Override
	public String toString() {
		return "Entidad [usuario=" + usuario + ", nombreUsuarios="
				+ nombreUsuarios + ", mayores18=" + mayores18 + ", mayor="
				+ mayor + "]";
	}

	
}