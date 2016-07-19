package progtv;

import local.*;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;

/**
 * Servlet que implementa el Controlador MVC
 * Está mapeado a cualquier extensión *.do
 *
 * @author sgs
 */

public class ServletControl extends HttpServlet {
	private static final long serialVersionUID = 0;

    private ServletContext context = null;

    private final String error  = "/error.jsp";
    private final String inicio = "/inicio.jsp";

    //private final int trace = 1;

    //
    public void init (ServletConfig config) throws ServletException {
        super.init(config);

        // Inicializaciones
        ApW.tracesys("ServletControl init..");
        context = config.getServletContext();

        // Datos para trace del sistema
        Integer scont = (Integer)context.getAttribute("scont");
        if (scont==null) {
            scont = new Integer(0);
            ApW.trace("ServerInfo = "+context.getServerInfo());
            ApW.trace("ServletVersion = "+context.getMajorVersion()+"."
                                           +context.getMinorVersion());
            ApW.trace("RealPath = "+context.getRealPath("/"));
            try {
                ApW.trace("Path = "+context.getResource("/").toString());
                
            } catch (Exception ex) {}
        }
        else
            scont = new Integer(scont.intValue()+1);
        context.setAttribute("scont",scont);
        ApW.trace("scont="+scont);
    }

    //
    public void service (HttpServletRequest req, HttpServletResponse res)
                         throws ServletException,IOException {
        String next   = error;
        String accion = null;
        String vdir   = "";
        HttpSession ses = req.getSession();// Si la sesión no estaba previamente creada, se crea

        try {
            // Analis de url para determinar componentes
            StringBuffer url = req.getRequestURL();
            String uri = req.getRequestURI();
            String query = req.getQueryString();
            String path = req.getServletPath();
            ApW.trace("url="+url+" query="+query);
            ApW.trace("path="+path);
            String s[] = getURLData(path);
            if (s[1] == ".do")
                accion = s[2];
            else
                accion = s[0];
            accion = accion.toLowerCase().intern(); 
            ApW.trace("accion="+accion);

            // Limpiar atributos generales
            req.setAttribute("mensaje","");
            req.setAttribute("context","");

            Context ctx = new InitialContext();
            if (ctx != null)
                req.setAttribute("context",ctx.getNameInNamespace());

            do {
                // Obtención directorio virtual de la aplicación
                int irp = uri.indexOf(path);
                if (irp >= 0) {
                    vdir = uri.substring(0,irp);
                    ApW.trace("vdir="+vdir);
                    ses.setAttribute("vdir",vdir);
                    context.setAttribute("vdir",vdir);
                }

                if (accion.equals("servletcontrol"))
                    accion = "login";

                if (accion == "login") {
                    String user = req.getParameter("Usuario");
                    if (user == null) {
                        req.setAttribute("mensaje","Acceso no permitido");
                        next = error;
                        break;
                    }
                    String pass = req.getParameter("Password");

                    // Instanciar UserBean
                    UserBean usr = new UserBean(user);
                    if (!usr.login(pass)) {
                        req.setAttribute("mensaje",usr.getMensaje());
                        next = error;
                        break;
                    }
                    ses.setAttribute("usr",usr);
                    ses.setAttribute("instance",context.getRealPath("/"));

                    accion = "inicio";
                }

			    UserBean usr = (UserBean)ses.getAttribute("usr");
                if (usr != null) {
                    ApW.trace(usr.getUser());
                }
                else  {
                    req.setAttribute("mensaje","Acceso inválido");
                    next = error;
                    break;
                }
                     
                if (accion == "inicio") {
                    // Instanciar array de Cadenas
                    CadenaBean cads[] = CadenaBean.leerAll();
                    req.setAttribute("cads",cads);
                    next = inicio;
                    break;
                }

                if (accion == "programas") {
                    String idc = req.getParameter("cadena");
                    ApW.trace("idc="+idc);

                    // Instanciar CadenaBean
                    CadenaBean cad = new CadenaBean(idc);
                    req.setAttribute("cad",cad);
                    cad.leer();

                    // Instanciar array de Programas
                    ProgramaBean progs[] = ProgramaBean.leerAll(cad.getId());
                    req.setAttribute("progs",progs);

                    next = "/programas.jsp";
                    break;
                }

                next = error;
                req.setAttribute("mensaje","Error de proceso");

            } while (false);

        }
        catch (Exception ex) {
            ApW.error(ex);
            req.setAttribute("javax.servlet.jsp.jspException",ex);
            next = error;
        }

        ApW.trace("next="+next);
        RequestDispatcher rd;
        rd = req.getRequestDispatcher(next);
        rd.forward(req,res);
    }

    //
    // Obtiene datos de una URL
    // Devuelve un array de strings:
    //     [0] el fichero base
    //     [1] la extension base
    //     [2] el fichero base sin extension
    //     [3] la URL suprimiendo la extension
    // Ejemplo http://www.kafka.com/castillo.jsp.do?agri=mensor
    //         [0] castillo.jsp.do
    //         [1] .do
    //         [2] castillo.jsp
    //         [3] http://www.kafka.com/castillo.jsp?agri=mensor
    //
    public static String[] getURLData (String url)
                  throws Exception {
        String s[] = new String[4];
        int k = url.indexOf('?');
        if (k < 0)
            k = url.indexOf('#');
        if (k >= 0)
            s[0] = url.substring(0,k);
        else
            s[0] = url;
        int i = s[0].lastIndexOf('/');
        if (i < 0)
            i = s[0].lastIndexOf('\\');
        s[0] = s[0].substring(i+1);
        int j = s[0].lastIndexOf('.');
        if (j > 0) {
            s[2] = s[0].substring(0,j);
            s[1] = s[0].substring(j);
        }
        else {
            s[2] = s[0];
            s[1] = "";
        }
        s[3] = url.substring(0,i+1) + s[2];
        if (k > 0)
           s[3] += url.substring(k);
        for (i=0;i<s.length;i++)
            s[i] = s[i].trim().intern();
        return s;
    }

}
