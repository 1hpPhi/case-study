<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${player.name}'s Profile</title>
</head>
<body>
<h1>${player.name}'s Profile</h1>
<p>Level: ${player.level}</p>
<p>Health: ${player.health}</p>
<p>Stamina: ${player.stamina}</p>

<form action="/profile/update" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="${player.name}">
    <button type="submit">Update Profile</button>
</form>

<form action="/profile/level-up" method="post">
    <button type="submit">Level Up</button>
</form>
</body>
</html>
