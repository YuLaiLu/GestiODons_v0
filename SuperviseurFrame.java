
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SuperviseurFrame extends JFrame {

    JTextField textField1, textField2, textField3, textField4, textField5, textField6;
    JButton bouton1;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem goBackToMainPage, exitApplication;

    //creation d'un objet superviseur
    Superviseur unSuperviseur = new Superviseur();

    public SuperviseurFrame(Superviseur leSuperviseur) {
        unSuperviseur = leSuperviseur;
        setTitle("Superviseur");
        setSize(600, 800);
        setLocationRelativeTo(null);
        setResizable(false);
        JTabbedPane tabbedPane = new JTabbedPane(); // création du panneau à onglets

        // création et ajout des pages des different onglets (des panneaux aussi)
        // Onglet pour enregistrer un employé
        GridBagLayout gl = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        JPanel panel1 = new JPanel();
        panel1.setLayout(gl);
        //nom
        JLabel label1 = new JLabel("Nom");
        constraints.weightx = 100;
        constraints.weighty = 100;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        panel1.add(label1, constraints);
        panel1.add(label1);
        textField1 = new JTextField(30);
        constraints.gridy = 1;
        panel1.add(textField1, constraints);
        //prénom
        JLabel label2 = new JLabel("Prenom ");
        constraints.gridy = 2;
        panel1.add(label2, constraints);
        textField2 = new JTextField(30);
        constraints.gridy = 3;
        panel1.add(textField2, constraints);
        //adresse
        JLabel label3 = new JLabel("Adresse");
        constraints.gridy = 4;
        panel1.add(label3, constraints);
        textField3 = new JTextField(30);
        constraints.gridy = 5;
        panel1.add(textField3, constraints);
        //numéro de téléphone
        JLabel label4 = new JLabel("numero tel ");
        constraints.gridy = 6;
        panel1.add(label4, constraints);
        textField4 = new JTextField(30);
        constraints.gridy = 7;
        panel1.add(textField4, constraints);
        //taux horaire
        JLabel label5 = new JLabel("Taux horaire");
        constraints.gridy = 8;
        panel1.add(label5, constraints);
        textField5 = new JTextField(30);
        constraints.gridy = 9;
        panel1.add(textField5, constraints);
        //nombre d'heure travaillée
        JLabel label6 = new JLabel("Nombre d'heures travaillées");
        constraints.gridy = 10;
        panel1.add(label6, constraints);
        textField6 = new JTextField(30);
        constraints.gridy = 11;
        panel1.add(textField6, constraints);
        //bouton enregistrer
        bouton1 = new JButton("Enregistrer");
        constraints.gridy = 12;
        panel1.add(bouton1, constraints);
        // Menu
        menuBar = new JMenuBar();
        menu = new JMenu("Menu");
        goBackToMainPage = new JMenuItem("Menu Principal");
        exitApplication = new JMenuItem("Quitter");
        menu.add(goBackToMainPage);
        menu.add(exitApplication);
        menuBar.add(menu);
        panel1.add(menuBar);

        bouton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nom = textField1.getText();
                String prenom = textField2.getText();
                String adresse = textField3.getText();
                String numeroTel = textField4.getText();
                double tauxHoraire = Integer.parseInt(textField5.getText());
                double nbreHeures = Integer.parseInt(textField6.getText());
                //constructeur
                Employe unEmploye = new Employe(nom, prenom, adresse, numeroTel, tauxHoraire, nbreHeures);
                unEmploye.setCode(unSuperviseur.employes.size());
                unSuperviseur.ajouter(unEmploye);
                //retour de code employe
                JOptionPane.showMessageDialog(null, "Le code d'employé est: " + unEmploye.getCode());
                //message qui confirme l'enregistrement
                JOptionPane.showMessageDialog(null, "Enregistrement Reussi!");
                JFrame unFrame = new SuperviseurFrame(unSuperviseur);
                dispose();
                unFrame.setVisible(true);
            }
        }
        );
        tabbedPane.addTab("Enregistrer un employé", panel1);

        goBackToMainPage.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                JFrame frame = new FramePrincipal(unSuperviseur);
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
                dispose();
            }
        });

        exitApplication.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                setVisible(false);
                dispose();
            }
        });

        // Onglet pour afficher les employés
        JPanel panel2 = new JPanel();
        panel2.add(menuBar);
        String resultat = "Liste des employés: \n\n";
        if (unSuperviseur.employes.size() > 0) {
            for (Employe employe : unSuperviseur.employes) {
                resultat += employe.toString() + "\n";
            }
        } else {
            resultat = "Il n'y a pas d'employés ";
        }
        panel2.add(new JTextArea(resultat));
        tabbedPane.addTab("Afficher employé", panel2);

        // Onglet pour afficher les bénévoles
        JPanel panel3 = new JPanel();
        resultat = "Liste des bénévoles: \n";
        if (unSuperviseur.benevoles.size() > 0) {
            for (Benevole benevoles : unSuperviseur.benevoles) {
                resultat += benevoles.toString();
            }
        } else {
            resultat = "Il n'y a pas de bénévoles ";
        }
        panel3.add(new JTextArea(resultat));
        panel3.add(menuBar);
        tabbedPane.addTab("Liste bénévoles", panel3);

        // Onglet pour afficher les donateurs
        JPanel panel4 = new JPanel();
        resultat = "Liste des donateurs: \n";
        if (unSuperviseur.donateurs.size() > 0) {
            for (Donateur donateurs : unSuperviseur.donateurs) {
                resultat += donateurs.toString();
            }
        } else {
            resultat = "Il n'y a pas de donateurs ";
        }
        panel4.add(new JTextArea(resultat));
        tabbedPane.addTab("Liste donateurs", panel4);
        panel4.add(menuBar);
        add(tabbedPane); // ajout du panneau dans le frame
    }
}
