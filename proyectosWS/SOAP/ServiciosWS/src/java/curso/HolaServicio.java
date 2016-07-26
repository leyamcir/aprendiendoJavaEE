/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curso;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.servlet.ServletContext;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

/**
 *
 * @author cas
 */
@WebService(serviceName = "HolaServicio")
public class HolaServicio {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hola")
    public String hola(@WebParam(name = "name") String txt) {
        if (txt != null && txt.length() >0){
            return "¡Hola " + txt + " !";
        } else {
            return "¡Hola curso !";
        }
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "esprimo")
    public boolean esprimo(@WebParam(name = "numero") Long numero) {
        if (numero == null || numero <= 1) {
            return false;
        }

        long raizN = (long)Math.sqrt(numero);
        boolean primo = true;
        
        for(int i=2; i<= raizN; i++){
            if (numero % i == 0){
                primo = false;
                break;
            }
        }
        return primo;

        
    }

    /**
     * Web service operation
     */
    // Get context
    @Resource WebServiceContext wsContext;
    @WebMethod(operationName = "info")
    public String info() {
        MessageContext msc;
        msc = wsContext.getMessageContext();
        ServletContext context =
        (ServletContext) msc.get(MessageContext.SERVLET_CONTEXT);
        
        return context.getServerInfo();
    }
}
