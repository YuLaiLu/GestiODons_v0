
import java.awt.event.*;
import javax.swing.*;

public class FrameSecondaire extends JFrame implements ActionListener{
    
    JButton bouton1, bouton2;
    Superviseur unSuperviseur = new Superviseur();
    
    public FrameSecondaire(Superviseur leSuperviseur){
        unSuperviseur = leSuperviseur;
        setTitle("Menu");
        setSize(400, 400);
        JPanel simplePanel = new JPanel();
        
        bouton1 = new JButton("Menu principal");
        bouton1.addActionListener(this);
        simplePanel.add(bouton1);
        
        bouton2 = new JButton("Quitter");
        bouton2.addActionListener(this);
        simplePanel.add(bouton2);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == bouton1) {
            JFrame unFrame = new FramePrincipal(unSuperviseur);
            unFrame.setVisible(true);
            dispose();
            
        }
        if(event.getSource() == bouton2){
            
        }
    }
}
