package services;

import model.personnage.Perso;

public class GameService {

    public String fight(Perso attacker, Perso target) {
        attacker.attack(target);

        if (!target.isAlive()) {
            return target.getName() + " est mort suite à l'attaque de " + attacker.getName();
        }

        return attacker.getName() + " a infligé des dégâts à " + target.getName() + ". PV restants : " + target.getPv();
    }
}

