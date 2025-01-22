<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Sign Up</title>
</head>
<body style="font-family: 'Comic Sans MS', cursive, sans-serif; background-color: #fdf2e9; color: #333; text-align: center; padding-top: 120px; position: relative; overflow-x: hidden; overflow-y: auto; padding-bottom: 50px;">
<div style="max-width: 800px; margin: 0 auto; padding: 40px; text-align: center; background-color: #fdf2e9; border-radius: 10px; box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);">
  <h1 style="color: #ff8c00; font-size: 4em; margin-bottom: 40px; text-shadow: 3px 3px 10px rgba(255, 140, 0, 0.8);">Sign Up</h1>
  <form action="/login/signupSubmit" method="post">
    <div style="margin-bottom: 20px;">
      <label for="email" style="display: block; font-size: 1.2em; margin-bottom: 10px;">Email:</label>
      <input type="email" id="email" name="username" placeholder="Email" required
             style="width: 80%; padding: 10px; font-size: 1em; border: 1px solid #ccc; border-radius: 5px;">
    </div>
    <div style="margin-bottom: 20px;">
      <label for="password" style="display: block; font-size: 1.2em; margin-bottom: 10px;">Password:</label>
      <input type="password" id="password" name="password" placeholder="Password" required
             style="width: 80%; padding: 10px; font-size: 1em; border: 1px solid #ccc; border-radius: 5px;">
    </div>
    <div style="margin-bottom: 20px;">
      <label for="confirmPassword" style="display: block; font-size: 1.2em; margin-bottom: 10px;">Confirm Password:</label>
      <input type="password" id="confirmPassword" name="confirmPassword" placeholder="Confirm Password" required
             style="width: 80%; padding: 10px; font-size: 1em; border: 1px solid #ccc; border-radius: 5px;">
    </div>
    <div>
      <button type="submit" class="btn btn-primary"
              style="font-size: 1.5em; padding: 20px 40px; margin: 15px; border-radius: 10px; cursor: pointer; transition: all 0.3s ease-in-out; color: white; background-color: #5cb85c; border: none; box-shadow: 0px 4px 6px rgba(92, 184, 92, 0.5);">
        Sign Up
      </button>
    </div>
    <p style="margin-top: 20px;">Already have an account?
      <a href="/login/login" style="color: #1976d2; text-decoration: none; font-weight: bold;">Log in here</a>.
    </p>
  </form>
</div>
<footer style="font-size: 1em; background-color: #ff8c00; color: #333; padding: 20px 0; text-shadow: 2px 2px 5px rgba(255, 140, 0, 0.7); position: fixed; bottom: 0; left: 0; width: 100%; text-align: center;">
  <p style="font-size: 0.9em; margin: 0;">&copy; 2025 Food Fight Game. All rights reserved.</p>
</footer>
</body>
</html>

