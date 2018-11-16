
public class Donateur extends Benevole{

    //Les attributs
    private String adresse, modeTransport, quantite, nature, date;
    private double montant;

    //constructeurs
    public Donateur(String unNom, String unPrenom,String unTel, String uneAdresse, String unModeTransport, String uneQuantite, String uneNature, String uneDate, double unMontant) {
        super(unNom,unPrenom,unTel);// appel constructeur super-classe
        this.adresse = uneAdresse;
        this.modeTransport = unModeTransport;
        this.quantite = uneQuantite ;
        this.nature = uneNature;
        this.date = uneDate;
        this.montant = unMontant;
    }

    //Les accesseurs et mutateurs

    public String getAdresse() {
        return adresse;
    }

    public String getModeTransport() {
        return modeTransport;
    }

    public String getQuantite() {
        return quantite;
    }

    public String getNature() {
        return nature;
    }
    
    public String getDate(){
        return date;
    }
    
    public double getMontant(){
        return montant;
    }

    public void setAdresse(String uneAdresse) {
        adresse = uneAdresse;
    }

    public void setModeTransport(String unModeTransport) {
        modeTransport = unModeTransport;
    }

    public void setQuantite(String uneQuantite) {
        quantite = uneQuantite;
    }

    public void setNature(String uneNature) {
        nature = uneNature;
    }
    
    public void setDate(String uneDate){
        date = uneDate;
    }
    
    public void setMontant(double unMontant){
        montant = unMontant;
    }
    
    // méthode pour retourner la chaine des attributs
    @Override
    public String toString() {
        return super.getPrenom() + " " + super.getNom() + ": " + super.getTel() + " -- " + adresse + " -- " + modeTransport + " -- " + quantite + " -- " + nature + " -- " + date + " -- " + montant;
    }
}