package model.personnage.hero;

public class Nain extends Hero {

    public Nain(String name, int baseEnd, int baseFor) {
        super(name, baseEnd + 2, baseFor);
    }
}
