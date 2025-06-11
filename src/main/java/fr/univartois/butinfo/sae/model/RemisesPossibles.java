package fr.univartois.butinfo.sae.model;

/**
 * Interface définissant les méthodes pour appliquer des remises et obtenir le nombre de bouteilles gratuites.
 */
public interface RemisesPossibles {
    /**
     * Calcule le montant de la remise applicable.
     *
     * @return le montant de la remise
     */
    double montantDeLaRemise();

    /**
     * Calcule le nombre de bouteilles gratuites accordées.
     *
     * @return le nombre de bouteilles gratuites
     */
    int nombreBouteillesGratuites();
}