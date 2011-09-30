<%@ include file="/WEB-INF/jsp/common/taglibs.jsp" %>

<fmt:setBundle basename="StripesResources"/>
<fmt:message var="title" key="exception.title"/>
<s:layout-render name="/WEB-INF/jsp/common/layout-error.jsp" title="${title}" >
    <s:layout-component name="body">
        <p class="error">
            <fmt:message key="exception.notfound.message"/>
        </p>
        <s:link href="/">
            <fmt:message key="exception.startOver"/>
        </s:link>
    </s:layout-component>
</s:layout-render>