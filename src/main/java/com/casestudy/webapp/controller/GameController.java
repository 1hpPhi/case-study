package com.casestudy.webapp.controller;

import com.casestudy.webapp.database.entity.*;
import com.casestudy.webapp.security.AuthenticatedUserService;
import com.casestudy.webapp.service.*;
import com.casestudy.webapp.service.impl.PlayerServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/game")
public class GameController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private PlayerServiceImpl playerServiceImpl;

    @Autowired
    private GameSaveService gameSaveService;

    @Autowired
    private GameService gameService;

    @Autowired
    private EnemyService enemyService;

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private MapService mapService;

    @Autowired
    private StatService statService;

    @Autowired
    private SkillService skillService;

    @Autowired
    private LootService lootService;

    @GetMapping("/home")
    public String showGameHome(Model model) {
        User loggedInUser = authenticatedUserService.loadCurrentUser();
        List<Player> players = playerService.findByUserId((long) loggedInUser.getId());
        model.addAttribute("players", players);
        return "game/home";
    }

    @GetMapping("/create")
    public String showCreateCharacterPage(Model model) {
        return "game/create";
    }

    @GetMapping("/gamePlay")
    public String showGamePage(Model model) {
        return "game/gamePlay";
    }

    @PostMapping("/createCharacter")
    public String createCharacter(
            @RequestParam("characterName") String characterName,
            @RequestParam("class") String characterClass,
            @RequestParam("difficulty") String difficulty,
            @RequestParam("health") int health,
            @RequestParam("stamina") int stamina,
            @RequestParam("level") int level) {

        User loggedInUser = authenticatedUserService.loadCurrentUser();
        Player newPlayer = new Player();
        newPlayer.setName(characterName);
        newPlayer.setPlayerClass(characterClass);
        newPlayer.setDifficulty(difficulty);
        newPlayer.setHealth(health);
        newPlayer.setStamina(stamina);
        newPlayer.setLevel(level);
        newPlayer.setUser(loggedInUser);

        playerService.save(newPlayer);
        return "redirect:/game/home";
    }

    @GetMapping("/select")
    public String selectPlayer(@RequestParam Long playerId, Model model) {
        Player player = playerService.getPlayerById(playerId);
        model.addAttribute("player", player);
        model.addAttribute("savedGameExists", gameSaveService.saveExistsForPlayer(playerId));
        return "game/selectGame";
    }


    @PostMapping("/overwriteGame")
    public String overwriteGame(@RequestParam Long playerId, Model model) {
        gameSaveService.deleteAllPlayerData(playerId);
        Player player = playerService.getPlayerById(playerId);
        gameSaveService.createNewGame(player);
        model.addAttribute("player", player);
        return "game/gamePlay";
    }

    @PostMapping("/continueGame")
    public String continueGame(@RequestParam Long playerId, RedirectAttributes redirectAttributes) {
        GameSave save = gameSaveService.getSaveForPlayer(playerId);

        if (save == null) {

            redirectAttributes.addFlashAttribute("error", "No saved game found.");
            return "redirect:/game/home";
        }
        redirectAttributes.addAttribute("playerId", playerId);
        return "redirect:/game/gameplay?playerId=" + playerId;
    }

    @PostMapping("/fight")
    public String fight(@RequestParam Long playerId, @RequestParam Long enemyId, @RequestParam int baseFruitDamage, Model model) {
        gameService.handleFight(playerId, enemyId, baseFruitDamage);
        Player player = playerService.getPlayerById(playerId);
        GameSave save = gameSaveService.getSaveForPlayer(playerId);
        Enemy enemy = enemyService.getEnemyById(enemyId);
        model.addAttribute("player", player);
        model.addAttribute("save", save);
        model.addAttribute("enemy", enemy);
        return "game/gamePlay";
    }

    @PostMapping("/flee")
    public String flee(@RequestParam Long playerId) {
        gameService.handleFlee(playerId);
        return "redirect:/gameplay";
    }

    @PostMapping("/startNewGame")
    public String startNewGame(@RequestParam("playerId") Long playerId, RedirectAttributes redirectAttributes) {
        if (!playerService.existsById(playerId)) {
            throw new IllegalArgumentException("Player ID does not exist: " + playerId);
        }

        Player player = playerService.getPlayerById(playerId);
        GameSave existingGameSave = gameSaveService.getGameSaveByPlayer(playerId);

        if (existingGameSave != null) {

            inventoryService.deleteByPlayerId(playerId);
            statService.deleteByPlayerId(playerId);
            lootService.deleteByPlayerId(playerId);
            skillService.deleteByPlayerId(playerId);
            enemyService.deleteByPlayerId(playerId);
            gameSaveService.deleteAllPlayerData(playerId);
        }

        gameSaveService.createNewGame(player);

        redirectAttributes.addAttribute("playerId", playerId);

        return "redirect:/game/gameplay?playerId=" + playerId;
    }


    @GetMapping("/gameplay")
    public String showGamePage(@RequestParam Long playerId, Model model) {
        Player player = playerService.getPlayerById(playerId);
        GameSave newSave = gameSaveService.getGameSaveByPlayer(playerId);
        if (newSave == null) {
            gameSaveService.createNewGame(player);
        }

        List<Inventory> inventory = inventoryService.getItemsByPlayerId(playerId);
        GameMap map = gameService.getMapForPlayer(playerId);
        Enemy enemy = gameService.getEnemyForEncounter(playerId);

        model.addAttribute("player", player);
        model.addAttribute("gameSave", newSave);
        model.addAttribute("inventory", inventory);
        model.addAttribute("map", map);
        model.addAttribute("enemy", enemy);

        return "game/gamePlay";
    }

    @PostMapping("/startBattle")
    public String startBattle(HttpSession session, Model model) {
        Player player = (Player) session.getAttribute("player");
        Enemy randomEnemy = gameService.startBattle(player);
        model.addAttribute("player", player);
        model.addAttribute("enemy", randomEnemy);
        return "game/battle";
    }

    @PostMapping("/delete")
    public String deletePlayer(@RequestParam Long playerId) {

        inventoryService.deleteByPlayerId(playerId);
        statService.deleteByPlayerId(playerId);
        lootService.deleteByPlayerId(playerId);
        skillService.deleteByPlayerId(playerId);
        enemyService.deleteByPlayerId(playerId);
        gameSaveService.deleteAllPlayerData(playerId);

        playerService.deletePlayerById(playerId);

        return "redirect:/game/home";
    }

    @PostMapping("/deleteSaveGame")
    public String deleteSaveGame(@RequestParam Long playerId, Model model) {
        Player player = playerService.getPlayerById(playerId);
        gameSaveService.deleteAllPlayerData(playerId);
        model.addAttribute("message", "Saved game deleted successfully.");
        model.addAttribute("player", player);
        model.addAttribute("savedGameExists", false);
        return "game/selectGameContent";
    }

    @GetMapping("/generateMap")
    public String generateMapForPlayer(@RequestParam Long playerId, Model model) {
        Player player = playerService.getCurrentPlayer(playerId);
        Map generatedMap = mapService.generateMapForPlayer(player);
        model.addAttribute("map", generatedMap);
        return "redirect:/game/map";
    }
}
