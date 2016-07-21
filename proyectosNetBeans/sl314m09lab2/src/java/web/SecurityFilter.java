/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cas
 */
@WebFilter(filterName = "WebFilter", urlPatterns = {"/ApplicationController"}, dispatcherTypes = {DispatcherType.REQUEST})
public class SecurityFilter implements Filter {
    
    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    
    public SecurityFilter() {
    }    

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        /*
        if (debug) {
            log("WebFilter:doFilter()");
        }
        doBeforeProcessing(request, response);
        
        */
        String operation = request.getParameter("operation");
        boolean doFilter = false;
        
        if(operation.equals("Quote")){
            if (request instanceof HttpServletRequest) {
                boolean goLogin = false;
                HttpServletRequest req = (HttpServletRequest)request;
                HttpSession session = req.getSession(false);
                if (session != null) {
                    // Session lready created.
                    String user = (String) session.getAttribute("user");
                    if (user != null){
                        doFilter = true;
                    } else {
                        goLogin = true;
                    }
                } else {
                    goLogin = true;
                }
                
                if(goLogin) {
                    RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
                    rd.forward(request, response);
                }
            }
        } else {
            doFilter = true;
        }
            
        if(doFilter){
            Throwable problem = null;
            try {
                chain.doFilter(request, response);
            } catch (Throwable t) {
                // If an exception is thrown somewhere down the filter chain,
                // we still want to execute our after processing, and then
                // rethrow the problem after that.
                problem = t;
                t.printStackTrace();
            }
        }
        
       /* 
        doAfterProcessing(request, response);

        // If there was a problem, we want to rethrow it if it is
        // a known type, otherwise log it.
        if (problem != null) {
            if (problem instanceof ServletException) {
                throw (ServletException) problem;
            }
            if (problem instanceof IOException) {
                throw (IOException) problem;
            }
            sendProcessingError(problem, response);
        }*/
    }





    /**
     * Destroy method for this filter
     */
    public void destroy() {        
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
      /*  if (filterConfig != null) {
            if (debug) {                
                log("WebFilter:Initializing filter");
            }
        
        */
    }

    /**
     * Return a String representation of this object.
     */
    /*
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("WebFilter()");
        }
        StringBuffer sb = new StringBuffer("WebFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }
    */
    /*
    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);        
        
        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);                
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");                
                pw.print(stackTrace);                
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }
    */
    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }
    /*
    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }
*/
    
}
