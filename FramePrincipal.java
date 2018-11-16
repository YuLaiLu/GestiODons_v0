
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// classe graphique pour afficher les options
public class FramePrincipal extends JFrame implements ActionListener {

    JButton bouton1, bouton2, bouton3, bouton4;
    Superviseur unSuperviseur = new Superviseur();
    Color color1;

    public FramePrincipal(Superviseur leSuperviseur) {
        unSuperviseur = leSuperviseur;
        JPanel simplePanel = new JPanel();
        setTitle("Menu");
        setSize(400, 400);
        GridLayout gl = new GridLayout(4, 1, 0, 20);
        simplePanel.setLayout(gl);
        bouton1 = new JButton("Superviseur");
        bouton1.addActionListener(this);
        simplePanel.add(bouton1);
        bouton2 = new JButton("Employé");
        simplePanel.add(bouton2);
        bouton2.addActionListener(this);
        bouton3 = new JButton("Bénévole");
        simplePanel.add(bouton3);
        bouton3.addActionListener(this);
        bouton4 = new JButton("Donateur");
        simplePanel.add(bouton4);
        bouton4.addActionListener(this);
        add(simplePanel);
        color1 = bouton1.getForeground();
    }

    public FramePrincipal() {
        JPanel simplePanel = new JPanel();
        setTitle("Menu");
        setSize(400, 400);
        GridLayout gl = new GridLayout(4, 1, 0, 20);
        simplePanel.setLayout(gl);
        bouton1 = new JButton("Superviseur");
        bouton1.addActionListener(this);
        simplePanel.add(bouton1);
        bouton2 = new JButton("Employé");
        simplePanel.add(bouton2);
        bouton2.addActionListener(this);
        bouton3 = new JButton("Bénévole");
        simplePanel.add(bouton3);
        bouton3.addActionListener(this);
        bouton4 = new JButton("Donateur");
        simplePanel.add(bouton4);
        bouton4.addActionListener(this);
        add(simplePanel);
        color1 = bouton1.getForeground();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        // bouton superviseur
        if (event.getSource() == bouton1) {
            // Verification mot passe
            JPasswordField supervisorIdentification = new JPasswordField();
            boolean authenticationToken = false;
            do {
                JOptionPane.showMessageDialog(null, supervisorIdentification, "Mot de passe", JOptionPane.DEFAULT_OPTION);
                String pass = new String(supervisorIdentification.getPassword());
                if (pass.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Veuillez indiquez votre mot de passe", "Aucun mot de passe detecte.", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (pass.equals(unSuperviseur.getSupervisorIdentification())) {
                        authenticationToken = true;
                        JFrame unEmployeFrame = new SuperviseurFrame(unSuperviseur);
                        unEmployeFrame.setVisible(true);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Mot de passe incorrect.", "Erreur",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            } while (!authenticationToken);      
        }
        
        //bouton employé
        if (event.getSource() == bouton2) {       
            unSuperviseur.rechercherEmploye();
            JFrame unFramePrincipal = new FramePrincipal(unSuperviseur);
            unFramePrincipal.setVisible(true);
            unFramePrincipal.setLocationRelativeTo(null);
            unFramePrincipal.setResizable(false);
            dispose();
        }

        //bouton benevole
        if (event.getSource() == bouton3) {
            JFrame unBenevoleFrame = new BenevoleFrame(unSuperviseur);
            unBenevoleFrame.setVisible(true);
            unBenevoleFrame.setLocationRelativeTo(null);
            unBenevoleFrame.setResizable(false);
            dispose();
        }

        //bouton donateur
        if (event.getSource() == bouton4) {
            JFrame unDonateurFrame = new DonateurFrame(unSuperviseur);
            unDonateurFrame.setVisible(true);
            unDonateurFrame.setLocationRelativeTo(null);
            unDonateurFrame.setResizable(false);
            dispose();
        }
    }
}
