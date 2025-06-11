package fr.univartois.butinfo.sae.model;

import java.util.Objects;

import static fr.univartois.butinfo.sae.model.TypeClient.PARTICULIER;

/**
 * Le type ClientParticulier.
 */
public class ClientParticulier extends Client {
    private String nom;
    private String prenom;

    private final TypeClient typeClient = PARTICULIER;

    @Override
    public void ajoutPointsFidelite(double achat) {
        int nbTranches = Double.valueOf(achat).intValue() / 100;
        pointsFidelite += nbTranches * 10;
    }

    @Override
    public String getTypeClient() {
        return typeClient.toString();
    }

    /**
     * Recupère le nom du client.
     *
     * @return le nom du client
     */
    public String getNom() {
        return nom;
    }

    /**
     * Permet de définir le nom du client.
     *
     *
     * @param nom the nom du clientParticulier
     *
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Recupère le prenom du client.
     *
     * @return le prenom du client
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Permet de définir le prenom du client.
     *
     * @param prenom le prenom du clientParticulier
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return l'objet ClientParticulier.
     */
    @Override
    public String toString() {
        return "ClientParticulier{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", code=" + code +
                ", dateInscription=" + dateInscription +
                ", adresse=" + adresse +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", pointsFidelite=" + pointsFidelite +
                '}';
    }
    /**
     * Vérifie si l'objet en paramètre est égal à l'objet courant.
     *
     * @param o l'objet ClientEtablissementPublic en paramètre.
     * @return Si l'objet passé en paramètre est égal à l'objet courant.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ClientParticulier that = (ClientParticulier) o;
        return Objects.equals(nom, that.nom) && Objects.equals(prenom, that.prenom) && typeClient == that.typeClient;
    }
}
