package es.curso.principal;

import java.util.List;

import es.curso.gestorfacturas.Articulo;
import es.curso.gestorfacturas.Cliente;
import es.curso.gestorfacturas.Factura;
import es.curso.gestorfacturas.LineaDePedido;

public class Gestor {

	public static void main(String[] args) {
		List<Cliente> clientes;
		Cliente cliente;

		// clientes = new ArrayList<>();
		//
		// clientes.add(new Cliente("343434A", "SRT", "Orense 5"));
		// clientes.add(new Cliente("1234B", "ASD", "Atocha 11"));
		// clientes.add(new Cliente("3676734A", "GTG", "Gran via 5"));
		//
		// cli = new Cliente("343434A", "SRT", "Orense 5");
		// if (clientes.contains(cli))
		// System.out.println(cli.getCif() + " existe");
		//
		// for (Cliente c : clientes)
		// System.out.println(c);

		cliente = new Cliente("343434A", "SRT", "Orense 5");
		Factura f = new Factura(1, cliente);
		f.addLinea(new LineaDePedido(3, new Articulo(1, "portatil", 550)));
		f.addLinea(new LineaDePedido(2, new Articulo(2, "mesa", 80)));

		f.print();
	}

}
