package fr.univartois.butinfo.sae.model;

/**
 * Interface définissant les méthodes pour traiter un paiement et effectuer un remboursement.
 */
public interface TraitementPaiement {
    /**
     * Exécute le paiement.
     *
     * @param p le paiement à exécuter
     */
    void executePaiement(Paiement p);

    /**
     * Effectue le remboursement d'un paiement.
     *
     * @param p le paiement à rembourser
     */
    void remboursement(Paiement p);
}