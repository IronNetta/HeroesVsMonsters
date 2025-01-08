package services;

import model.personnage.hero.Hero;
import model.personnage.monster.Monstre;

public class HeroService {

    public void lootHero(Hero hero, Monstre monster) {
        hero.loot(monster.getGold(), monster.getLeather());
    }
}
