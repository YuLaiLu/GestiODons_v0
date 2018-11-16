
import java.awt.event.*;
import javax.swing.*;

// classe graphique pour enregistrer un bénévole
public class BenevoleFrame extends JFrame implements ActionListener {

    JButton bouton1;
    JTextField textField1, textField2, textField3;
    //creation d'objet superviseur
    Superviseur unSuperviseur = new Superviseur();

    public BenevoleFrame(Superviseur leSuperviseur) {
        unSuperviseur = leSuperviseur;
        setTitle("Bénévole");
        setSize(400, 400);
        JPanel simplePanel1 = new JPanel();
        JLabel label1 = new JLabel("           Nom             ");
        simplePanel1.add(label1);
        textField1 = new JTextField(30);
        simplePanel1.add(textField1);
        JLabel label2 = new JLabel("Prenom ");
        simplePanel1.add(label2);
        textField2 = new JTextField(30);
        simplePanel1.add(textField2);
        JLabel label3 = new JLabel("numero telephone ");
        simplePanel1.add(label3);
        textField3 = new JTextField(30);
        simplePanel1.add(textField3);
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
            String numeroTel = textField3.getText();
            //constructeur
            Benevole unBenevole = new Benevole(nom, prenom, numeroTel);
            unSuperviseur.ajouter(unBenevole);
            //message qui confirme l'enregistrement
            JOptionPane.showMessageDialog(null, "Enregistrement reussi!"
                    + "\nMerci pour votre temps et votre énergie qui font tant de bien aux usagers et à nous! ");
            JFrame unFramePrincipal = new FramePrincipal();
            unFramePrincipal.setVisible(true);
            dispose();
        }
    }
}