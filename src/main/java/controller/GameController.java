package controller;

import model.ZoneDeJeu;
import model.personnage.hero.Hero;
import model.personnage.monster.Monstre;
import services.GameService;
import vue.GameWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameController implements KeyListener {

    private final GameService gameService;
    private final GameWindow gameWindow;
    private final ZoneDeJeu zoneDeJeu;
    private final Hero hero;

    public GameController(ZoneDeJeu zoneDeJeu, Hero hero) {
        this.gameService = new GameService();
        this.zoneDeJeu = zoneDeJeu;
        this.hero = hero;
        this.gameWindow = new GameWindow(15, zoneDeJeu.getGrid()); // Passer la grille au GameWindow

        setupGame();
        setupListeners();
    }

    private void setupGame() {
        zoneDeJeu.placeCharacter(hero, 7, 7);
        gameWindow.updateHeroPanel(hero.toString());
        gameWindow.appendLog("Le jeu commence !");
        gameWindow.refreshGrid(); // Rafraîchir l'affichage de la grille
    }

    private void setupListeners() {
        gameWindow.setAttackButtonListener(e -> handleCombat());
        gameWindow.setKeyListener(this);
    }

    private void handleCombat() {
        Monstre adjacentMonster = zoneDeJeu.getAdjacentMonster(hero);
        if (adjacentMonster == null) {
            gameWindow.appendLog("Aucun monstre à proximité pour attaquer.");
            return;
        }

        gameWindow.appendLog("Attaque héroïque : ");
        String result = gameService.fight(hero, adjacentMonster);
        gameWindow.appendLog(result);

        gameWindow.updateHeroPanel(hero.toString());
        gameWindow.refreshGrid(); // Mettre à jour la grille

        if (!adjacentMonster.isAlive()) {
            gameWindow.appendLog(adjacentMonster.getName() + " est mort !");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int x = hero.getX();
        int y = hero.getY();

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> zoneDeJeu.moveCharacter(hero, x, y - 1);
            case KeyEvent.VK_DOWN -> zoneDeJeu.moveCharacter(hero, x, y + 1);
            case KeyEvent.VK_LEFT -> zoneDeJeu.moveCharacter(hero, x - 1, y);
            case KeyEvent.VK_RIGHT -> zoneDeJeu.moveCharacter(hero, x + 1, y);
        }

        gameWindow.refreshGrid(); // Mettre à jour la grille après déplacement
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    public void start() {
        gameWindow.setVisible(true);
    }
}
