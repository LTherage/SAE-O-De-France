package fr.univartois.butinfo.sae.model;

/**
 * La classe PaiementSimple représente un paiement simple et implémente le traitement du paiement.
 */
public class PaiementSimple extends Paiement implements TraitementPaiement {

    /**
     * Exécute le paiement.
     *
     * @param p le paiement à exécuter
     */
    @Override
    public void executePaiement(Paiement p) {

    }

    /**
     * Effectue le remboursement du paiement.
     *
     * @param p le paiement à rembourser
     */
    @Override
    public void remboursement(Paiement p) {

    }
}