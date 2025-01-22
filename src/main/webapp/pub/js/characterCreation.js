document.addEventListener("DOMContentLoaded", () => {
    const classSelect = document.getElementById("classSelect");
    const difficultySelect = document.getElementById("difficultySelect");
    const healthBox = document.getElementById("healthBox");
    const staminaBox = document.getElementById("staminaBox");
    const levelBox = document.getElementById("levelBox");

    const classes = {
        "Warrior": { health: 100, stamina: 50 },
        "Mage": { health: 60, stamina: 100 },
        "Rogue": { health: 80, stamina: 70 }
    };

    const difficulties = {
        "Easy": 1,
        "Normal": 2,
        "Hard": 3
    };

    function updateStats() {
        const selectedClass = classes[classSelect.value] || { health: 0, stamina: 0 };
        const selectedDifficulty = difficulties[difficultySelect.value] || 1;

        healthBox.value = selectedClass.health;
        staminaBox.value = selectedClass.stamina;
        levelBox.value = selectedDifficulty;
    }

    classSelect.addEventListener("change", updateStats);
    difficultySelect.addEventListener("change", updateStats);

    updateStats();
});
