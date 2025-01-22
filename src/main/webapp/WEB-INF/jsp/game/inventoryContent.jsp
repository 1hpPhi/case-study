<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h2>Your Inventory</h2>

<c:forEach var="item" items="${inventory}">
  <div>
    <h3>${item.food.name}</h3>
    <p>Quantity: ${item.quantity}</p>
    <p>Equipped: ${item.equipped ? "Yes" : "No"}</p>

    <form action="/inventory/update" method="post">
      <input type="hidden" name="inventoryId" value="${item.id}">
      <label for="quantity">New Quantity:</label>
      <input type="number" name="quantity" min="0" value="${item.quantity}">
      <button type="submit">Update Quantity</button>
    </form>

    <!-- Equip/Unequip -->
    <form action="/inventory/equip" method="post">
      <input type="hidden" name="inventoryId" value="${item.id}">
      <button type="submit" name="equip" value="${!item.equipped}">
          ${item.equipped ? "Unequip" : "Equip"}
      </button>
    </form>

    <!-- Remove Item -->
    <form action="/inventory/remove" method="post">
      <input type="hidden" name="inventoryId" value="${item.id}">
      <button type="submit">Remove</button>
    </form>
  </div>
</c:forEach>

<h3>Add an Item</h3>
<form action="/inventory/add" method="post">
  <label for="food">Food:</label>
  <select name="foodId">
    <c:forEach var="food" items="${foods}">
      <option value="${food.id}">${food.name}</option>
    </c:forEach>
  </select>
  <label for="quantity">Quantity:</label>
  <input type="number" name="quantity" min="1" value="1">
  <button type="submit">Add to Inventory</button>
</form>
