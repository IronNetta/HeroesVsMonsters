import model.personnage.hero.Hero;
import model.personnage.monster.Monstre;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CombatTest {

    @Test
    void testHeroAttackMonstre() {
        Hero hero = new Hero("John", 12, 14);
        Monstre monster = new Monstre("Goblin", 10, 8);

        hero.attack(monster);

        assertTrue(monster.getPv() < monster.getEnd() + monster.calculateModifier(monster.getEnd()));
        assertTrue(monster.getPv() >= 0); // PV ne doivent pas être négatifs
    }

    @Test
    void testMonstreAttackHero() {
        Monstre monster = new Monstre("Goblin", 10, 8);
        Hero hero = new Hero("John", 12, 14);

        monster.attack(hero);

        assertTrue(hero.getPv() < hero.getEnd() + hero.calculateModifier(hero.getEnd()));
        assertTrue(hero.getPv() >= 0); // PV ne doivent pas être négatifs
    }
}

