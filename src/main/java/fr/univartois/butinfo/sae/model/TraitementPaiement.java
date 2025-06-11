package fr.univartois.butinfo.sae.model;

public interface TraitementPaiement {
    void executePaiement(Paiement p);
    void remboursement(Paiement p);
}
