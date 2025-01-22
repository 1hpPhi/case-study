function confirmContinueGame() {
    if (confirm('Are you sure you want to continue your saved game?')) {
        const playerId = document.querySelector('input[name="playerId"]').value;
        window.location.href = `/game/gameplay?playerId=${encodeURIComponent(playerId)}`;
        return false;
    }
    return false;
}