package fr.univartois.butinfo.sae.model;

public enum Categorie {
    EAU_PLATE("eau plate"), EAU_GAZEUSE("eau gazeuse");
    private final String cat;

    Categorie(String cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        return cat;
    }



}
