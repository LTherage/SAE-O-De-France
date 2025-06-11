package fr.univartois.butinfo.sae.model;

import java.util.Arrays;
import java.util.Objects;

/**
 * La classe StockGlobal gère un ensemble de stocks d'eau.
 * Elle permet d'ajouter, de retirer et de trier les stocks selon la quantité.
 */
public class StockGlobal {
    /**
     * Tableau contenant les différents stocks d'eau.
     */
    private final StockEau[] stocks;

    /**
     * Indique le nombre de stocks actuellement enregistrés.
     */
    private int last = 0;

    /**
     * Constructeur de StockGlobal initialisant le tableau de stocks à une taille de 50.
     */
    public StockGlobal() {
        stocks = new StockEau[50];
    }

    /**
     * Vérifie si deux objets StockGlobal sont égaux.
     *
     * @param o l'objet à comparer
     * @return true si les objets sont égaux, false sinon
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StockGlobal that = (StockGlobal) o;
        return last == that.last && Objects.deepEquals(stocks, that.stocks);
    }

    /**
     * Ajoute un stock d'eau au tableau. Si le stock existe déjà, la quantité est mise à jour.
     *
     * @param stock le stock d'eau à ajouter
     */
    public void add(StockEau stock) {
        int index;
        if ((index = Arrays.stream(stocks).toList().indexOf(stock)) >= 0) {
            stocks[index].deltaQuantity(stock.getQuantite());
        } else {
            stocks[last++] = stock;
        }
    }

    /**
     * Retire une quantité donnée d'un stock à l'index spécifié.
     *
     * @param index l'index du stock
     * @param quantite la quantité à retirer
     * @throws IndexOutOfBoundsException si l'index est invalide
     */
    public void sub(int index, int quantite) {
        if (index < 0 || index >= last) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        stocks[index].deltaQuantity(-quantite);
    }

    /**
     * Trie les stocks d'eau selon la quantité.
     */
    public void triQuantite() {
        Arrays.sort(stocks, 0, last, StockEau.QuantityComparator);
    }

    /**
     * Retourne le nombre de stocks enregistrés.
     *
     * @return le nombre de stocks
     */
    public int getLast() {
        return last;
    }

    /**
     * Retourne le tableau des stocks d'eau.
     *
     * @return le tableau des stocks
     */
    public StockEau[] getStocks() {
        return stocks;
    }
}