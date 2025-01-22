<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>Food Fight Store</h1>
<div class="row">
  <c:forEach var="item" items="${storeItems}">
    <div class="col-md-4 mb-4">
      <div class="card">
        <img src="${item.image}" class="card-img-top" alt="${item.name}">
        <div class="card-body">
          <h5 class="card-title">${item.name}</h5>
          <p class="card-text">Price: ${item.price} Coins</p>
          <button class="button" onclick="buyItem(${item.id})">Buy</button>
        </div>
      </div>
    </div>
  </c:forEach>
</div>
<script>
  function buyItem(itemId) {
    fetch('/api/store/buy', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ itemId: itemId })
    })
            .then(response => response.text())
            .then(message => alert(message))
            .catch(error => console.error('Error:', error));
  }
</script>
