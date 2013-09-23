package kr.pe.kwonnam.jsp.inheritance;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

/**
 * 상속할 레이아웃을 지정하는 태그
 * <p/>
 * Author: KwonNam Son(kwon37xi@gmail.com)
 */
public class ExtendsTag extends SimpleTagSupport {
    public static final String PREFIX_ATTR_NAME = "jsp-inheritance-prefix";
    public static final String SUFFIX_ATTR_NAME = "jsp-inheritance-suffix";
    /**
     * Parent Template name(relative path) *
     */
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void doTag() throws JspException, IOException {
        StringWriter ignoredWriter = new StringWriter();
        getJspBody().invoke(ignoredWriter); // ignore body text

        PageContext pageContext = (PageContext) getJspContext();

        try {
            pageContext.forward(getRefinedName());
        } catch (ServletException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    protected String getRefinedName() {
        ServletContext servletContext = ((PageContext) getJspContext()).getServletContext();
        String prefix = servletContext.getInitParameter(PREFIX_ATTR_NAME);
        String suffix = servletContext.getInitParameter(SUFFIX_ATTR_NAME);

        if (prefix == null) {
            prefix = "";
        }

        if (suffix == null) {
            suffix = "";
        }

        return prefix + name + suffix;
    }
}