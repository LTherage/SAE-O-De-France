package fr.univartois.butinfo.sae.model;

import java.util.Objects;

/**
 * La classe Paiement représente un paiement effectué avec un certain montant et une méthode de paiement.
 */
public class Paiement {
    /**
     * Le montant du paiement.
     */
    private double montant;

    /**
     * La méthode de paiement utilisée.
     */
    private MethodePaiement methodePaiement;

    /**
     * Vérifie si deux paiements sont égaux.
     *
     * @param o l'objet à comparer
     * @return true si les paiements sont égaux, false sinon
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Paiement paiement = (Paiement) o;
        return Double.compare(montant, paiement.montant) == 0 && Objects.equals(methodePaiement, paiement.methodePaiement);
    }
}