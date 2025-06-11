package fr.univartois.butinfo.sae.model;

import java.util.Comparator;
import java.util.Objects;

public class StockEau {
    private Categorie categorie;
    private Entrepot entrepot;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StockEau stockEau = (StockEau) o;
        return quantite == stockEau.quantite && categorie == stockEau.categorie && Objects.equals(entrepot, stockEau.entrepot);
    }
    /**
     * Le nombre de caisses de bouteilles.
     */
    private int quantite;

    public Categorie getCategorie() {
        return categorie;
    }

    public Entrepot getEntrepot() {
        return entrepot;
    }

    public int getQuantite() {
        return quantite;
    }

    public void deltaQuantity(int quantite) {
        this.quantite += quantite;
    }


    public static Comparator<StockEau> QuantityComparator = new Comparator<StockEau>() {
        @Override
        public int compare(StockEau o1, StockEau o2) {
            return o1.quantite - o2.quantite;
        }
    };

    @Override
    public String toString() {
        return "StockEau{" +
                "categorie=" + categorie +
                ", entrepot=" + entrepot +
                ", quantite=" + quantite +
                '}';
    }
}
