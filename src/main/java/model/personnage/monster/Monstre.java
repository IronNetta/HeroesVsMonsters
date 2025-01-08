package model.personnage.monster;

import model.dice.Dice;
import model.personnage.Perso;

import java.util.Random;

public class Monstre extends Perso {
    private int gold;
    private int leather;

    public Monstre(String name, int end, int forStat) {
        super(name, end, forStat);
        Random random = new Random();
        this.gold = random.nextInt(6) + 1;
        this.leather = random.nextInt(4) + 1;
    }

    public int getGold() {
        return gold;
    }

    public int getLeather() {
        return leather;
    }

    public void attack(Perso target) {
        int damage = Dice.D4.roll() + calculateModifier(this.getFor());
        target.takeDamage(damage);
    }

    public int[] dropLoot() {
        return new int[]{this.gold, this.leather};
    }

    @Override
    public String toString() {
        return super.toString() + ", Monstre{" +
                "gold=" + gold +
                ", leather=" + leather +
                '}';
    }
}
