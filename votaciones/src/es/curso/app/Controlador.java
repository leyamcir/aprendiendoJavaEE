package es.curso.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Map <candidate, numberOfVotes>
	private Map<String,Integer> votos;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
        votos = new HashMap<String,Integer>();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		generarRespuesta(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		String candidato = request.getParameter("candidato");
		
		if(votos.containsKey(candidato)) {
			Integer votosCandidato = votos.get(candidato);
			votos.put(candidato, votosCandidato+1);
		} else {
			votos.put(candidato, 1);
		}
		
		RequestDispatcher rq = request.getRequestDispatcher("index.html");
		rq.forward(request, response);
	}
	
	private void generarRespuesta(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out;
		
		// Capturar un canal para escribir al cliente:
		out = response.getWriter();
		
		// Tipo de información que se vuelca al cliente
		response.setContentType("text/html");
		
		out.write("<h3>Resultados</h3>");
		out.write("<table>");
		
		out.write("<th><td>CANDIDATO</td><td>VOTOS</td></th>");
		
		Iterator it = votos.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Integer> entry = (Entry<String, Integer>) it.next();
			out.write("<tr>");
			out.write("<td>" + entry.getKey() + "</td>");
			out.write("<td>" + entry.getValue() + "</td>");
			out.write("</tr>");
		}
		
		/*
		// Other way
		String html = "";
		for (String candidato: votos.keySet()){
			html += "<tr>";
			html += "<td>" + candidato + "</td>";
			html += "<td>" + votos.get(candidato) + "</td>";
			html += "</tr>";
		}
		out.write(html);
		*/
		out.write("</table>");
		
		out.close();
	}

}
