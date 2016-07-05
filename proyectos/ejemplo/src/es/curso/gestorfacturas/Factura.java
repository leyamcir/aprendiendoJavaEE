package es.curso.gestorfacturas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Factura {
	
	private static final double IVA = 0.21;
	private Date fecha;
	private int numero;
	private Cliente cliente;
	private List<LineaDePedido> lineas;
	
	public Factura(int numero, Cliente cliente) {
		super();
		this.numero = numero;
		this.cliente = cliente;
		this.fecha = new Date();
		this.lineas = new ArrayList<>();
	}
	
	public void addLinea(LineaDePedido linea){
		lineas.add(linea);
	}
	
	public double getBaseImponible(){
		double bi = 0;
		
		for (LineaDePedido linea : lineas)
			bi += linea.getTotal();
		return bi;
	}
	
	public double getIVA(){
		return IVA * getBaseImponible();
	}
	
	public double getTotal(){
		return getBaseImponible() + getIVA();
	}
	
	public void print(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Fecha: " + sdf.format(fecha));
		System.out.println("Numero: " + numero);
		System.out.println(cliente);
		
		Collections.sort(lineas, 
		new OrdenarLineas(OrdenarLineas.PRECIO, OrdenarLineas.ASC));
		
		for (LineaDePedido linea : lineas)
			System.out.println(linea);
		System.out.println("Base Imponible: " + getBaseImponible());
		System.out.println("IVA: " + IVA + " " + getIVA());
		System.out.println(getTotal());
		
	}
}
