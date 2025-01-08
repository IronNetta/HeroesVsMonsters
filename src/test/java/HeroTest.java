import model.personnage.hero.Hero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @Test
    void testHeroInitialization() {
        Hero hero = new Hero("John", 10, 12);

        assertEquals("John", hero.getName());
        assertEquals(10, hero.getEnd());
        assertEquals(12, hero.getFor());
        assertEquals(11, hero.getPv());
    }

    @Test
    void testHeroLoot() {
        Hero hero = new Hero("John", 10, 12);

        hero.loot(5, 3);
        assertEquals(5, hero.getGold());
        assertEquals(3, hero.getLeather());
    }

    @Test
    void testHeroAttack() {
        Hero hero = new Hero("John", 10, 12);
        Hero target = new Hero("Target", 8, 10);

        hero.attack(target);

        assertTrue(target.getPv() < target.getEnd() + target.calculateModifier(target.getEnd()));
    }
}
