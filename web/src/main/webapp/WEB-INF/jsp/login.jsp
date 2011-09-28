<%@ include file="/WEB-INF/jsp/common/taglibs.jsp" %>

<fmt:message var="title" key="login.page.title"/>
<s:layout-render name="/WEB-INF/jsp/common/layout.jsp" title="${title}">
    <s:layout-component name="body">
        <h1><fmt:message key="login.title"/></h1>

        <%-- Display Stripes errors if any --%>
        <s:errors/>

        <%-- The login form --%>
        <s:form beanclass="org.alx.stripestemplate.action.LoginActionBean">
            <table>
                <tr>
                    <td><s:label for="user.email"/>:</td>
                    <td><s:text name="email"/></td>
                </tr>
                <tr>
                    <td><s:label for="user.password"/>:</td>
                    <td><s:password name="password"/></td>
                </tr>

                <tr>
                    <td></td>
                    <td><s:submit name="login"/></td>
                </tr>

            </table>
            <s:hidden name="loginUrl"/>
        </s:form>

    </s:layout-component>
</s:layout-render>
