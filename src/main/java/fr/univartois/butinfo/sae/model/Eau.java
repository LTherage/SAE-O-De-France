package fr.univartois.butinfo.sae.model;

import java.util.Objects;

public class Eau {
    private int id;
    private String marque;
    private String categorie;
    private double prix;

    private static int nextId = 0;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Eau eau = (Eau) o;
        return id == eau.id && Double.compare(prix, eau.prix) == 0 && Objects.equals(marque, eau.marque) && Objects.equals(categorie, eau.categorie);
    }

    public Eau(String marque, String categorie, double prix) {
        this.id = nextId++;
        this.marque = marque;
        this.categorie = categorie;
        this.prix = prix;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Eau{" +
                "id=" + id +
                ", marque='" + marque + '\'' +
                ", categorie='" + categorie + '\'' +
                ", prix=" + prix +
                '}';
    }
}
