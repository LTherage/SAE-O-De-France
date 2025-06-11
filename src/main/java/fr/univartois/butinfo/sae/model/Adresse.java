package fr.univartois.butinfo.sae.model;

import java.util.Objects;

/**
 * La classe Adresse .
 */
public class Adresse {
    private int numero;
    private String voie;
    private Commune commune;

    /**
     * Instancie un objet Adresse.
     *
     * @param numero le numéro de l'adresse
     * @param voie   la rue de l'adresse
     * @param commune la commune de l'adresse
     */
    public Adresse(int numero, String voie, Commune commune) {
        this.numero = numero;
        this.voie = voie;
        this.commune = commune;
    }

    /**
     * Permet de récupérer le numéro de l'adresse.
     *
     * @return int : le numéro de l'adresse
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Permet de définir le numéro de l'adresse.
     *
     * @param  numero le numéro de l'adresse
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Permet de récupérer la voie de l'adresse.
     *
     * @return la voie de l'adresse
     */
    public String getVoie() {
        return voie;
    }

    /**
     * Permet de modifier la voie de l'adresse.
     *
     * @param voie la voie de l'adresse
     */
    public void setVoie(String voie) {
        this.voie = voie;
    }

    /**
     * Récupère la commune de l'adresse.
     *
     * @return la commune de l'adresse
     */
    public Commune getCommune() {
        return commune;
    }

    /**
     * Définit la commune de l'adresse.
     *
     * @param commune la commune de l'adresse
     */
    public void setCommune(Commune commune) {
        this.commune = commune;
    }

    /**
     * Définit la commune de l'adresse.
     *
     * @param o l'objet à comparer (Adresse)
     * @return true si les objets sont égaux, false sinon
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Adresse adresse = (Adresse) o;
        return numero == adresse.numero && Objects.equals(voie, adresse.voie) && Objects.equals(commune, adresse.commune);
    }


    /**
     * Définit la commune de l'adresse.
     *
     *
     * @return une chaîne de caractères représentant l'adresse
     */
    @Override
    public String toString() {
        return "Adresse{" +
                "numero=" + numero +
                ", voie='" + voie + '\'' +
                ", commune=" + commune +
                '}';
    }
}
