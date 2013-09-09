package kr.pe.kwonnam.jsp.inheritance;

import javax.servlet.ServletException;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Author: KwonNam Son(kwon37xi@gmail.com)
 */
public class ExtendsTag extends SimpleTagSupport {
    /** Parent Template name(relative path) **/
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void doTag() throws JspException, IOException {
        StringWriter ignoredWriter = new StringWriter();
        getJspBody().invoke(ignoredWriter); // ignore body text

        PageContext pageContext = (PageContext)getJspContext();

        try {
            pageContext.forward(name);
        } catch (ServletException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}