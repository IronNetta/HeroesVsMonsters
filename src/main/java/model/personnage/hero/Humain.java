package model.personnage.hero;

public class Humain extends Hero{

    public Humain(String name, int baseEnd, int baseFor) {
        super(name, baseEnd + 1, baseFor + 1);
    }

}
