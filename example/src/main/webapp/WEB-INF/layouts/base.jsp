<%@page contentType="text/html; utf-8" %>
<%@taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>JSP Template Inheritance in /WEB-INF</title>
        <style type="text/css">
            div.header {border: 2px solid deepskyblue; background-color: deepskyblue;}
            div.body {border: 2px solid burlywood; background-color: burlywood;}
            div.footer {border: 2px solid crimson; background-color: crimson;}
        </style>
    </head>
    <h1>Base Layout</h1>
    <div class="header">
        <layout:block name="header">
            <p>(PREPEND)<c:out value="${testProperty}" escapeXml="true"/></p>
            <hr />
        </layout:block>
    </div>
    <div class="body">
        <layout:block name="body">
            <div><strong>(APPEND) start body .......</strong></div>
        </layout:block>
    </div>
    <div class="footer">
        <div>(REPLACE)</div>
        <layout:block name="footer">
            <div>This line must be replaced by children's footer.</div>
        </layout:block>
    </div>
</html>