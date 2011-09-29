<%@ attribute name="objects" required="true" type="java.util.Collection"%>
<%@ attribute name="contextPath" required="true" type="java.lang.String" %>

<%@ taglib prefix="s"	uri="http://stripes.sourceforge.net/stripes.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<display:table name="${objects}" id="object" requestURI="${contextPath}">

    <display:column title="Name">
            ${object.name}
    </display:column>

    <display:column title="Description">
        ${object.description}
    </display:column>

</display:table>