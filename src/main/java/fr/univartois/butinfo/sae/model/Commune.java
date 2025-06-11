package fr.univartois.butinfo.sae.model;

import java.util.Objects;

public class Commune {
    private String code;
    private String nom;
    private String departement;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Commune commune = (Commune) o;
        return Objects.equals(code, commune.code) && Objects.equals(nom, commune.nom) && Objects.equals(departement, commune.departement);
    }



    public Commune(String code, String nom, String departement) {
        this.code = code;
        this.nom = nom;
        this.departement = departement;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    @Override
    public String toString() {
        return "Commune{" +
                "code='" + code + '\'' +
                ", nom='" + nom + '\'' +
                ", departement='" + departement + '\'' +
                '}';
    }
}
