package fr.univartois.butinfo.sae.model;

import java.util.Objects;

import static fr.univartois.butinfo.sae.model.TypeClient.ENTREPRISE;

public class ClientEntreprise extends Client{

    private String nom;
    private String prenom;

    private final TypeClient typeClient = ENTREPRISE;

    @Override
    public void ajoutPointsFidelite(double achat) {
        int nbTranches = Double.valueOf(achat).intValue() / 1000;
        pointsFidelite += nbTranches * 10;
    }

    @Override
    public String getTypeClient() {
        return typeClient.toString();
    }

    @Override
    public String toString() {
        return "ClientEntreprise{" +
                "prenom='" + prenom + '\'' +
                ", code=" + code +
                ", dateInscription=" + dateInscription +
                ", adresse=" + adresse +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", pointsFidelite=" + pointsFidelite +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ClientEntreprise that = (ClientEntreprise) o;
        return Objects.equals(nom, that.nom) && Objects.equals(prenom, that.prenom) && typeClient == that.typeClient;
    }
}
