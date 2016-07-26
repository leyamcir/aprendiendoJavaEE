
package curso;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "HolaServicio", targetNamespace = "http://curso/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface HolaServicio {


    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "info", targetNamespace = "http://curso/", className = "curso.Info")
    @ResponseWrapper(localName = "infoResponse", targetNamespace = "http://curso/", className = "curso.InfoResponse")
    @Action(input = "http://curso/HolaServicio/infoRequest", output = "http://curso/HolaServicio/infoResponse")
    public String info();

    /**
     * 
     * @param numero
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "esprimo", targetNamespace = "http://curso/", className = "curso.Esprimo")
    @ResponseWrapper(localName = "esprimoResponse", targetNamespace = "http://curso/", className = "curso.EsprimoResponse")
    @Action(input = "http://curso/HolaServicio/esprimoRequest", output = "http://curso/HolaServicio/esprimoResponse")
    public boolean esprimo(
        @WebParam(name = "numero", targetNamespace = "")
        Long numero);

    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "hola", targetNamespace = "http://curso/", className = "curso.Hola")
    @ResponseWrapper(localName = "holaResponse", targetNamespace = "http://curso/", className = "curso.HolaResponse")
    @Action(input = "http://curso/HolaServicio/holaRequest", output = "http://curso/HolaServicio/holaResponse")
    public String hola(
        @WebParam(name = "name", targetNamespace = "")
        String name);

}
