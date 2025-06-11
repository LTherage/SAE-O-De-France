package fr.univartois.butinfo.sae.model;

import java.util.Date;
import java.util.Objects;

public abstract class Client {
    protected int code;
    protected Date dateInscription;
    protected Adresse adresse;
    protected String telephone;
    protected String email;
    protected int pointsFidelite;

    public abstract void ajoutPointsFidelite(double achat);

    public abstract String getTypeClient();

    public int getCode() {
        return code;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public int getPointsFidelite() {
        return pointsFidelite;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return code == client.code && pointsFidelite == client.pointsFidelite && Objects.equals(dateInscription, client.dateInscription) && Objects.equals(adresse, client.adresse) && Objects.equals(telephone, client.telephone) && Objects.equals(email, client.email);
    }


}
