package model;

import model.personnage.Perso;
import model.personnage.monster.Monstre;

import java.util.Random;

public class ZoneDeJeu {
    private final int width = 15;
    private final int height = 15;
    private final Perso[][] grid;

    public ZoneDeJeu() {
        grid = new Perso[width][height];
    }

    // Récupérer la grille
    public Perso[][] getGrid() {
        return grid;
    }

    // Ajouter un personnage sur la grille
    public void placeCharacter(Perso character, int x, int y) {
        if (isValidPosition(x, y) && grid[x][y] == null) {
            grid[x][y] = character;
            character.setPosition(x, y);
        }
    }

    public void placeMonsterRandomly(Monstre monster) {
        Random random = new Random();
        int x, y;

        do {
            x = random.nextInt(width);
            y = random.nextInt(height);
        } while (!isValidPosition(x, y) || grid[x][y] != null);

        placeCharacter(monster, x, y);
    }

    private boolean isValidPosition(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public void printGrid() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[j][i] instanceof Monstre) {
                    System.out.print("M "); // Monstre
                } else if (grid[j][i] instanceof Perso) {
                    System.out.print("H "); // Héros
                } else {
                    System.out.print(". "); // Case vide
                }
            }
            System.out.println();
        }
    }

    public void moveCharacter(Perso character, int newX, int newY) {
        if (!isValidPosition(newX, newY)) {
            System.out.println("Déplacement invalide : hors des limites !");
            return;
        }

        if (grid[newX][newY] != null) {
            System.out.println("Déplacement invalide : la case est occupée !");
            return;
        }

        // Supprimer le personnage de sa position actuelle
        grid[character.getX()][character.getY()] = null;

        // Mettre à jour la position et l'ajouter à la nouvelle case
        character.setPosition(newX, newY);
        grid[newX][newY] = character;

        System.out.println(character.getName() + " s'est déplacé en (" + newX + ", " + newY + ")");
    }

    public Monstre getAdjacentMonster(Perso hero) {
        int x = hero.getX();
        int y = hero.getY();

        // Vérifier les cases adjacentes (haut, bas, gauche, droite)
        if (isValidPosition(x, y - 1) && grid[x][y - 1] instanceof Monstre) {
            return (Monstre) grid[x][y - 1];
        }
        if (isValidPosition(x, y + 1) && grid[x][y + 1] instanceof Monstre) {
            return (Monstre) grid[x][y + 1];
        }
        if (isValidPosition(x - 1, y) && grid[x - 1][y] instanceof Monstre) {
            return (Monstre) grid[x - 1][y];
        }
        if (isValidPosition(x + 1, y) && grid[x + 1][y] instanceof Monstre) {
            return (Monstre) grid[x + 1][y];
        }

        return null; // Aucun monstre adjacent
    }
}

