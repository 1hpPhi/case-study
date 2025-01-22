<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="game-container">
  <div class="player-info">
    <h2>${player.name}</h2>
    <p>Level: ${player.level}</p>
    <p>Health: ${gameSave.currentHealth != null ? gameSave.currentHealth : 0} / 100</p>
    <p>Stamina: ${gameSave.currentStamina != null ? gameSave.currentStamina : 0} / 50</p>
  </div>

  <div class="nav-buttons">
    <button onclick="toggleOverlay('inventory-overlay')" class="nav-btn">Inventory</button>
    <button onclick="toggleOverlay('stats-overlay')" class="nav-btn">Stats</button>
    <button onclick="toggleOverlay('map-overlay')" class="nav-btn">Map</button>
  </div>

  <div class="enemy-info">
    <h3>${enemy.name != null ? enemy.name : 'No Enemy Found'}</h3>
    <p>Level: ${enemy.level != null ? enemy.level : 'N/A'}</p>
    <p>Health: ${enemy.health != null ? enemy.health : 0}</p>
  </div>
</div>

<div class="action-buttons">
  <form action="${pageContext.request.contextPath}/game/fight" method="post" style="display:inline;">
    <input type="hidden" name="playerId" value="${player.id}" />
    <input type="hidden" name="enemyId" value="${enemy.id}" />
    <input type="hidden" name="baseFruitDamage" value="20" />
    <button type="submit" class="btn-attack">Attack</button>
  </form>
  <form action="${pageContext.request.contextPath}/game/flee" method="post" style="display:inline;">
    <input type="hidden" name="playerId" value="${player.id}" />
    <button type="submit" class="btn-flee">Flee</button>
  </form>
</div>

<div id="inventory-overlay" class="overlay hidden">
  <h3>Inventory</h3>
  <ul>
    <c:forEach var="item" items="${inventory}">
      <li>${item.name} - ${item.description}</li>
    </c:forEach>
  </ul>
  <button onclick="toggleOverlay('inventory-overlay')" class="btn-close">Close</button>
</div>

<div id="stats-overlay" class="overlay hidden">
  <h3>Stats</h3>
  <p>Level: ${player.level}</p>
  <p>Health: ${gameSave.currentHealth != null ? gameSave.currentHealth : 0} / 100</p>
  <p>Stamina: ${gameSave.currentStamina != null ? gameSave.currentStamina : 0} / 50</p>
  <p>Total Enemies Defeated: ${stats.enemiesDefeated != null ? stats.enemiesDefeated : 0}</p>
  <button onclick="toggleOverlay('stats-overlay')" class="btn-close">Close</button>
</div>

<div id="map-overlay" class="overlay hidden">
  <h3>Map</h3>
  <p>Position: ${gameSave.currentPosition != null ? gameSave.currentPosition : 'Unknown'}</p>
  <p>The map is currently unavailable or under development.</p>
  <button onclick="toggleOverlay('map-overlay')" class="btn-close">Close</button>
</div>

<script>
  function toggleOverlay(id) {
    const overlay = document.getElementById(id);
    overlay.classList.toggle('hidden');
  }
</script>

<style>
  .game-container {
    display: grid;
    grid-template-areas:
      "player-info nav-buttons enemy-info";
    grid-template-columns: 1fr 2fr 1fr;
    gap: 20px;
    width: 100%;
    padding: 20px;
    background-color: #fdf2e9;
    border-radius: 10px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
  }

  .player-info, .enemy-info {
    text-align: center;
  }

  .player-info h2, .enemy-info h3 {
    margin: 0;
  }

  .player-info p:first-of-type, .enemy-info p:first-of-type {
    margin-top: 5px;
  }

  .nav-buttons {
    grid-area: nav-buttons;
    text-align: center;
    display: flex;
    justify-content: center;
    gap: 10px;
  }

  .action-buttons {
    display: flex;
    justify-content: center;
    align-items: center;
    gap: 20px;
    margin-top: 20px;
  }

  .overlay {
    position: fixed;
    top: 20%;
    left: 50%;
    transform: translate(-50%, 0);
    background: #fff5e6;
    padding: 20px;
    border: 2px solid #ff8c00;
    z-index: 1000;
    display: block;
    border-radius: 10px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    color: #333;
  }

  .overlay.hidden {
    display: none;
  }

  .overlay ul {
    list-style-type: none;
    padding-left: 0;
  }

  .overlay ul li {
    margin: 10px 0;
    font-size: 1.1em;
    color: #333;
  }

  .overlay h3 {
    font-size: 1.8em;
    margin-bottom: 20px;
    color: #ff8c00;
    text-shadow: 1px 1px 4px rgba(255, 140, 0, 0.6);
  }

  .btn-close {
    margin-top: 20px;
    background-color: #ff8c00;
    color: white;
    border-radius: 5px;
    padding: 10px 20px;
    border: none;
    cursor: pointer;
    transition: background-color 0.3s ease, transform 0.3s ease;
  }

  .btn-close:hover {
    background-color: #ff6347;
    transform: scale(1.1);
  }

  .nav-btn, .btn-attack, .btn-flee{
    margin: 10px;
    padding: 10px 20px;
    background-color: #ff8c00;
    border-color: #ff8c00;
    color: white;
    box-shadow: 0 4px 6px rgba(255, 140, 0, 0.5);
    border-radius: 5px;
    cursor: pointer;
    font-size: 16px;
    height: 50px;
    display: flex;
    align-items: center;
    justify-content: center;
  }


  .nav-btn:hover, .btn-attack:hover, .btn-flee:hover {
    background-color: #ff6347;
    transform: scale(1.1);
  }

  .player-info p, .enemy-info p {
    padding-bottom: 5px;
  }
</style>
