package vue;

import model.personnage.Perso;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class GameWindow extends JFrame {

    private JTextArea logArea;
    private GridPanel gridPanel;
    private JPanel heroPanel;
    private JPanel monsterPanel;
    private JButton attackButton;

    public GameWindow(int gridSize, Perso[][] grid) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        setTitle("Heroes Vs Monsters");
        setSize((int) (screenSize.width * 0.8), (int) (screenSize.height * 0.8));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        setupComponents(gridSize, grid);

        setLocationRelativeTo(null);
    }

    private void setupComponents(int gridSize, Perso[][] grid) {
        // Zone de log
        logArea = new JTextArea();
        logArea.setEditable(false);
        add(new JScrollPane(logArea), BorderLayout.SOUTH);

        // Panneau pour la grille
        gridPanel = new GridPanel(gridSize, grid);
        add(gridPanel, BorderLayout.CENTER);

        // Panneau pour les informations du héros
        heroPanel = new JPanel();
        heroPanel.setBorder(BorderFactory.createTitledBorder("Héros"));
        heroPanel.setPreferredSize(new Dimension(200, 600));
        add(heroPanel, BorderLayout.WEST);

        // Panneau pour les informations du monstre
        monsterPanel = new JPanel();
        monsterPanel.setBorder(BorderFactory.createTitledBorder("Monstre"));
        monsterPanel.setPreferredSize(new Dimension(200, 600));
        add(monsterPanel, BorderLayout.EAST);

        // Bouton pour attaquer
        JPanel actionPanel = new JPanel();
        attackButton = new JButton("Attaquer");
        actionPanel.add(attackButton);
        add(actionPanel, BorderLayout.NORTH);
    }

    public void appendLog(String message) {
        logArea.append(message + "\n");
    }

    public void updateHeroPanel(String heroInfo) {
        heroPanel.removeAll();
        heroPanel.add(new JLabel("<html>" + heroInfo.replace("\n", "<br>") + "</html>"));
        heroPanel.revalidate();
        heroPanel.repaint();
    }

    public void updateMonsterPanel(String monsterInfo) {
        monsterPanel.removeAll();
        monsterPanel.add(new JLabel("<html>" + monsterInfo.replace("\n", "<br>") + "</html>"));
        monsterPanel.revalidate();
        monsterPanel.repaint();
    }

    public void refreshGrid() {
        gridPanel.refresh();
    }

    public void setKeyListener(KeyListener listener) {
        addKeyListener(listener);
        setFocusable(true); // Assurer que la fenêtre capte les événements clavier
    }

    public void setAttackButtonListener(ActionListener listener) {
        attackButton.addActionListener(listener);
    }
}


