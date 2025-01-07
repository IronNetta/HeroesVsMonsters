package model.dice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public enum Dice {

    D4(4),
    D6(6),;

    private int nbFaces;

    Dice(int nbFaces) {
        this.nbFaces = nbFaces;
    }

    public int roll() {
        Random random = new Random();
        return random.nextInt(nbFaces) + 1;
    }

    public int roll(int nbRolls) {
        int total = 0;
        for (int i = 0; i < nbRolls; i++) {
            total += roll();
        }
        return total;
    }

    public int roll(int nbRolls, int nbToKeep) {
        List<Integer> rolls = new ArrayList<>();
        for (int i = 0; i < nbRolls; i++) {
            rolls.add(this.roll());
        }
        return rolls.stream()
                .sorted((a,b) -> b - a)
                .limit(nbToKeep)
                .mapToInt(it -> it)
                .sum();
    }
}
