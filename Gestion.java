
import javax.swing.*;

public class Gestion {
    //demarrer l'application
    public static void main(String[] args) {
        afficherMenu();
    }

    public static void afficherMenu() {
        JFrame frame = new FramePrincipal();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}