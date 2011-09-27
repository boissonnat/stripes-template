<%@ include file="/WEB-INF/jsp/common/taglibs.jsp" %>

<s:layout-render name="/WEB-INF/jsp/common/layout.jsp" title="Home">
  <s:layout-component name="body">
    <p>Congratulations, you've set up a Stripes project!</p>
    <p>
      You are running Java version ${actionBean.javaVersion}
      on the ${actionBean.osName} operating system.
    </p>
  </s:layout-component>
</s:layout-render>
