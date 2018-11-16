
import java.awt.event.*;
import javax.swing.*;

// classe graphique pour enregistrer un donnateur
public class DonateurFrame extends JFrame implements ActionListener {

    JTextField textField1, textField2, textField3, textField4, textField6, textField7, textField8, textField9;
    JButton bouton1;
    JCheckBox checkBox1, checkBox2, checkBox3, checkBox4;
    //creation d'objet superviseur
    Superviseur unSuperviseur = new Superviseur();

    public DonateurFrame(Superviseur leSuperviseur) {
        unSuperviseur = leSuperviseur;
        setTitle("Donateur");
        setSize(400, 600);
        setLocationRelativeTo(null);
        JPanel simplePanel1 = new JPanel();
        JLabel label1 = new JLabel("           Nom             ");
        simplePanel1.add(label1);
        textField1 = new JTextField(30);
        simplePanel1.add(textField1);
        JLabel label2 = new JLabel("Prenom ");
        simplePanel1.add(label2);
        textField2 = new JTextField(30);
        simplePanel1.add(textField2);
        JLabel label3 = new JLabel("Adresse");
        simplePanel1.add(label3);
        textField3 = new JTextField(30);
        simplePanel1.add(textField3);
        JLabel label4 = new JLabel("numero tel ");
        simplePanel1.add(label4);
        textField4 = new JTextField(30);
        simplePanel1.add(textField4);
        JLabel label5 = new JLabel("Veuillez cocher la nature de don qui correspond                      ");
        simplePanel1.add(label5);
        checkBox1 = new JCheckBox("Argent");
        simplePanel1.add(checkBox1);
        checkBox2 = new JCheckBox("Habillement");
        simplePanel1.add(checkBox2);
        checkBox3 = new JCheckBox("Nourriture");
        simplePanel1.add(checkBox3);
        checkBox4 = new JCheckBox("Ameublement");
        simplePanel1.add(checkBox4);
        JLabel label8 = new JLabel("La date");
        simplePanel1.add(label8);
        textField8 = new JTextField(30);
        simplePanel1.add(textField8);
        JLabel label6 = new JLabel("Mode de transport");
        simplePanel1.add(label6);
        textField6 = new JTextField(30);
        simplePanel1.add(textField6);
        JLabel label7 = new JLabel("La quantité du don");
        simplePanel1.add(label7);
        textField7 = new JTextField(30);
        simplePanel1.add(textField7);
        JLabel label9 = new JLabel("Le montant estimé du don");
        simplePanel1.add(label9);
        textField9 = new JTextField(30);
        simplePanel1.add(textField9);
        bouton1 = new JButton("Enregistrer");
        simplePanel1.add(bouton1);
        bouton1.addActionListener(this);
        add(simplePanel1);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        //bouton enregistrer
        if (event.getSource() == bouton1) {
            String nom = textField1.getText();
            String prenom = textField2.getText();
            String adresse = textField3.getText();
            String numeroTel = textField4.getText();
            String modeTransport = textField6.getText();
            String quantite = textField7.getText();
            String nature = "";
            String date = textField8.getText();
            double montant = Double.parseDouble(textField9.getText());
            if (checkBox1.isSelected()) {
                nature = checkBox1.getName();
            }
            if (checkBox2.isSelected()) {
                nature += checkBox2.getName();
            }
            if (checkBox3.isSelected()) {
                nature += checkBox3.getName();
            }
            if (checkBox4.isSelected()) {
                nature += checkBox4.getName();
            }
            //constructeur
            Donateur unDonateur = new Donateur(nom, prenom, numeroTel, adresse, modeTransport, quantite, nature, date, montant);
            unSuperviseur.ajouter(unDonateur);
            //message qui confirme l'enregistrement
            JOptionPane.showMessageDialog(null, "Enregistre reussi!"
                    + "\nMerci pour votre participation!");
            JFrame unFramePrincipal = new FramePrincipal(unSuperviseur);
            unFramePrincipal.setVisible(true);
            dispose();
        }
    }
}
