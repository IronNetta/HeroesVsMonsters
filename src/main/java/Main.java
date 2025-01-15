import controller.GameController;
import model.ZoneDeJeu;
import model.personnage.hero.Hero;
import model.personnage.monster.Monstre;

import controller.GameController;
import vue.GameWindow;

public class Main {
    public static void main(String[] args) {
        ZoneDeJeu zoneDeJeu = new ZoneDeJeu();
        Hero hero = new Hero("Arthas", 12, 14);

        zoneDeJeu.placeMonsterRandomly(new Monstre("Goblin", 8, 6));
        zoneDeJeu.placeMonsterRandomly(new Monstre("Orc", 10, 8));

        GameController controller = new GameController(zoneDeJeu, hero);
        controller.start();
    }
}

