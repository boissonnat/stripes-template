<%@ attribute name="objects" required="true" type="java.util.Collection"%>
<%@ attribute name="contextPath" required="true" type="java.lang.String" %>

<%@ taglib prefix="s"	uri="http://stripes.sourceforge.net/stripes.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<fmt:setBundle basename="StripesResources"/>
<fmt:message var="actions" key="fakeobjecttag.name"/>
<fmt:message var="actions" key="fakeobjecttag.description"/>
<fmt:message var="actions" key="fakeobjecttag.actions"/>

<display:table name="${objects}" id="object" requestURI="${contextPath}">

    <display:column title="Name">
        ${object.name}
    </display:column>

    <display:column title="Description">
        ${object.description}
    </display:column>

    <display:column title="${actions}">
        <%-- View --%>
        <s:link beanclass="org.alx.stripestemplate.action.MyFakeObjectActionBean" event="view">
            <s:param name="id" value="${object.id}"/>
            <img src="${contextPath}/css/img/small/view-icon.png" alt="view">
        </s:link>

        <%-- Edit --%>
        <s:link beanclass="org.alx.stripestemplate.action.MyFakeObjectActionBean" event="edit">
            <s:param name="id" value="${object.id}"/>
            <img src="${contextPath}/css/img/small/edit-icon.png" alt="edit">
        </s:link>

        <%-- Delete --%>
        <s:link beanclass="org.alx.stripestemplate.action.MyFakeObjectActionBean" event="delete" onclick="return confirm('Delete ${object}?');">
            <s:param name="id" value="${object.id}"/>
            <img src="${contextPath}/css/img/small/delete-icon.png" alt="delete">
        </s:link>
    </display:column>


</display:table>