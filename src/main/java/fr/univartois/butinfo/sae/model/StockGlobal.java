package fr.univartois.butinfo.sae.model;

import java.util.Arrays;
import java.util.Objects;

public class StockGlobal {
    private final StockEau[] stocks;
    private int last = 0;

    public StockGlobal() {
        stocks = new StockEau[50];
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StockGlobal that = (StockGlobal) o;
        return last == that.last && Objects.deepEquals(stocks, that.stocks);
    }
    public void add(StockEau stock) {
        int index;

        if ((index = Arrays.stream(stocks).toList().indexOf(stock)) >= 0) {
            stocks[index].deltaQuantity(stock.getQuantite());
        } else {
            stocks[last++] = stock;
        }
    }

    public void sub(int index, int quantite) {
        if (index < 0 || index >= last) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        stocks[index].deltaQuantity(-quantite);
    }

    public void triQuantite() {
        Arrays.sort(stocks, 0, last, StockEau.QuantityComparator);
    }

    public int getLast() {
        return last;
    }

    public StockEau[] getStocks() {
        return stocks;
    }
}
