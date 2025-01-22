<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="${pageContext.request.contextPath}/pub/js/confirmStartNewGame.js"></script>


<div class="container">
  <h1>Welcome, ${player.name}!</h1>

  <c:choose>
    <c:when test="${savedGameExists}">
      <h2>What would you like to do?</h2>
      <div class="btn-group">
        <form action="${pageContext.request.contextPath}/game/startNewGame" method="post" onsubmit="return confirmStartNewGame();">
          <input type="hidden" name="playerId" value="${player.id}" />
          <button type="submit" class="btn btn-start-new">Start New Game</button>
        </form>

        <form action="${pageContext.request.contextPath}/game/continueGame" method="post" onsubmit="return confirmContinueGame();">
          <input type="hidden" name="playerId" value="${player.id}" />
          <button type="submit" class="btn btn-continue">Continue Game</button>
        </form>

        <form action="${pageContext.request.contextPath}/game/deleteSaveGame" method="post" onsubmit="return confirm('Are you sure you want to delete your saved game? This action cannot be undone.');">
          <input type="hidden" name="playerId" value="${player.id}" />
          <button type="submit" class="btn btn-delete">Delete Saved Game</button>
        </form>
      </div>
    </c:when>
    <c:otherwise>
      <h2>You don't have a saved game. Do you want to start a new game?</h2>
      <form action="${pageContext.request.contextPath}/game/startNewGame" method="post" onsubmit="return confirm('Are you sure you want to start a new game?');">
        <input type="hidden" name="playerId" value="${player.id}" />
        <button type="submit" class="btn btn-start-new">Start New Game</button>
      </form>
    </c:otherwise>
  </c:choose>

  <form action="${pageContext.request.contextPath}/game/home" method="get" onsubmit="return confirm('Are you sure you want to go back to the player selection screen?');">
    <button type="submit" class="btn btn-back">Back to Player Selection</button>
  </form>
</div>

<style>
  .container {
    max-width: 600px;
    margin: auto;
    text-align: center;
    padding: 20px;
  }

  .btn-group {
    margin-bottom: 20px;
  }

  .btn {
    display: inline-block;
    padding: 12px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    margin: 10px;
    width: 100%;
    max-width: 300px;
    transition: background-color 0.3s, transform 0.2s;
    height: 50px;
    text-align: center;
    font-size: 16px;
  }

  .btn-start-new {
    background-color: #007BFF;
    color: white;
  }

  .btn-start-new:hover {
    background-color: #0056b3;
    transform: scale(1.05);
  }

  .btn-continue {
    background-color: #4CAF50;
    color: white;
  }

  .btn-continue:hover {
    background-color: #357a38;
    transform: scale(1.05);
  }

  .btn-delete {
    background-color: #f44336;
    color: white;
  }

  .btn-delete:hover {
    background-color: #c62828;
    transform: scale(1.05);
  }

  .btn-back {
    background-color: #FF9800;
    color: white;
  }

  .btn-back:hover {
    background-color: #e65100;
    transform: scale(1.05);
  }
</style>
