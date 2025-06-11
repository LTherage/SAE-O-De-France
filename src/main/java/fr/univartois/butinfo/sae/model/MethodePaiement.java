package fr.univartois.butinfo.sae.model;

/**
 * Classe abstraite représentant une méthode de paiement.
 * Les classes concrètes doivent implémenter les méthodes de paiement et de remboursement.
 */
public abstract class MethodePaiement {

    /**
     * Effectue le paiement d'un montant donné.
     *
     * @param montant le montant à payer
     */
    abstract void payer(double montant);

    /**
     * Effectue le remboursement d'un montant donné.
     *
     * @param montant le montant à rembourser
     */
    abstract void rembourser(double montant);
}