<%@ include file="/WEB-INF/jsp/common/taglibs.jsp" %>

<fmt:message var="title" key="register.page.title"/>
<s:layout-render name="/WEB-INF/jsp/common/layout.jsp" title="${title}">
    <s:layout-component name="body">
        <h1><fmt:message key="register.title"/></h1>

        <%-- Display Stripes errors if any --%>
        <s:errors/>

        <%-- Register form --%>
        <s:form beanclass="org.alx.stripestemplate.action.RegisterActionBean">
            <table class="form">
                <tr>
                    <td class="form-label"><s:label for="user.email"/> :</td>
                    <td class="form-value"><s:text name="user.email"/></td>
                </tr>
                <tr>
                    <td class="form-label"><s:label for="user.password"/> :</td>
                    <td class="form-value"><s:password name="user.password"/></td>
                </tr>
                <tr>
                    <td class="form-label"><s:label for="user.confirmPassword"/> :</td>
                    <td class="form-value"><s:password name="confirmPassword"/></td>
                </tr>
                <tr>
                    <td class="form-submit" colspan="2">
                        <s:submit name="register"/>
                        <s:submit name="cancel"/>
                    </td>
                </tr>
            </table>
        </s:form>
    </s:layout-component>
</s:layout-render>
