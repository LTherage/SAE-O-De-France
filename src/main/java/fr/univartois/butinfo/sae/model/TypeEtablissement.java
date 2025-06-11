package fr.univartois.butinfo.sae.model;

/**
 * L'énumération TypeEtablissement représente les différents types d'établissements publics.
 */
public enum TypeEtablissement {
    /**
     * Établissement Public à caractère Industriel et Commercial.
     */
    EPIC("EPIC"),
    /**
     * Établissement Public Administratif.
     */
    EPA("EPA"),
    /**
     * Établissement Public de Santé, de Coopération et de Territoire.
     */
    EPSCT("EPSCT");

    /**
     * Libellé du type d'établissement.
     */
    private final String val;

    /**
     * Constructeur de l'énumération TypeEtablissement.
     *
     * @param val le libellé du type d'établissement
     */
    TypeEtablissement(String val) {
        this.val = val;
    }

    /**
     * Retourne le libellé du type d'établissement.
     *
     * @return le libellé du type d'établissement
     */
    @Override
    public String toString() {
        return val;
    }
}