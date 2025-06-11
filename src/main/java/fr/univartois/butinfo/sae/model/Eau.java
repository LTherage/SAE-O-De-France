package fr.univartois.butinfo.sae.model;

import java.util.Objects;

/**
 * Le type de l'eau.
 */
public class Eau {
    private int id;
    private String marque;
    private String categorie;
    private double prix;

    private static int nextId = 0;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Eau eau = (Eau) o;
        return id == eau.id && Double.compare(prix, eau.prix) == 0 && Objects.equals(marque, eau.marque) && Objects.equals(categorie, eau.categorie);
    }

    /**
     * Compare l'id de deux eaux.
     *
     * @param eau l'eau à comparer
     * @return true si les ids sont différents, false sinon
     */
    public boolean compareId(Eau eau) {
        return this.id != eau.id;
    }

    /**
     * Creer un nouvel objet Eau.
     *
     * @param marque    la marque de l'eau concernée
     * @param categorie la catégorie de l'eau
     * @param prix      le prix de l'eau
     */
    public Eau(String marque, String categorie, double prix) {
        this.id = nextId++;
        this.marque = marque;
        this.categorie = categorie;
        this.prix = prix;
    }

    /**
     * Retourne la marque de l'eau.
     *
     * @return la marque de l'eau
     */
    public String getMarque() {
        return marque;
    }

    /**
     * Permet de modifier la marque de l'eau.
     *
     * @param marque la marque de l'eau
     */
    public void setMarque(String marque) {
        this.marque = marque;
    }

    /**
     * Recupère la catégorie de l'eau.
     *
     * @return la catégorie de l'eau
     */
    public String getCategorie() {
        return categorie;
    }

    /**
     * Modifie la catégorie de l'eau.
     *
     * @param categorie la catégorie de l'eau
     */
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    /**
     * Recupère le prix de l'eau.
     *
     * @return le prix de l'eau
     */
    public double getPrix() {
        return prix;
    }

    /**
     * Modifie le prix de l'eau.
     *
     * @param prix le prix de l'eau
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }

    /**
     * Permet de récupérer le hashCode de l'objet Commune.
     *
     * @return le hashCode de l'objet Commune
     */
    @Override
    public String toString() {
        return "Eau{" +
                "id=" + id +
                ", marque='" + marque + '\'' +
                ", categorie='" + categorie + '\'' +
                ", prix=" + prix +
                '}';
    }

    /**
     * Compare les id de deux objets Eau.
     *
     * @param o l'objet à comparer (Eau)
     * @return le résultat de la comparaison vrai ou faux
     */
    public boolean compareId(Object o){
        Eau eau = (Eau) o;
        return id == eau.id;
    }
}
