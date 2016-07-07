/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package etiquetas;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author Administrador
 */
public class SumaTag extends TagSupport {

    private int num1, num2;

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().print("Suma: " + (num1 + num2));
        } catch (IOException e) {
            throw new JspException("Error: IOException" + e.getMessage());
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return SKIP_PAGE;
    }
}
