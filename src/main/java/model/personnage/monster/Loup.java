package model.personnage.monster;

public class Loup extends Monstre {

    public Loup(String name, int end, int forStat) {
        super(name, end, forStat);
    }

    @Override
    public String toString() {
        return super.toString() + " (Loup)";
    }
}
