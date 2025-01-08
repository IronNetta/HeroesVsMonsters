package model.personnage.monster;

public class Dragonnet extends Monstre {
    public Dragonnet(String name, int end, int forStat) {
        super(name, end + 1, forStat);
    }
    @Override
    public String toString() {
        return super.toString() + " (Dragonnet)";
    }
}
