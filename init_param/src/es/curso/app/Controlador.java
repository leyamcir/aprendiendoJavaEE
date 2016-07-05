package es.curso.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controlador
 */
@WebServlet(
		urlPatterns = { "/Controlador" }, 
		initParams = { 
				@WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/empresa3"), 
				@WebInitParam(name = "driver", value = "org.gjt.mm.mysql.Driver"),
				@WebInitParam(name = "user", value = "root"),
				@WebInitParam(name = "pass", value = "root")
		})
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection conexion;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = request.getParameter("sql");
		String statementType = sql.split(" ")[0].toUpperCase();
		
		switch (statementType) {
			case "SELECT":
				selectStatement(sql, request, response);
				break;
			case "UPDATE":
				updateStatement(sql, request, response);
				break;
			case "DELETE":
				updateStatement(sql, request, response);
				break;
		}
		
	}
	
	private void selectStatement(String sql, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		PrintWriter out;
		Statement st;
		ResultSet rst;
		ResultSetMetaData metadata;
		
		out = response.getWriter();
		response.setContentType("text/html");
		out.println(sql);
		
		try {
			st = conexion.createStatement();
			rst = st.executeQuery(sql);
			metadata = rst.getMetaData();
			
			int cols = metadata.getColumnCount();
			out.println("<h3>Resultado de la query</h3>");
			out.println("<table>");
			out.println("<tr>");
			for (int i=1; i<=cols; i++) {
				out.println("<th>" + metadata.getColumnLabel(i) + "</th>");
			}
			out.println("</tr>");
			
			while(rst.next()){
				out.println("<tr>");
				for (int i=1; i<=cols; i++) {
					out.println("<td>" + rst.getString(metadata.getColumnLabel(i)) + "</td>");
				}
				out.println("</tr>");
			}
			out.println("</table>");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		out.close();
	}
	
	private void updateStatement(String sql, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		PrintWriter out;
		Statement st;
		
		out = response.getWriter();
		response.setContentType("text/html");
		out.println(sql);
		
		try {
			st = conexion.createStatement();
			int updated = st.executeUpdate(sql);
			
			out.println("<h3>Updated " + updated + " elements</h3>");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		out.close();
	}
	

	@Override
	public void init(ServletConfig config) throws ServletException {
		//super.init(config);
		String url = config.getInitParameter("url");
		String driver = config.getInitParameter("driver");
		String user = config.getInitParameter("user");
		String pass = config.getInitParameter("pass");
	
		try{
			Class.forName(driver);
			conexion = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void destroy() {
		//super.destroy();
		try {
			if(conexion != null){
				conexion.close();
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
