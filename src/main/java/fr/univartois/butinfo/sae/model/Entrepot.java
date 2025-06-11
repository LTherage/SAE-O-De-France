package fr.univartois.butinfo.sae.model;

import java.util.Objects;

public class Entrepot {
    private int code;
    private String nom;
    private Adresse adresse;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Entrepot entrepot = (Entrepot) o;
        return code == entrepot.code && Objects.equals(nom, entrepot.nom) && Objects.equals(adresse, entrepot.adresse);
    }

    public Entrepot(int code, String nom, Adresse adresse) {
        this.code = code;
        this.nom = nom;
        this.adresse = adresse;
    }

    public int getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Entrepot{" +
                "code=" + code +
                ", nom='" + nom + '\'' +
                ", adresse=" + adresse +
                '}';
    }

	public boolean compareId(Entrepot entrepot2) {
        return code==entrepot2.code;
	}
}
