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
public class ServletListarCookies extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Listar Cookies:
        Cookie []cookies;
        
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        
        cookies = req.getCookies();
        for (Cookie c : cookies)
            out.println(c.getName() + " " + c.getValue() + " " + c.getMaxAge() + "<br />");
        
        out.println("<a href='index.jsp'>Volver</a>");    
        out.close();
        
    }

}