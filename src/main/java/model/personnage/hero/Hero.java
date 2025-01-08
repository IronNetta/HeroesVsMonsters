package model.personnage.hero;

import model.personnage.Perso;
import model.dice.Dice;

public class Hero extends Perso {
    private int gold;
    private int leather;

    public Hero(String name, int end, int forStat) {
        super(name, end, forStat);
        this.gold = 0;
        this.leather = 0;
    }

    public int getGold() {
        return gold;
    }

    public int getLeather() {
        return leather;
    }

    public void loot(int gold, int leather) {
        this.gold += gold;
        this.leather += leather;
    }

    @Override
    public void attack(Perso target) {
        int damage = Dice.D4.roll() + calculateModifier(this.getFor());
        target.takeDamage(damage);
    }

    @Override
    public String toString() {
        return super.toString() + ", Hero{" +
                "gold=" + gold +
                ", leather=" + leather +
                '}';
    }
}
