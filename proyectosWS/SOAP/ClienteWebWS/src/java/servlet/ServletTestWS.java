/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import cliente2.HolaServicio_Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author cas
 */
@WebServlet(name = "ServletTestWS", urlPatterns = {"/ServletTestWS"})
public class ServletTestWS extends HttpServlet {

    @WebServiceRef(wsdlLocation = "http://localhost:8080/cursows/HolaServicio?wsdl")
    private HolaServicio_Service service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletTestWS</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletTestWS at " + request.getContextPath() + "</h1>");
            out.println("<h2>Response: " + hola("caracola") + "</h2>");
            out.println("<h2>Es primo 2: " + esprimo(new Long(2)) + "</h2>");
            out.println("<h2>Es primo 7: " + esprimo(new Long(7)) + "</h2>");
            out.println("<h2>Es primo 25: " + esprimo(new Long(25)) + "</h2>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String hola(java.lang.String name) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        cliente2.HolaServicio port = service.getHolaServicioPort();
        return port.hola(name);
    }

    private boolean esprimo(java.lang.Long numero) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        cliente2.HolaServicio port = service.getHolaServicioPort();
        return port.esprimo(numero);
    }

    
}
