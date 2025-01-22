<%@ c:taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%
  request.setAttribute("pageTitle", "Store");
  request.setAttribute("contentPage", "game/storeContent.jsp");
%>
<jsp:include page="/WEB-INF/jsp/common/layout.jsp" />