<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
    <h1>Welcome to the Game</h1>

    <c:choose>
        <c:when test="${not empty players}">
            <h2>Your Characters</h2>
            <div class="character-list">
                <c:forEach var="player" items="${players}">
                    <div class="character-card">
                        <div class="character-header">
                            <span class="character-name">${player.name}</span>
                        </div>
                        <div class="character-info">
                            <p>Class: ${player.playerClass}</p>
                            <p>Level: ${player.level}</p>
                            <p>HP: ${player.health}</p>
                            <p>Stamina: ${player.stamina}</p>
                        </div>
                        <div class="character-actions">
                            <form action="/game/select" method="get" class="inline-form">
                                <input type="hidden" name="playerId" value="${player.id}" />
                                <button type="submit" class="btn-play">Play</button>
                            </form>
                            <form action="/game/delete" method="post" class="inline-form">
                                <input type="hidden" name="playerId" value="${player.id}" />
                                <button type="submit" class="btn-delete" onsubmit="return confirm('Are you sure you want to delete this character and its saved game? This action cannot be undone.');">Delete</button>
                            </form>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:when>

        <c:otherwise>
            <p class="no-characters">You don't have any characters yet. Create your first one!</p>
        </c:otherwise>
    </c:choose>

    <c:if test="${players.size() < 3}">
        <h2>Create a New Character</h2>
        <form action="/game/create" method="get">
            <button type="submit" class="btn-create">Create Character</button>
        </form>
    </c:if>
</div>

<style>
    .container {
        max-width: 800px;
        margin: auto;
    }

    .character-list {
        display: flex;
        flex-wrap: wrap;
        gap: 20px;
    }

    .character-card {
        width: 300px;
        border: 1px solid #ddd;
        border-radius: 8px;
        padding: 15px;
        background-color: white;
        display: flex;
        flex-direction: column;
        height: auto;
    }

    .character-header {
        display: flex;
        align-items: center;
        gap: 10px;
        margin-bottom: 15px;
        font-weight: bold;
        font-size: 1.2em;
    }

    .character-info {
        margin-top: 5px;
        font-size: 1em;
        color: #333;
    }

    .character-info p {
        margin: 2px 0;
        padding: 0;
    }

    .character-actions {
        display: flex;
        justify-content: flex-end;
        gap: 10px;
        margin-top: 15px;
    }

    .character-actions .btn-play,
    .character-actions .btn-delete {
        padding: 8px 15px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }

    .btn-play {
        background-color: #4CAF50;
        color: white;
    }

    .btn-play:hover {
        background-color: #45a049;
    }

    .btn-delete {
        background-color: #f44336;
        color: white;
    }

    .btn-delete:hover {
        background-color: #e53935;
    }

    .btn-create {
        background-color: #007BFF;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    .btn-create:hover {
        background-color: #0056b3;
    }

    .no-characters {
        font-size: 1.2em;
        color: #555;
        text-align: center;
    }
</style>
