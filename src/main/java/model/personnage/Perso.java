package model.personnage;

import model.dice.Dice;

public abstract class Perso {
    private String name;
    private final int End;
    private final int For;
    private int Pv;

    public Perso(String name, int end, int forStat) {
        this.name = name;
        this.End = end;
        this.For = forStat;
        this.Pv = end + calculateModifier(end);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnd() {
        return End;
    }

    public int getFor() {
        return For;
    }

    public int getPv() {
        return Pv;
    }

    public void takeDamage(int damage) {
        this.Pv -= damage;
        if (this.Pv < 0) this.Pv = 0;
    }

    public int calculateModifier(int value) {
        if (value < 5) return -1;
        if (value < 10) return 0;
        if (value < 15) return 1;
        return 2;
    }

    public boolean isAlive() {
        return this.Pv > 0;
    }

    public abstract void attack(Perso target);

    @Override
    public String toString() {
        return "Perso{" +
                "name='" + name + '\'' +
                ", End=" + End +
                ", For=" + For +
                ", Pv=" + Pv +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Perso perso = (Perso) o;
        return End == perso.End && For == perso.For && Pv == perso.Pv && name.equals(perso.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + End;
        result = 31 * result + For;
        result = 31 * result + Pv;
        return result;
    }

}
