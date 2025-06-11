package fr.univartois.butinfo.sae.model;

import java.util.Objects;

/**
 * La classe Entrepot représente un entrepôt avec un code, un nom et une adresse.
 */
public class Entrepot {
    /**
     * Le code unique de l'entrepôt.
     */
    private int code;

    /**
     * Le nom de l'entrepôt.
     */
    private String nom;

    /**
     * L'adresse de l'entrepôt.
     */
    private Adresse adresse;

    /**
     * Vérifie si deux entrepôts sont égaux.
     *
     * @param o l'objet à comparer
     * @return true si les entrepôts sont égaux, false sinon
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Entrepot entrepot = (Entrepot) o;
        return code == entrepot.code && Objects.equals(nom, entrepot.nom) && Objects.equals(adresse, entrepot.adresse);
    }

    /**
     * Construit un nouvel entrepôt.
     *
     * @param code le code de l'entrepôt
     * @param nom le nom de l'entrepôt
     * @param adresse l'adresse de l'entrepôt
     */
    public Entrepot(int code, String nom, Adresse adresse) {
        this.code = code;
        this.nom = nom;
        this.adresse = adresse;
    }

    /**
     * Retourne le code de l'entrepôt.
     *
     * @return le code de l'entrepôt
     */
    public int getCode() {
        return code;
    }

    /**
     * Retourne le nom de l'entrepôt.
     *
     * @return le nom de l'entrepôt
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifie le nom de l'entrepôt.
     *
     * @param nom le nouveau nom de l'entrepôt
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne l'adresse de l'entrepôt.
     *
     * @return l'adresse de l'entrepôt
     */
    public Adresse getAdresse() {
        return adresse;
    }

    /**
     * Modifie l'adresse de l'entrepôt.
     *
     * @param adresse la nouvelle adresse de l'entrepôt
     */
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    /**
     * Retourne une représentation textuelle de l'entrepôt.
     *
     * @return une chaîne représentant l'entrepôt
     */
    @Override
    public String toString() {
        return "Entrepot{" +
                "code=" + code +
                ", nom='" + nom + '\'' +
                ", adresse=" + adresse +
                '}';
    }

    /**
     * Compare le code de cet entrepôt avec celui d'un autre entrepôt.
     *
     * @param entrepot2 l'autre entrepôt à comparer
     * @return true si les codes sont identiques, false sinon
     */
    public boolean compareId(Entrepot entrepot2) {
        return code == entrepot2.code;
    }
}