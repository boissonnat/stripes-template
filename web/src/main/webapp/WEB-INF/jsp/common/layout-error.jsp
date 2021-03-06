<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jsp/common/taglibs.jsp" %>

<fmt:setBundle basename="StripesResources"/>


<s:layout-definition>

    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>${title}</title>
        <link rel="icon" type="image/png" href="${contextPath}/css/img/app-icon.png" />
        <link rel="shortcut icon" type="image/x-icon" href="${contextPath}/css/img/app-icon.png" />
        <link rel="stylesheet" type="text/css" href="${contextPath}/css/reset.css">
        <link rel="stylesheet" type="text/css" href="${contextPath}/css/style.css">

        <s:layout-component name="head">
        </s:layout-component>

    </head>
    <body>

    <%-- The Header --%>
    <div id="header">
        <h1><fmt:message key="application.header.title"/> <br/>
            <span class="slogan"><fmt:message key="application.header.slogan"/></span>
        </h1>
    </div>

    <%-- The NavBar --%>
    <div id="navbar">
        <ul>
            <%-- Links for all user --%>
            <li><s:link beanclass="org.alx.stripestemplate.action.HomeActionBean"><fmt:message key="application.navbar.home"/></s:link></li>
            <li><s:link beanclass="org.alx.stripestemplate.action.AboutActionBean"><fmt:message key="application.navbar.about"/> </s:link></li>
        </ul>

    </div>

    <%-- The main content --%>
    <div id="main">
        <s:layout-component name="body">
        </s:layout-component>
    </div>

    <%-- The footer --%>
    <div id="footer">This is your footer !</div>

    </body>
    </html>

</s:layout-definition>