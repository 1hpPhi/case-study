<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  request.setAttribute("pageTitle", "Stats");
  request.setAttribute("contentPage", "game/statContent.jsp");
%>
<jsp:include page="/WEB-INF/jsp/common/layout.jsp" />
