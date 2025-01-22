<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${pageTitle}</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pub/css/global.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">GameApp</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">

            <c:if test="${user == null}">
                <li class="nav-item"><a class="nav-link" href="/home">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="/login/login">Login</a></li>
                <li class="nav-item"><a class="nav-link" href="/login/signup">Sign Up</a></li>
            </c:if>

            <c:if test="${user != null}">
                <li class="nav-item"><a class="nav-link" href="/game/home">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="/game/inventory">Inventory</a></li>
                <li class="nav-item"><a class="nav-link" href="/game/store">Store</a></li>
                <li class="nav-item"><a class="nav-link" href="/login/logout">Logout</a></li>
            </c:if>
        </ul>

    </div>
</nav>

<div class="container mt-4">
    <jsp:include page="/WEB-INF/jsp/${contentPage}" />
</div>

<footer class="text-center py-3">
    <p>&copy; 2025 Food Fight Game. All rights reserved.</p>
</footer>

</body>
</html>
