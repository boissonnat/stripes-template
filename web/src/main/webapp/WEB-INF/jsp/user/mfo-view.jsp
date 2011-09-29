<%@ include file="/WEB-INF/jsp/common/taglibs.jsp" %>

<fmt:message var="title" key="mfoview.page.title"/>
<s:layout-render name="/WEB-INF/jsp/common/layout.jsp" title="${title}">
    <s:layout-component name="body">
        <h1>
            <fmt:message key="mfoview.title">
                <fmt:param value="${actionBean.myFakeObject.name}"/>
            </fmt:message>
            <span class="actions">
                <ul class="link-as-button">
                    <li>
                        <s:link class="link-as-button" beanclass="org.alx.stripestemplate.action.MyFakeObjectActionBean" event="list">
                            <img src="${contextPath}/css/img/medium/back-icon.png" alt="back">
                        </s:link>
                    </li>
                    <li>
                        <s:link class="link-as-button" beanclass="org.alx.stripestemplate.action.MyFakeObjectActionBean" event="edit">
                            <img src="${contextPath}/css/img/medium/edit-icon.png" alt="edit">
                        </s:link>
                    </li>
                    <li>
                        <s:link class="link-as-button" beanclass="org.alx.stripestemplate.action.MyFakeObjectActionBean" event="delete">
                            <img src="${contextPath}/css/img/medium/delete-icon.png" alt="delete">
                        </s:link>
                    </li>
                </ul>
            </span>
        </h1>

        <table class="view">
            <tr>
                <td class="view-label"><s:label for="myFakeObject.name"/> : </td>
                <td class="view-value">${actionBean.myFakeObject.name}</td>
            </tr>
            <tr>
                <td class="view-label"><s:label for="myFakeObject.description"/> : </td>
                <td class="view-value">${actionBean.myFakeObject.description}</td>
            </tr>
        </table>

    </s:layout-component>
</s:layout-render>
