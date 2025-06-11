package fr.univartois.butinfo.sae.model;

import java.util.Date;
import java.util.Objects;

/**
 * Le type Client.
 */
public abstract class Client {
    /**
     * Le code du client.
     */
    protected int code;
    /**
     * La date d'inscription .
     */
    protected Date dateInscription;
    /**
     * L'adresse du client.
     */
    protected Adresse adresse;
    /**
     * Le numéro de téléphone du client.
     */
    protected String telephone;
    /**
     * l'email du client.
     */
    protected String email;
    /**
     * Le nombre de points de fidélité du client.
     */
    protected int pointsFidelite;

    /**
     * Ajout points fidelite.
     *
     * @param achat le montant de l'achat
     */
    public abstract void ajoutPointsFidelite(double achat);

    /**
     * Recupère le type du client.
     *
     * @return le type du client
     */
    public abstract String getTypeClient();

    /**
     * Recupère le code du client.
     *
     * @return le code du client
     */
    public int getCode() {
        return code;
    }

    /**
     * Recupère la date d'inscription du client.
     *
     * @return la date d'inscription du client
     */
    public Date getDateInscription() {
        return dateInscription;
    }

    /**
     * Recupère l'adresse du client.
     *
     * @return l'adresse du client
     */
    public Adresse getAdresse() {
        return adresse;
    }

    /**
     * Recupère le numéro de téléphone du client.
     *
     * @return le numéro de téléphone du client
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Récupère l'email du client.
     *
     * @return l'email du client
     */
    public String getEmail() {
        return email;
    }

    /**
     * Recupère les points de fidélité du client.
     *
     * @return le nombre de points de fidélité du client
     */
    public int getPointsFidelite() {
        return pointsFidelite;
    }

    /**
     * Permet de définir l'adresse du client.
     *
     * @param adresse l'adresse du client remplacée
     */
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    /**
     * Permet de définir le numéro de téléphone du client.
     *
     * @param telephone le numéro de téléphone du client remplacé
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * Permet de définir l'email du client.
     *
     * @param email l'email du client remplacé
     */
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return code == client.code && pointsFidelite == client.pointsFidelite && Objects.equals(dateInscription, client.dateInscription) && Objects.equals(adresse, client.adresse) && Objects.equals(telephone, client.telephone) && Objects.equals(email, client.email);
    }


}
