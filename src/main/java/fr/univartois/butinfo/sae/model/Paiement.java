package fr.univartois.butinfo.sae.model;

import java.util.Objects;

public class Paiement {
    private double montant;
    private MethodePaiement methodePaiement;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Paiement paiement = (Paiement) o;
        return Double.compare(montant, paiement.montant) == 0 && Objects.equals(methodePaiement, paiement.methodePaiement);
    }
}
