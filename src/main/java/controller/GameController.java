package controller;

import model.personnage.hero.Hero;
import model.personnage.monster.Monstre;
import services.GameService;
import vue.GameWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController {

    private final GameService gameService;
    private final GameWindow gameWindow;
    private Hero hero;
    private Monstre monster;

    public GameController() {
        gameService = new GameService();
        gameWindow = new GameWindow();
        setupGame();
        setupListeners();
    }

    private void setupGame() {
        hero = new Hero("Arthas", 12, 14);
        monster = new Monstre("Orc", 10, 8);

        gameWindow.updateHeroPanel(hero.toString());
        gameWindow.updateMonsterPanel(monster.toString());
        gameWindow.appendLog("Le jeu commence !");
    }

    private void setupListeners() {
        gameWindow.setAttackButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleCombat();
            }
        });
    }

    private void handleCombat() {
        gameWindow.appendLog("Attaque héroïque : ");
        String result = gameService.fight(hero, monster);
        gameWindow.appendLog(result);

        gameWindow.updateHeroPanel(hero.toString());
        gameWindow.updateMonsterPanel(monster.toString());

        if (!monster.isAlive()) {
            gameWindow.appendLog("Le monstre est mort !");
            gameWindow.appendLog("Victoire !");
        }
    }

    public void start() {
        gameWindow.setVisible(true);
    }
}
