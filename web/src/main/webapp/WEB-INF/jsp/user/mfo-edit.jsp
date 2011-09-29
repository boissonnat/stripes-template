<%@ include file="/WEB-INF/jsp/common/taglibs.jsp" %>

<fmt:message var="title" key="mfoedit.page.title"/>
<s:layout-render name="/WEB-INF/jsp/common/layout.jsp" title="${title}">
    <s:layout-component name="body">
        <h1><fmt:message key="mfoedit.title"/></h1>

        <s:form beanclass="org.alx.stripestemplate.action.MyFakeObjectActionBean">
            <s:hidden name="myFakeObject.id"/>
            <table class="form">
                <tr>
                    <td class="view-label"><s:label for="myFakeObject.name"/> : </td>
                    <td class="view-value"><s:text name="myFakeObject.name"/></td>
                    <td><s:errors field="myFakeObject.name"/></td>
                </tr>
                <tr>
                    <td class="view-label"><s:label for="myFakeObject.description"/> : </td>
                    <td class="view-value"><s:text name="myFakeObject.description"/></td>
                    <td><s:errors field="myFakeObject.description"/></td>
                </tr>
                <tr>
                    <td colspan="2" class="form-submit">
                        <s:submit name="update"/>
                        <s:submit name="cancel"/>
                    </td>
                </tr>
            </table>
        </s:form>

    </s:layout-component>
</s:layout-render>
