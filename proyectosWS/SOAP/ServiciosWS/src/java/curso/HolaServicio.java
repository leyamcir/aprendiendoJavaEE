/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curso;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

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
}
