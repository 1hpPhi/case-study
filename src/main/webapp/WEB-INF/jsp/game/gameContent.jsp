<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>${welcomeMessage}</title>
  <link rel="stylesheet" href="/pub/css/global.css">
</head>
<body>
<div class="container mt-5">
  <h1 class="text-center">${welcomeMessage}</h1>
  <p>Your character: ${player.name}</p>

  <h3>Inventory:</h3>
  <p>${inventory}</p>

  <h3>Stats:</h3>
  <p>Level: ${player.level}</p>
  <p>Health: ${player.health}</p>
  <p>Stamina: ${player.stamina}</p>

  <div class="text-center mt-4">
    <a href="/game/inventory" class="btn btn-primary">View Inventory</a>
    <a href="/game/store" class="btn btn-secondary">Visit Store</a>
    <a href="/game/stats" class="btn btn-info">View Stats</a>
  </div>
</div>
</body>
</html>
