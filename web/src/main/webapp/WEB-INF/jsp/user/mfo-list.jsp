<%@ include file="/WEB-INF/jsp/common/taglibs.jsp" %>

<fmt:message var="title" key="mfolist.page.title"/>
<s:layout-render name="/WEB-INF/jsp/common/layout.jsp" title="${title}">
    <s:layout-component name="body">
        <h1><fmt:message key="mfolist.title"/></h1>
        <mt:fakeobject-list objects="${actionBean.allObjects}" contextPath="${contextPath}"/>
    </s:layout-component>
</s:layout-render>
