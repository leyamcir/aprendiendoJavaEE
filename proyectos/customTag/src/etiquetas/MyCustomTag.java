/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package etiquetas;

import java.io.IOException;
import java.util.Date;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author Administrador
 */
public class MyCustomTag extends TagSupport {

    @Override
    public int doEndTag() throws JspException {
        JspWriter out = pageContext.getOut();
        
        try {
            out.println("Hola, desde la etiqueta son las " + new Date());
        } catch (IOException ex) {
            
        }
        return super.doEndTag();        
    } 
}
