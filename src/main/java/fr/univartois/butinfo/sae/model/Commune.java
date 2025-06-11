package fr.univartois.butinfo.sae.model;

import java.util.Objects;

/**
 * Le type Commune.
 */
public class Commune {
    private String code;
    private String nom;
    private String departement;

    /**
     * Vérifie si l'objet en paramètre est égal à l'objet courant.
     *
     * @param o l'objet ClientEtablissementPublic en paramètre.
     * @return Si l'objet passé en paramètre est égal à l'objet courant.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Commune commune = (Commune) o;
        return Objects.equals(code, commune.code) && Objects.equals(nom, commune.nom) && Objects.equals(departement, commune.departement);
    }


    /**
     * Instancie un nouvel objet Commune.
     *
     * @param code       le code
     * @param nom        le nom
     * @param departement le département
     */
    public Commune(String code, String nom, String departement) {
        this.code = code;
        this.nom = nom;
        this.departement = departement;
    }

    /**
     * Récupère le code de la commune.
     *
     * @return le code postal de la commune
     */
    public String getCode() {
        return code;
    }

    /**
     * Permet de définir le code de la commune.
     *
     * @param code le code postal de la commune
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     *  Recupère le nom de la commune.
     *
     * @return le nom de la commune
     */
    public String getNom() {
        return nom;
    }

    /**
     * Permet de définir le nom de la commune.
     *
     * @param nom le nom de la commune
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Recupère le département de la commune.
     *
     * @return le département de la commune
     */
    public String getDepartement() {
        return departement;
    }

    /**
     * Permet de définir le département de la commune.
     *
     * @param departement le département de la commune
     */
    public void setDepartement(String departement) {
        this.departement = departement;
    }

    /**
     * Permet de récupérer le hashCode de l'objet Commune.
     *
     * @return le hashCode de l'objet Commune
     */
    @Override
    public String toString() {
        return "Commune{" +
                "code='" + code + '\'' +
                ", nom='" + nom + '\'' +
                ", departement='" + departement + '\'' +
                '}';
    }
}
