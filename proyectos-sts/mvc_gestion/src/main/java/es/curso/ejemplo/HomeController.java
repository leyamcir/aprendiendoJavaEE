package es.curso.ejemplo;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.curso.ejemplo.modelo.beans.Cliente;
import es.curso.ejemplo.modelo.beans.Empleado;
import es.curso.ejemplo.modelo.beans.EmpresaEnvios;
import es.curso.ejemplo.modelo.beans.Pedido;
import es.curso.ejemplo.modelo.daos.ClienteDAO;
import es.curso.ejemplo.modelo.daos.EmpleadoDAO;
import es.curso.ejemplo.modelo.daos.EmpresaEnviosDAO;
import es.curso.ejemplo.modelo.daos.PedidoDAO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private PedidoDAO pedidoDAO;
	
	@Autowired
	private ClienteDAO clienteDAO;
	
	@Autowired
	private EmpleadoDAO empleadoDAO;
	
	@Autowired
	private EmpresaEnviosDAO empresaEnviosDAO;
	
	@ModelAttribute("pedido")
	public Pedido inicializar(){
		return new Pedido();
	}
	
	@ModelAttribute("clientes")
	public List<Cliente> cargaClientes(){
		return clienteDAO.listarClientes();		
	}
	
	@ModelAttribute("empleados")
	public List<Empleado> cargaEmpleados(){
		return empleadoDAO.listarEmpleados();
	}
	
	@ModelAttribute("empresas")
	public List<EmpresaEnvios> cargaEmpresas(){
		return empresaEnviosDAO.listarEmpresasEnvios();
	}
	
	@RequestMapping(value = {"/","/home","/{lang}"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {	
		return "principal";
	}
	
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public String nuevo(Locale locale, Model model) {	
		return "nuevo_pedido";
	}
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Locale locale, Model model) {			
		model.addAttribute("pedidos", pedidoDAO.listar());		
		return "listar_pedidos";
	}
	
	@RequestMapping(value = "/grabarPedido", method = RequestMethod.POST)
	public String grabarPedido(Pedido pedido) {			
		pedidoDAO.grabar(pedido);
		return "principal";
	}
}
