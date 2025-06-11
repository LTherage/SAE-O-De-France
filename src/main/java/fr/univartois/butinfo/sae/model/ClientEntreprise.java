package fr.univartois.butinfo.sae.model;

import java.util.Objects;

import static fr.univartois.butinfo.sae.model.TypeClient.ENTREPRISE;

/**
 * Type ClientEntreprise.
 */
public class ClientEntreprise extends Client{

    private String nom;
    private String prenom;

    private final TypeClient typeClient = ENTREPRISE;

    /**
     * @param achat Montant de l'achat effectué par le client.
     * * Cette méthode permet d'ajouter des points de fidélité au client en fonction du montant de l'achat.
     */
    @Override
    public void ajoutPointsFidelite(double achat) {
        int nbTranches = Double.valueOf(achat).intValue() / 1000;
        pointsFidelite += nbTranches * 10;
    }

    /**
     * @return le type du client.
     */
    @Override
    public String getTypeClient() {
        return typeClient.toString();
    }


    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom){
        this.prenom=prenom;
    }

    /**
     @return l'objet ClientEntreprise.
     */
    @Override
    public String toString() {
        return "ClientEntreprise{" +
                "prenom='" + prenom + '\'' +
                ", code=" + code +
                ", dateInscription=" + dateInscription +
                ", adresse=" + adresse +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", pointsFidelite=" + pointsFidelite +
                '}';
    }

    /**
     * @param o Object ClientEntreprise en paramètre.
     * @return Si l'objet passé en paramètre est égal à l'objet courant.

     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ClientEntreprise that = (ClientEntreprise) o;
        return Objects.equals(nom, that.nom) && Objects.equals(prenom, that.prenom) && typeClient == that.typeClient;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
}
