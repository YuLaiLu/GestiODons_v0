
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Employeframe extends JFrame {

    JTextField textField1, textField2, textField3, textField4, textField5, textField6;
    JButton bouton1;

    //creation d'un objet superviseur
    Superviseur unSuperviseur = new Superviseur();
    int unCode;

    public Employeframe(Superviseur leSuperviseur, int leCode) {
        unSuperviseur = leSuperviseur;
        setTitle("Superviseur");
        setSize(400, 600);
        setLocationRelativeTo(null);
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
        //bouton Chercher
        bouton1 = new JButton("Chercher");
        constraints.gridy = 12;
        panel1.add(bouton1, constraints);
        //
        bouton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(unSuperviseur.employes.get(unCode).getNom());
                textField2.setText(unSuperviseur.employes.get(unCode).getPrenom());
                textField3.setText(unSuperviseur.employes.get(unCode).getAdresse());
                textField4.setText(unSuperviseur.employes.get(unCode).getTel());
                textField5.setText("" + unSuperviseur.employes.get(unCode).getTauxHoraire());
                textField6.setText("" + unSuperviseur.employes.get(unCode).getNbreHeures());
                
                JFrame unFrame = new SuperviseurFrame(unSuperviseur);
                dispose();
                unFrame.setVisible(true);
                setLocationRelativeTo(null);
            }
        }
        );
    }
}