<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  request.setAttribute("pageTitle", "Inventory");
  request.setAttribute("contentPage", "game/inventoryContent.jsp");
%>
<jsp:include page="/WEB-INF/jsp/common/layout.jsp" />
