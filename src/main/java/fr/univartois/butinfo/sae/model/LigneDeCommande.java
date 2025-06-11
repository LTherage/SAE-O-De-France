package fr.univartois.butinfo.sae.model;

import java.util.Objects;

public class LigneDeCommande {
    private final Eau eau;
    /**
     * Le nombre de bouteilles d'eau
     */
    private final int quantite;

    public LigneDeCommande(Eau eau, int quantite) {
        this.eau = eau;
        this.quantite = quantite;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LigneDeCommande that = (LigneDeCommande) o;
        return quantite == that.quantite && Objects.equals(eau, that.eau);
    }
    public Eau getEau() {
        return eau;
    }

    public int getQuantite() {
        return quantite;
    }

    @Override
    public String toString() {
        return "LigneDeCommande{" +
                "eau=" + eau +
                ", quantite=" + quantite +
                '}';
    }
}
