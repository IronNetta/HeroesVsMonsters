package vue;

import model.personnage.Perso;

import javax.swing.*;
import java.awt.*;

public class GridPanel extends JPanel {

    private final int gridSize; // Taille de la grille (par exemple, 15x15)
    private final Perso[][] grid; // Référence à la grille des personnages

    public GridPanel(int gridSize, Perso[][] grid) {
        this.gridSize = gridSize;
        this.grid = grid;
        setPreferredSize(new Dimension(600, 600)); // Taille fixe pour le panel
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int cellSize = getWidth() / gridSize; // Taille d'une cellule

        // Dessiner les cases de la grille
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                // Définir la couleur de fond
                if ((row + col) % 2 == 0) {
                    g.setColor(Color.LIGHT_GRAY); // Cases alternées
                } else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(col * cellSize, row * cellSize, cellSize, cellSize);

                // Dessiner les personnages
                if (grid[col][row] != null) {
                    if (grid[col][row] instanceof model.personnage.hero.Hero) {
                        g.setColor(Color.BLUE); // Héros en bleu
                        g.drawString("H", col * cellSize + cellSize / 3, row * cellSize + cellSize / 2);
                    } else {
                        g.setColor(Color.RED); // Monstres en rouge
                        g.drawString("M", col * cellSize + cellSize / 3, row * cellSize + cellSize / 2);
                    }
                }

                // Dessiner les bordures des cases
                g.setColor(Color.BLACK);
                g.drawRect(col * cellSize, row * cellSize, cellSize, cellSize);
            }
        }
    }

    // Forcer le rafraîchissement de l'affichage
    public void refresh() {
        repaint();
    }
}

