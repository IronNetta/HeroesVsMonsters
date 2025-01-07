package model.personnage.monster;

import model.personnage.Perso;

public class Loup extends Monstre {

    public Loup(String name, int end, int forStat) {
        super(name, end, forStat);
    }

    @Override
    public String toString() {
        return super.toString() + " (Loup)";
    }
}
