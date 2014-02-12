<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>This contents will be ignored because of forward.</div>
<layout:extends name="secondLayout">
    <c:set var="testProperty" value="test property must be shown from the grand son" scope="request"/>

    <layout:put block="header">
        <h3>JSP Template Inheritance</h3>
    </layout:put>

    <div>This is useless html.</div>

    <layout:put block="body">
        <p>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis ultricies, neque id euismod rutrum, nisl risus commodo enim, sit amet malesuada orci nulla id elit. Donec metus justo, aliquet id est in, vulputate faucibus mauris. Proin ac lacinia neque. Integer scelerisque diam placerat tempor suscipit. Maecenas nec velit ut mauris venenatis porttitor. Ut facilisis diam in posuere hendrerit. Nam suscipit quis felis non gravida. In gravida tincidunt diam, sed pharetra metus placerat at. Donec pharetra felis quis odio bibendum, in dapibus lectus tincidunt. Aenean vitae scelerisque velit. Integer at interdum nisl, sed lacinia tellus. Fusce in dapibus arcu.
        </p>
        <p>
            In turpis nulla, viverra eget sagittis vitae, ultrices nec magna. Donec ornare ipsum justo, vitae convallis diam hendrerit id. Aenean tristique ipsum sit amet augue gravida scelerisque. Fusce ac tortor volutpat, venenatis turpis aliquam, rutrum massa. Donec id orci non turpis scelerisque pellentesque. Fusce facilisis sodales felis, eget interdum nisl. Pellentesque feugiat at mauris ut fringilla. Praesent molestie tellus in consectetur commodo.
        </p>
        <h4>Lorem Ipsum Korean jsp:include</h4>
    </layout:put>
    <layout:put block="footer" type="REPLACE">
        <hr />
        <p>This is footer.</p>
    </layout:put>
</layout:extends>