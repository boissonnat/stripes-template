<%-- Stripes TLD --%>
<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="sdyn" uri="http://stripes.sourceforge.net/stripes-dynattr.tld" %>

<%-- JSTL TLDs --%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"      %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"       %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>

<%-- This is so that you can conveniently refer to the context path with ${contextPath} --%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%-- Set the bundle ressource to use --%>
<%-- As we always include the taglibs, by putting this here, we avoir to set the fmr bundle in each page ! Stripes is wonderful :)--%>
<fmt:setBundle basename="${actionBean.class.name}"/>