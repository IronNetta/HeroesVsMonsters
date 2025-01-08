package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {

    private JTextArea logArea;
    private JPanel heroPanel;
    private JPanel monsterPanel;
    private JButton attackButton;

    public GameWindow() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        setTitle("Heroes Vs Monsters");
        setSize((int) (screenSize.width * 0.8), (int) (screenSize.height * 0.8));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        setupComponents();

        setLocationRelativeTo(null);
    }

    private void setupComponents() {
        logArea = new JTextArea();
        logArea.setEditable(false);
        add(new JScrollPane(logArea), BorderLayout.CENTER);

        heroPanel = new JPanel();
        heroPanel.setBorder(BorderFactory.createTitledBorder("Héros"));
        heroPanel.setPreferredSize(new Dimension(200, 600));
        add(heroPanel, BorderLayout.WEST);

        monsterPanel = new JPanel();
        monsterPanel.setBorder(BorderFactory.createTitledBorder("Monstre"));
        monsterPanel.setPreferredSize(new Dimension(200, 600));
        add(monsterPanel, BorderLayout.EAST);

        JPanel actionPanel = new JPanel();
        attackButton = new JButton("Attaquer");
        actionPanel.add(attackButton);
        add(actionPanel, BorderLayout.SOUTH);
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

    public void setAttackButtonListener(ActionListener listener) {
        attackButton.addActionListener(listener);
    }
}
