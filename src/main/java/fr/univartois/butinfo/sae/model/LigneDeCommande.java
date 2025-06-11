package fr.univartois.butinfo.sae.model;

import java.util.Objects;

/**
 * Représente une ligne de commande, c'est-à-dire une quantité d'une eau spécifique dans une commande.
 */
public class LigneDeCommande {
    /**
     * L'eau concernée par la ligne de commande.
     */
    private final Eau eau;
    /**
     * Le nombre de bouteilles d'eau.
     */
    private final int quantite;

    /**
     * Construit une nouvelle ligne de commande.
     *
     * @param eau l'eau concernée
     * @param quantite le nombre de bouteilles d'eau
     */
    public LigneDeCommande(Eau eau, int quantite) {
        this.eau = eau;
        this.quantite = quantite;
    }

    /**
     * Vérifie si deux lignes de commande sont égales.
     *
     * @param o l'objet à comparer
     * @return true si les deux lignes de commande sont égales, false sinon
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LigneDeCommande that = (LigneDeCommande) o;
        return quantite == that.quantite && Objects.equals(eau, that.eau);
    }

    /**
     * Retourne l'eau de la ligne de commande.
     *
     * @return l'eau concernée
     */
    public Eau getEau() {
        return eau;
    }

    /**
     * Retourne la quantité de bouteilles d'eau.
     *
     * @return la quantité de bouteilles
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * Retourne une représentation textuelle de la ligne de commande.
     *
     * @return une chaîne représentant la ligne de commande
     */
    @Override
    public String toString() {
        return "LigneDeCommande{" +
                "eau=" + eau +
                ", quantite=" + quantite +
                '}';
    }
}