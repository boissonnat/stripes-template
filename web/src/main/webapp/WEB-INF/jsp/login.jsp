<%@ include file="/WEB-INF/jsp/common/taglibs.jsp" %>

<fmt:message var="title" key="login.page.title"/>
<s:layout-render name="/WEB-INF/jsp/common/layout.jsp" title="${title}">
    <s:layout-component name="body">
        <h1><fmt:message key="login.title"/></h1>

        <%-- The login form --%>
        <s:form beanclass="org.alx.stripestemplate.action.LoginActionBean">
            <table class="form">
                <tr>
                    <td class="form-label"><s:label for="user.email"/> :</td>
                    <td class="form-value"><s:text name="email"/></td>
                    <td><s:errors field="email"/></td>
                </tr>
                <tr>
                    <td class="form-label"><s:label for="user.password"/> :</td>
                    <td class="form-value"><s:password name="password"/></td>
                    <td><s:errors field="password"/></td>
                </tr>

                <tr>
                    <td colspan="2" class="form-submit"><s:submit name="login"/></td>
                </tr>

            </table>
            <s:hidden name="loginUrl"/>
        </s:form>

        <%-- Register or forgot password --%>
        <div class="border-top">
            <h2><fmt:message key="login.links.title"/> </h2>
            <ul class="arrow">
                <li class="arrow"><s:link beanclass="org.alx.stripestemplate.action.RegisterActionBean"><fmt:message key="login.link.register"/> </s:link></li>
                <li class="arrow"><s:link beanclass="org.alx.stripestemplate.action.ForgetPasswordActionBean"><fmt:message key="login.link.passwordforget"/> </s:link></li>
            </ul>
        </div>

    </s:layout-component>
</s:layout-render>
