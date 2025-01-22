<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

<h2>Throw Result</h2>

<p>${message}</p>
