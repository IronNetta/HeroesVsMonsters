package model.personnage.Hero;

import model.personnage.Perso;

public class Nain extends Perso {

    public Nain(String name, int baseEnd, int baseFor) {
        super(name, baseEnd + 2, baseFor);
    }
}
