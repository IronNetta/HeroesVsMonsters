package model.personnage.monster;

public class Orque extends Monstre {

    public Orque(String name, int end, int forStat) {
        super(name, end, forStat + 1);
    }

    @Override
    public String toString() {
        return super.toString() + " (Orque)";
    }
}
