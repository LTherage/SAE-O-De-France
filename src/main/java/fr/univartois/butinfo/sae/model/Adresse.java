package fr.univartois.butinfo.sae.model;

import java.util.Objects;

public class Adresse {
    private int numero;
    private String voie;
    private Commune commune;

    public Adresse(int numero, String voie, Commune commune) {
        this.numero = numero;
        this.voie = voie;
        this.commune = commune;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getVoie() {
        return voie;
    }

    public void setVoie(String voie) {
        this.voie = voie;
    }

    public Commune getCommune() {
        return commune;
    }

    public void setCommune(Commune commune) {
        this.commune = commune;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Adresse adresse = (Adresse) o;
        return numero == adresse.numero && Objects.equals(voie, adresse.voie) && Objects.equals(commune, adresse.commune);
    }



    @Override
    public String toString() {
        return "Adresse{" +
                "numero=" + numero +
                ", voie='" + voie + '\'' +
                ", commune=" + commune +
                '}';
    }
}
