package es.curso.app;

import java.security.KeyStore.SecretKeyEntry;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Principal {

	private static final String URL = "jdbc:mysql://localhost:3306/empresa3";

	public static void main(String[] args) {
		//recuperarClientes();
//		actualizarCliente();	
		//recuperarClientesPS();
		
		//actualizarClientePS();
		llamarProcesoAlmacenado();
	}
	
	private static void llamarProcesoAlmacenado() {
		Connection con=null;
		String sql;
		CallableStatement sentencia;
		int n;
				
		try {
			// 1) Cargar el driver:
			Class.forName("org.gjt.mm.mysql.Driver");
			
			// 2) Abrir la conexion:
			con = DriverManager.getConnection(URL,"root","root");
			
			// 3) Crear el SQL:
			sql = "{call actualizarPais(?,?)}";
			
			// 4) Crear la sentencia:
			sentencia = con.prepareCall(sql);
			sentencia.setString(1, "ALFKI");
			sentencia.setString(2, "Francia");
			
			// 5) Ejecutar la query:
			n = sentencia.executeUpdate();
			
			System.out.println("Actualizados: " + n);
									
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
		} finally {
			try {				
				if (con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
	}
	
	
	private static void actualizarClientePS() {
		Connection con=null;
		String sql;
		PreparedStatement sentencia;
		int n;
				
		try {
			// 1) Cargar el driver:
			Class.forName("org.gjt.mm.mysql.Driver");
			
			// 2) Abrir la conexion:
			con = DriverManager.getConnection(URL,"root","root");
			
			// 3) Crear el SQL:
			sql = "update clientes set pais=?"+
			      "where idcliente=?";
			
			// 4) Crear la sentencia:
			sentencia = con.prepareStatement(sql);
			sentencia.setString(1, "Francia");
			sentencia.setString(2, "ALFKI");
			
			// 5) Ejecutar la query:
			n = sentencia.executeUpdate();
			
			System.out.println("Actualizados: " + n);
									
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
		} finally {
			try {				
				if (con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		
		
	}

	private static void recuperarClientesPS() {
		Connection con=null;
		String sql;
		PreparedStatement sentencia;
		ResultSet rst=null;
				
		try {
			// 1) Cargar el driver:
			Class.forName("org.gjt.mm.mysql.Driver");
			
			// 2) Abrir la conexion:
			con = DriverManager.getConnection(URL,"root","root");
			
			// 3) Crear el SQL:
			sql = "select * from clientes where pais=?";
			
			// 4) Crear la sentencia:
			sentencia = con.prepareStatement(sql);
			
			// 4') Rellenar los parametros:
			sentencia.setString(1, "Francia");
			
			// 5) Ejecutar la query:
			rst = sentencia.executeQuery();
			
			// 6) Iterar por los resultados:
			while (rst.next()){
				System.out.print(rst.getString("idcliente"));
				System.out.println("\t"+rst.getString("nombre"));
			}
									
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
		} finally {
			try {
				rst.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}// TODO Auto-generated method stub
		
	}
	
	

	private static void actualizarCliente() {
		Connection con=null;
		String sql;
		Statement sentencia;
		int n;
				
		try {
			// 1) Cargar el driver:
			Class.forName("org.gjt.mm.mysql.Driver");
			
			// 2) Abrir la conexion:
			con = DriverManager.getConnection(URL,"root","root");
			
			// 3) Crear el SQL:
			sql = "update clientes set pais='Portugal'"+
			      "where idcliente='ALFKI'";
			
			// 4) Crear la sentencia:
			sentencia = con.createStatement();
			
			// 5) Ejecutar la query:
			n = sentencia.executeUpdate(sql);
			
			System.out.println("Actualizados: " + n);
									
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
		} finally {
			try {				
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		
	}

	private static void recuperarClientes() {
		Connection con=null;
		String sql;
		Statement sentencia;
		ResultSet rst=null;
				
		try {
			// 1) Cargar el driver:
			Class.forName("org.gjt.mm.mysql.Driver");
			
			// 2) Abrir la conexion:
			con = DriverManager.getConnection(URL,"root","root");
			
			// 3) Crear el SQL:
			sql = "select * from clientes";
			
			// 4) Crear la sentencia:
			sentencia = con.createStatement();
			
			// 5) Ejecutar la query:
			rst = sentencia.executeQuery(sql);
			
			// 6) Iterar por los resultados:
			while (rst.next()){
				System.out.print(rst.getString("idcliente"));
				System.out.println("\t"+rst.getString("nombre"));
			}
									
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
		} finally {
			try {
				rst.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}// TODO Auto-generated method stub
		
	}
}
