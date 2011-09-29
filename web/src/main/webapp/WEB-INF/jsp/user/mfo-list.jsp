<%@ include file="/WEB-INF/jsp/common/taglibs.jsp" %>

<fmt:message var="title" key="mfolist.page.title"/>
<s:layout-render name="/WEB-INF/jsp/common/layout.jsp" title="${title}">
    <s:layout-component name="body">
        <h1>
            <fmt:message key="mfolist.title"/>
            <span class="actions">
                <ul class="link-as-button">
                    <li>
                        <s:link class="link-as-button" beanclass="org.alx.stripestemplate.action.MyFakeObjectActionBean" event="add">
                            <img src="${contextPath}/css/img/medium/add-icon.png" alt="add">
                        </s:link>
                    </li>
                </ul>
            </span>
        </h1>


        <%-- Use tags to display object list --%>
        <mt:fakeobject-list objects="${actionBean.allObjects}" contextPath="${contextPath}"/>


    </s:layout-component>
</s:layout-render>
