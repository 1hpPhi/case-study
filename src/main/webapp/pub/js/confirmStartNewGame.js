function confirmStartNewGame() {
    if (confirm('Starting a new game will overwrite your current save. Are you sure you want to proceed?')) {
        const form = document.querySelector('form');
        form.submit();
        return false;
    }
    return false;
}