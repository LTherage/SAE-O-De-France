package fr.univartois.butinfo.sae.model;

import java.util.Comparator;
import java.util.Objects;

/**
 * La classe StockEau représente un stock d'eau dans un entrepôt donné, pour une catégorie spécifique.
 */
public class StockEau {
    /**
     * La catégorie de l'eau (plate ou gazeuse).
     */
    private Categorie categorie;

    /**
     * L'entrepôt où est stockée l'eau.
     */
    private Entrepot entrepot;

    /**
     * Le nombre de caisses de bouteilles.
     */
    private int quantite;

    /**
     * Vérifie si deux stocks d'eau sont égaux.
     *
     * @param o l'objet à comparer
     * @return true si les stocks sont égaux, false sinon
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StockEau stockEau = (StockEau) o;
        return quantite == stockEau.quantite && categorie == stockEau.categorie && Objects.equals(entrepot, stockEau.entrepot);
    }

    /**
     * Retourne la catégorie de l'eau.
     *
     * @return la catégorie de l'eau
     */
    public Categorie getCategorie() {
        return categorie;
    }

    /**
     * Retourne l'entrepôt du stock.
     *
     * @return l'entrepôt
     */
    public Entrepot getEntrepot() {
        return entrepot;
    }

    /**
     * Retourne la quantité de caisses de bouteilles.
     *
     * @return la quantité
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * Modifie la quantité de caisses de bouteilles (ajoute ou retire).
     *
     * @param quantite la variation de quantité à appliquer
     */
    public void deltaQuantity(int quantite) {
        this.quantite += quantite;
    }

    /**
     * Comparateur permettant de trier les stocks d'eau selon la quantité.
     */
    public static Comparator<StockEau> QuantityComparator = new Comparator<StockEau>() {
        @Override
        public int compare(StockEau o1, StockEau o2) {
            return o1.quantite - o2.quantite;
        }
    };

    /**
     * Retourne une représentation textuelle du stock d'eau.
     *
     * @return une chaîne représentant le stock d'eau
     */
    @Override
    public String toString() {
        return "StockEau{" +
                "categorie=" + categorie +
                ", entrepot=" + entrepot +
                ", quantite=" + quantite +
                '}';
    }

    /**
     * Définit la quantité de caisses de bouteilles.
     *
     * @param i la nouvelle quantité
     */
    public void setQuantite(int i) {
        quantite = i;
    }

    public void setEntrepot(Entrepot entrepot) {
        this.entrepot = entrepot;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}