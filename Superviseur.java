
import java.util.*;
import javax.swing.*;

public class Superviseur {
    //Les attributs

    ArrayList<Employe> employes = new ArrayList<Employe>();
    ArrayList<Benevole> benevoles = new ArrayList<Benevole>();
    ArrayList<Donateur> donateurs = new ArrayList<Donateur>();
    
    private final String SUPERVISOR_IDENTIFICATION = "Dons";
    
    public String getSupervisorIdentification() {
    	return SUPERVISOR_IDENTIFICATION;
    }

    //methode ajouter employe
    public void ajouter(Employe unEmploye) {
        employes.add(unEmploye);
    }

    //methode ajouter employe
    public void ajouter(Benevole unBenevole) {
        benevoles.add(unBenevole);
    }

    //methode ajouter employe
    public void ajouter(Donateur unDonateur) {
        donateurs.add(unDonateur);
    }

    public void rechercherEmploye() {
        if (employes.size() > 0) {
            String resultat = "Liste des employés: \n";
            for (int i = 0; i < employes.size(); i++) {
                resultat += "\nEmployé #" + employes.get(i).getCode() + ":  " + employes.get(i).getPrenom() + "  " + employes.get(i).getNom();
            }

            JOptionPane.showMessageDialog(null, resultat);
            int code = Integer.parseInt(JOptionPane.showInputDialog(null, "Quel est votre code?", "Employé", JOptionPane.PLAIN_MESSAGE));
            for (int i = 0; i < employes.size(); i++) {
                if (code == employes.get(i).getCode()) {
                    JOptionPane.showMessageDialog(null, employes.get(i).toString());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Il n'y a pas d'employés d'enregistrer");
        }
    }
}
