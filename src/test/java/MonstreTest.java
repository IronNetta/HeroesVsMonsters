import model.personnage.monster.Monstre;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonstreTest {

    @Test
    void testMonstreInitialization() {
        Monstre monster = new Monstre("Goblin", 8, 6);

        assertEquals("Goblin", monster.getName());
        assertEquals(8, monster.getEnd());
        assertEquals(6, monster.getFor());
        assertTrue(monster.getGold() >= 1 && monster.getGold() <= 6); // Dé 6 faces
        assertTrue(monster.getLeather() >= 1 && monster.getLeather() <= 4); // Dé 4 faces
    }

    @Test
    void testMonstreDropLoot() {
        Monstre monster = new Monstre("Goblin", 8, 6);

        int gold = monster.getGold();
        int leather = monster.getLeather();

        assertEquals(gold, monster.getGold());
        assertEquals(leather, monster.getLeather());
    }
}
