package kr.pe.kwonnam.jsp.inheritance;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.ServletContext;
import javax.servlet.jsp.PageContext;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Author: KwonNam Son(kwon37xi@gmail.com)
 */
@RunWith(MockitoJUnitRunner.class)
public class ExtendsTagTest {
    @Mock
    private PageContext pageContext;

    @Mock
    private ServletContext servletContext;

    private ExtendsTag extendsTag;

    @Before
    public void setUp() {
        extendsTag = new ExtendsTag();
        extendsTag.setJspContext(pageContext);
        when(pageContext.getServletContext()).thenReturn(servletContext);
    }

    @Test
    public void getRefinedName_no_prefix_suffix() {
        final String name = "/WEB-INF/resources/base.jsp";
        extendsTag.setName(name);
        assertThat(extendsTag.getRefinedName(), is(name));
    }

    @Test
    public void getRefinedName_with_prefix_suffix() {
        final String name = "base/site";
        final String prefix = "/WEB-INF/resources/layouts/";
        final String suffix = ".jsp";

        when(servletContext.getInitParameter(ExtendsTag.PREFIX_ATTR_NAME)).thenReturn(prefix);
        when(servletContext.getInitParameter(ExtendsTag.SUFFIX_ATTR_NAME)).thenReturn(suffix);

        extendsTag.setName(name);
        assertThat(extendsTag.getRefinedName(), is(prefix + name + suffix));
    }
}