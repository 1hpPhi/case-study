<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setAttribute("pageTitle", "Home page");
    request.setAttribute("contentPage", "game/homeContent.jsp");
%>
<jsp:include page="/WEB-INF/jsp/common/layout.jsp" />
