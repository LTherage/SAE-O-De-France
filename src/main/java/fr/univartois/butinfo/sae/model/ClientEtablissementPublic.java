package fr.univartois.butinfo.sae.model;

import java.util.Objects;

import static fr.univartois.butinfo.sae.model.TypeClient.ETABLISSEMENT_PUBLIC;

public class ClientEtablissementPublic extends Client {
    private String nom;
    private TypeEtablissement type;

    private final TypeClient typeClient = ETABLISSEMENT_PUBLIC;

    @Override
    public void ajoutPointsFidelite(double achat) {
        int nbTranches = Double.valueOf(achat).intValue() / 500;
        pointsFidelite += nbTranches * 10;
    }

    @Override
    public String getTypeClient() {
        return typeClient.toString();
    }

    @Override
    public String toString() {
        return "ClientEtablissementPublic{" +
                "type=" + type +
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
        ClientEtablissementPublic that = (ClientEtablissementPublic) o;
        return Objects.equals(nom, that.nom) && type == that.type && typeClient == that.typeClient;
    }
}
