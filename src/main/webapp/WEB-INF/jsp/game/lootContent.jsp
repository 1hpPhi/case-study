<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Loot for Map ID: ${mapId}</h2>
<ul>
  <c:forEach var="item" items="${loot}">
    <li>
        ${item.food.name} (Quantity: ${item.quantity})
      <a href="${pageContext.request.contextPath}/map/${mapId}/loot/${item.id}/take/${playerId}">Take</a>
    </li>
  </c:forEach>
</ul>
<div class="mt-4">
  <a href="${pageContext.request.contextPath}/game/game" class="btn btn-secondary">Back to Game</a>
</div>
