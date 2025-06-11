package fr.univartois.butinfo.sae.model;

import java.util.Objects;

import static fr.univartois.butinfo.sae.model.TypeClient.ETABLISSEMENT_PUBLIC;

/**
 * Le type ClientEtablissementPublic.
 */
public class ClientEtablissementPublic extends Client {
    private String nom;
    private TypeEtablissement type;

    private final TypeClient typeClient = ETABLISSEMENT_PUBLIC;

    /**
     * @param achat le montant de l'achat
     *  Cette méthode permet d'ajouter des points de fidélité au client en fonction du montant de l'achat.
     */
    @Override
    public void ajoutPointsFidelite(double achat) {
        int nbTranches = Double.valueOf(achat).intValue() / 500;
        pointsFidelite += nbTranches * 10;
    }

    /**
     * Recupère le type du client.
     * @return le type du client
     */
    @Override
    public String getTypeClient() {
        return typeClient.toString();
    }

    /**
     * @return l'objet ClientEtablissementPublic.
     */
    @Override
    public String toString() {
        return "ClientEtablissementPublic{" +
                "type=" + type +
                ", code=" + code +
                ", dateInscription=" + dateInscription +
                ", adresse=" + adresse +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", pointsFidelite=" + pointsFidelite +
                '}';
    }

    public void setNom(String nom){
        this.nom=nom;
    }

    public void setType(TypeEtablissement type){
        this.type=type;
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
        ClientEtablissementPublic that = (ClientEtablissementPublic) o;
        return Objects.equals(nom, that.nom) && type == that.type && typeClient == that.typeClient;
    }

    public String getNom() {
        return nom;
    }

    public Object getType() {
        return type;
    }
}
