package fr.univartois.butinfo.sae.model;

/**
 * Enum Categorie.
 */
public enum Categorie {
    /**
     * l'eau plate.
     */
    EAU_PLATE("eau plate"),
    /**
     * l'eau gazeuse.
     */
    EAU_GAZEUSE("eau gazeuse");
    private final String cat;

    /**
     * Constructeur de la catégorie.
     *
     * @param cat la catégorie de l'eau
     */
    Categorie(String cat) {
        this.cat = cat;
    }

    /**
     * Permet de récupérer la catégorie de l'eau.
     *
     *
     * @return une chaîne de caractères représentant la catégorie de l'eau
     */
    @Override
    public String toString() {
        return cat;
    }



}
