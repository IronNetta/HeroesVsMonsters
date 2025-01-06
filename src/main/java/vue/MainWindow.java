package vue;

import javax.swing.*;

public class MainWindow {
    private JFrame window;

    public MainWindow() {
        window = new JFrame();
        window.setTitle(" Heroes Vs Monsters");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800, 600);
        window.setLocationRelativeTo(null);
    }
    public void show() {
        window.setVisible(true);
    }
}
