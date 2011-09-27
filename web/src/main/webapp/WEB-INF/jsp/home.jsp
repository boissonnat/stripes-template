<%@ include file="/WEB-INF/jsp/common/taglibs.jsp" %>

<fmt:message var="title" key="home.page.title"/>
<s:layout-render name="/WEB-INF/jsp/common/layout.jsp" title="${title}">
    <s:layout-component name="body">
        <h1><fmt:message key="home.title"/></h1>
        <p>
            <fmt:message key="home.content"/>
        </p>
    </s:layout-component>
</s:layout-render>
