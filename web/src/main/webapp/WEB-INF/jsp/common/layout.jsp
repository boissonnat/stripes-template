<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jsp/common/taglibs.jsp" %>

<fmt:setBundle basename="StripesResources"/>

<s:useActionBean beanclass="org.alx.stripestemplate.action.helper.UserHelper" var="usermgr"/>
<c:set var="user" value="${usermgr.user}"/>

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

    <%-- Display messages --%>
    <s:messages/>


    <%-- The Header --%>
    <div id="header">
        <h1><fmt:message key="application.header.title"/> <br/>
            <span class="slogan"><fmt:message key="application.header.slogan"/></span>
        </h1>
        <div id="user-info">
            <c:choose>
                <c:when test="${not empty usermgr.user}">

                    <fmt:message key="loggedAs"/>
                    <b><i>${usermgr.user.email} </i></b>
                    |
                    <s:link beanclass="org.alx.stripestemplate.action.LogoutActionBean">
                        <fmt:message key="application.logout"/>
                    </s:link>

                </c:when>
                <c:otherwise>

                    <s:link beanclass="org.alx.stripestemplate.action.LoginActionBean" class="login-link">
                        <fmt:message key="application.login"/>
                    </s:link>

                </c:otherwise>
            </c:choose>
        </div>
    </div>

    <%-- The NavBar --%>
    <div id="navbar">
        <ul>
            <li><s:link beanclass="org.alx.stripestemplate.action.HomeActionBean"><fmt:message key="application.navbar.home"/> </s:link></li>
            <li><s:link beanclass="org.alx.stripestemplate.action.LoginActionBean"><fmt:message key="application.navbar.login"/> </s:link></li>
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