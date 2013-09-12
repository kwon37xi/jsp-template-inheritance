# JSP Template Inheritance

With these template inheritance tag library you can manage template layouts.

You don't need to use layout frameworks like [Sitemesh](http://wiki.sitemesh.org/display/sitemesh/Home) or
[Apache Tiles](http://tiles.apache.org/).

If you use freemarker, refer to [freemarker-template-inheritance](https://github.com/kwon37xi/freemarker-template-inheritance).

## Settings

* [Maven repository setting.](https://github.com/kwon37xi/m2repos)

### Gradle settings

```groovy
dependencies {
    compile 'kr.pe.kwonnam.jsp:jsp-inheritance:0.1'
}
```

### Maven settings

```xml
<dependency>
    <groupId>kr.pe.kwonnam.jsp</groupId>
    <artifactId>jsp-inheritance</artifactId>
    <version>0.1</version>
    <scope>compile</scope>
</dependency>
```

## Usage

### base.jsp : layout

```jsp
<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>JSP Template Inheritance</title>
    </head>

<h1>Head</h1>
<div>
    <layout:block name="header">
        header
    </layout:block>
</div>

<h1>Contents</h1>
<div>
    <p>
    <layout:block name="contents">
        <h2>Contents will be placed under this h2</h2>
    </layout:block>
    </p>
</div>

<div class="footer">
    <hr />
    <a href="https://github.com/kwon37xi/jsp-template-inheritance">jsp template inheritance example</a>
</div>
</html>
```

### view.jsp : contents

```jsp
<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>
<layout:extends name="layout.jsp">
    <layout:put name="header" type="REPLACE">
        <h2>This is an example about layout management with JSP Template Inheritance</h2>
    </layout:put>
    <layout:put name="contents">
        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin porta,
        augue ut ornare sagittis, diam libero facilisis augue, quis accumsan enim velit a mauris.
        Ut eleifend elit ante, sit amet suscipit leo lobortis eu. Quisque vitae lorem feugiat,
        lacinia nulla eu, interdum eros. Ut dignissim tincidunt nisl ac iaculis.
        Praesent consectetur arcu vitae tellus scelerisque venenatis.
        Morbi vel leo eros. In id libero ultricies, laoreet enim et, tempor magna.
        Vestibulum lorem velit, accumsan id purus at, lobortis fermentum diam.
        Aenean nec placerat elit. Aenean vel sem arcu.
    </layout:put>
</layout:extends>
```
### PutType
1. APPEND : The put contents will be appended after block's contents. default.
1. PREPEND : The put contents will be prepended before block's contents.
1. REPLACE : The put contents will replace block's contents. The block's contents will be removed.

### Example
`example` module is web application layout example. Run the module and browse <http://localhost:8080/index.jsp>.
Refer to `index.jsp`, `WEB-INF/layouts/base.jsp`, `WEB-INF/layouts/secondLayout.jsp`.

## Reference

1. [freemarker-template-inheritance](https://github.com/kwon37xi/freemarker-template-inheritance)