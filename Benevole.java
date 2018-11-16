
public class Benevole {

    //Les attributs
    private String nom, prenom, tel;

    //Constructeur
    public Benevole(String unNom, String unPrenom, String unTel) {
        this.nom = unNom;
        this.prenom = unPrenom;
        this.tel = unTel;

    }

    //Les accesseurs et mutateurs
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setNom(String unNom) {
        nom = unNom;
    }

    public void setPrenom(String unPrenom) {
        prenom = unPrenom;
    }

    public void setTel(String unTel) {
        tel = unTel;
    }

    // méthode pour retourner la chaine des attributs
    @Override
    public String toString() {
        return getPrenom() + " " + getNom() + ": " + getTel() + " -- ";
    }
}
