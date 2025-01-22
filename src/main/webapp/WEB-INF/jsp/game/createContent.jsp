<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Create Character</title>
  <script src="${pageContext.request.contextPath}/pub/js/characterCreation.js" defer></script>
</head>
<body>
<h1>Create Your Character</h1>
<form action="/game/createCharacter" method="post">
  <label for="characterName">Character Name:</label>
  <input type="text" id="characterName" name="characterName" placeholder="Character Name" required /><br/>

  <label for="classSelect">Class:</label>
  <select id="classSelect" name="class">
    <option value="">--Select a Class--</option>
    <option value="Warrior">Warrior</option>
    <option value="Mage">Mage</option>
    <option value="Rogue">Rogue</option>
  </select><br/>

  <label for="difficultySelect">Difficulty:</label>
  <select id="difficultySelect" name="difficulty">
    <option value="">--Select Difficulty--</option>
    <option value="Easy">Easy</option>
    <option value="Normal">Normal</option>
    <option value="Hard">Hard</option>
  </select><br/>

  <label for="healthBox">Health:</label>
  <input type="text" id="healthBox" name="health" readonly /><br/>

  <label for="staminaBox">Stamina:</label>
  <input type="text" id="staminaBox" name="stamina" readonly /><br/>

  <label for="levelBox">Level:</label>
  <input type="text" id="levelBox" name="level" readonly /><br/>

  <button type="submit" class="btn-create">Create Character</button>
</form>
</body>
</html>
