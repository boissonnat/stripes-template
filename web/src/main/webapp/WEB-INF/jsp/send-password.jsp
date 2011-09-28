<%@ include file="/WEB-INF/jsp/common/taglibs.jsp" %>

<fmt:message var="title" key="sendpassword.page.title"/>
<s:layout-render name="/WEB-INF/jsp/common/layout.jsp" title="${title}">
    <s:layout-component name="body">
        <h1><fmt:message key="sendpassword.title"/></h1>

        <%-- Form --%>
        <s:form beanclass="org.alx.stripestemplate.action.ForgetPasswordActionBean">
            <table class="form">
                <tr>
                    <td class="form-label"><s:label for="user.email"/> :</td>
                    <td class="form-value"><s:text name="email" size="50"/></td>
                    <td><s:errors field="email"/></td>
                </tr>
                <tr>
                    <td class="form-submit" colspan="2">
                        <s:submit name="send"/>
                        <s:submit name="cancel"/>
                    </td>
                </tr>
            </table>
        </s:form>

    </s:layout-component>
</s:layout-render>
