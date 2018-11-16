
public class Employe extends Benevole {

    //Les attributs
    public final int RETENUE_SALARIALE = 5 / 100;
    private String adresse;
    private double nbreHeures, tauxHoraire, salaire;
    private int code;

    //Constructeur
    public Employe(String unNom, String unPrenom, String unTel, String uneAdresse, double unNbreHeures, double unTauxHoraire) {
        super(unNom, unPrenom, unTel);
        this.adresse = uneAdresse;
        this.nbreHeures = unNbreHeures;
        this.tauxHoraire = unTauxHoraire;
        this.salaire = unNbreHeures * unTauxHoraire - unNbreHeures * unTauxHoraire * RETENUE_SALARIALE;
    }

    //accesseurs et mutateurs
    
    public String getAdresse() {
        return adresse;
    }

    public double getNbreHeures() {
        return nbreHeures;
    }

    public int getCode() {
        return code;
    }

    public double getTauxHoraire() {
        return tauxHoraire;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setAdresse(String uneAdresse) {
        adresse = uneAdresse;
    }

    public void setNbreHeures(double unNbreHeures) {
        nbreHeures = unNbreHeures;
    }

    public void setTauxHoraire(double unTauxHoraire) {
        tauxHoraire = unTauxHoraire;
    }

    public void setCode(int unCode) {
        code = unCode;
    }

    public void setSalaire(double unSalaire) {
        salaire = unSalaire;
    }

    // méthode pour retourner la chaine des attributs
    @Override
    public String toString() {
        return "Employé #" + getCode() + ": " + getPrenom() + " " + getNom() + " -- adresse: " + getAdresse() + " -- numéro de téléphone: " + getTel();
    }
}
