<%@ include file="/WEB-INF/jsp/common/taglibs.jsp" %>

<fmt:message var="title" key="login.page.title"/>
<s:layout-render name="/WEB-INF/jsp/common/layout.jsp" title="${title}">
    <s:layout-component name="body">
        <h1><fmt:message key="login.title"/></h1>

        <%-- Display Stripes errors if any --%>
        <s:errors/>

        <%-- The login form --%>
        <s:form beanclass="org.alx.stripestemplate.action.LoginActionBean">
            <table class="form">
                <tr>
                    <td class="form-label"><s:label for="user.email"/>:</td>
                    <td class="form-value"><s:text name="email"/></td>
                </tr>
                <tr>
                    <td class="form-label"><s:label for="user.password"/>:</td>
                    <td class="form-value"><s:password name="password"/></td>
                </tr>

                <tr>
                    <td colspan="2" class="form-submit"><s:submit name="login" class="login-button"/></td>
                </tr>

            </table>
            <s:hidden name="loginUrl"/>
        </s:form>

    </s:layout-component>
</s:layout-render>
