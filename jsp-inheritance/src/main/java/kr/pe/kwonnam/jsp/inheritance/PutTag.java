package kr.pe.kwonnam.jsp.inheritance;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

import static kr.pe.kwonnam.jsp.inheritance.BlockTagUtils.*;

/**
 * 레이아웃의 블럭으로 대체되어 들어갈 템플릿을 지정하는 태그.
 *
 * Author: KwonNam Son(kwon37xi@gmail.com)
 */
public class PutTag extends SimpleTagSupport {
    public static final String PUT_DATA_PREFIX = PutTag.class.getCanonicalName() + ".";
    public static final String PUT_BLOCK_NAME_PARAMETER = "block";
    public static final String PUT_TYPE_PARAMETER = "type";

    private String name;

    private String type;

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void doTag() throws JspException, IOException {
        verifyParent();
        PutType putType = getPutType();
        String bodyResult  = getBodyResult(getJspBody());

        PageContext pageContext = (PageContext)getJspContext();

        pageContext.setAttribute(getBlockContentsAttributeName(name), bodyResult, PageContext.REQUEST_SCOPE);
        pageContext.setAttribute(getBlockTypeAttributeName(name), putType, PageContext.REQUEST_SCOPE);
    }

    private void verifyParent() {
        ExtendsTag extendsTag = (ExtendsTag) findAncestorWithClass(this, ExtendsTag.class);
        if (extendsTag == null) {
            throw new IllegalStateException("Put tags must be called in a extends tag.");
        }
    }

    public PutType getPutType() {
        PutType putType = null;

        if (type != null) {
            putType = PutType.valueOf(type.toUpperCase());
        }
        if (putType == null) {
            putType = PutType.APPEND;
        }

        return putType;
    }
}