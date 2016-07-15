package es.curso.ejemplo.modelo.beans;

public class Pedido {

	private int idPedido;
	private Cliente cliente;
	private Empleado empleado;
	private EmpresaEnvios empresa;
	private double precio;
	private String pais;
	
	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Pedido(int idPedido, Cliente cliente, Empleado empleado,
			EmpresaEnvios empresa, double precio, String pais) {
		super();
		this.idPedido = idPedido;
		this.cliente = cliente;
		this.empleado = empleado;
		this.empresa = empresa;
		this.precio = precio;
		this.pais = pais;
	}
	
	
	
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public EmpresaEnvios getEmpresa() {
		return empresa;
	}
	public void setEmpresa(EmpresaEnvios empresa) {
		this.empresa = empresa;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", cliente=" + cliente
				+ ", empleado=" + empleado + ", empresa=" + empresa
				+ ", precio=" + precio + ", pais=" + pais + "]";
	}
	
	
}
