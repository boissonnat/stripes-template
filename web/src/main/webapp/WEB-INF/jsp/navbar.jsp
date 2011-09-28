<%@ include file="/WEB-INF/jsp/common/taglibs.jsp" %>

<ul>
    <li><s:link beanclass="org.alx.stripestemplate.action.HomeActionBean"><fmt:message key="application.navbar.home"/> </s:link></li>
    <li><s:link beanclass="org.alx.stripestemplate.action.LoginActionBean"><fmt:message key="application.navbar.login"/> </s:link></li>
    <li><s:link beanclass="org.alx.stripestemplate.action.AboutActionBean"><fmt:message key="application.navbar.about"/> </s:link></li>
</ul>