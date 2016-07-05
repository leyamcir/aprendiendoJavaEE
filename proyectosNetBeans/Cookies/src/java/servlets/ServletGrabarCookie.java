/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrador
 */
public class ServletGrabarCookie extends HttpServlet {


    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // Grabar las cookies en el cliente:
        String nombre = request.getParameter("nombre");
        String valor = request.getParameter("valor");
        
        Cookie cookie = new Cookie(nombre, valor);
        cookie.setMaxAge(365 * 24 * 3600);
        response.addCookie(cookie);
        
        // Ahora puedo escribir cabeceras:
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("Se ha grabado la siguiente cookie en el cliente:");
        out.println("<p>" + nombre + " = " + valor + "</p>");
        out.println("<a href='index.jsp'>Volver</a>");
        out.close();
        
    }

 
}
