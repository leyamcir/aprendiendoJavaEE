package org.ejemplo.modelo;

public class Vehiculo implements IVehiculo {

	@Override
	public void arrancar() {
		// TODO Auto-generated method stub
		System.out.println("llamada al metodo arrancar");
	}

	@Override
	public void parar() {
		// TODO Auto-generated method stub
		System.out.println("llamada al metodo parar");
	}

	@Override
	public void acelerar() {
		// TODO Auto-generated method stub
		System.out.println("llamada al metodo acelerar");
	}

}
