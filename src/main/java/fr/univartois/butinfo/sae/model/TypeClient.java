package fr.univartois.butinfo.sae.model;

/**
 * L'énumération TypeClient représente les différents types de clients possibles.
 */
public enum TypeClient {

    /**
     * Client particulier.
     */
    PARTICULIER("Particulier"),
    /**
     * Client entreprise.
     */
    ENTREPRISE("Entreprise"),
    /**
     * Client établissement public.
     */
    ETABLISSEMENT_PUBLIC("Établissement public");

    /**
     * Libellé du type de client.
     */
    private final String val;

    /**
     * Constructeur de l'énumération TypeClient.
     *
     * @param val le libellé du type de client
     */
    TypeClient(String val) {
        this.val = val;
    }

    /**
     * Retourne le libellé du type de client.
     *
     * @return le libellé du type de client
     */
    @Override
    public String toString() {
        return val;
    }
}