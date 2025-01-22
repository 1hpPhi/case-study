# Food Fight Game

Welcome to the Food Fight Game!
This browser-based game is a roguelike adventure where players battle enemies using food items, explore a procedurally generated map, and manage resources to progress as far as possible. 
With a rich gameplay experience that includes loot collection, skill upgrades, and endless progression, this game promises to be a fun and challenging journey.

# Table of Contents

1. [Features](#features)


2. [Technologies Used](#technologies-used)


3. [Setup Instructions](#setup-instructions)


4. [Game Overview](#game-overview)


5. [API Usage](#api-usage)


6. [Photos](#photo)


# Features
Core Gameplay:

    Battle System:
        Fight enemies using food as weapons.
        Upgrade food damage with skill buffs.
        Options to attack or flee based on strategy.

    Player Progression:
        Roguelike mechanics with infinite progression until player defeat.
        Player stats and skills evolve as the game progresses.

    Loot Collection:
        Discover and collect loot on the map.
        Add items to inventory for later use.

    Dynamic Maps:
        Maps feature fights, rest points, and treasure/loot areas.
        Procedurally generated for unique playthroughs.

Additional Features:

    Player Profile:
        Create and manage player profiles.
        Save and load game progress for continued adventures.
    Inventory System:
        Equip, upgrade, and manage food items.
    Store Integration:
        Purchase new food or buffs from the store to enhance abilities.
    Skill Upgrades:
        Unlock and level up skills to improve combat effectiveness.


# Technologies Used

    Java: Backend logic and game mechanics.
    Spring Boot: Framework for REST APIs and server-side logic.
    JSP & HTML5: Frontend structure for dynamic pages.
    CSS3: Styling for responsive and immersive visuals.
    MySQL: Database for storing user profiles, inventory, game saves, stats, etc.
    JavaScript: Interactivity on the frontend.


# Setup Instructions

1. Clone the repository:

    
    git clone <repository-url>

2. Navigate to the project directory:

    
    cd <repository-directory>

3. Configure the database:

    
    Update application.properties with your MySQL database details:

    spring.datasource.url=jdbc:mysql://localhost:3306/<your-database>
    spring.datasource.username=<your-username>
    spring.datasource.password=<your-password>

4. Run the application:


    mvn spring-boot:run


5. Access the game:

    
    Open your browser and navigate to http://localhost:8080

# Game Overview
Key Pages:

    Gameplay Screen:
        Central hub for fighting enemies and making decisions (e.g., attack, flee).
        Displays health, stamina, and stats for both the player and enemies.

    Map:
        Explore locations, encounter enemies, and find treasure.

    Inventory:
        Manage collected food items and equip weapons.

    Store:
        Purchase upgrades, new food items, and buffs.

    Profile:
        Manage player data and view progress.

Player Stats:

    Health & Stamina:
        Monitor your health and stamina levels during fights.
    Skills:
        Buffs to improve food damage and other abilities.

Enemy Encounters:

    Level Scaling:
        Enemies are scaled to the player's level for balanced combat.
    Food-Based Combat:
        Unique mechanics for food-based damage and buffs.

# API Usage

The project includes APIs for core game mechanics. Example:

Save and Load Game Progress:
    

    POST /game/save
    {
    "playerId": 1,
    "gameSave": { ... }
    }

    GET /game/load/{playerId}

Retrieve Player Stats:


    GET /player/stats/{playerId}


# Photo

![EER Diagram](https://github.com/1hpPhi/case-study/blob/main/src/main/webapp/pub/images/EERDiagram.PNG?raw=true)

![homePage](https://github.com/1hpPhi/case-study/blob/main/src/main/webapp/pub/images/gameHome.PNG?raw=true)

![gameHome](https://github.com/1hpPhi/case-study/blob/main/src/main/webapp/pub/images/gamePlay.PNG?raw=true)

![gamePlay](https://github.com/1hpPhi/case-study/blob/main/src/main/webapp/pub/images/homePage.PNG?raw=true)


Enjoy battling your way through the Food Fight Game!

Link to [GitHub Repo](https://github.com/1hpPhi/case-study)