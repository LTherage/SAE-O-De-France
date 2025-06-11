package fr.univartois.butinfo.sae.model;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Commande implements RemisesPossibles {
    private final int id;


    private static int nextId = 0;
    private final ObservableList<LigneDeCommande> lignesDeCommande;
    private final Client client;

    public Commande(Client client) {
        this.id = nextId++;
        this.client = client;
        lignesDeCommande = new SimpleListProperty<>(FXCollections.observableArrayList());    }

    @Override
    public double montantDeLaRemise() {
        int reduce = 0;
        if ("Particulier".equals(client.getTypeClient())) {
            reduce = Math.min(client.getPointsFidelite() / 100, 10);
        }
        return montantTotal() * reduce;
    }

    private double montantTotal() {
        //double montant= 0;
        return lignesDeCommande.stream().reduce(0.0, (montant, e) -> montant += e.getQuantite(), Double::sum);
    }

    public double montant() {
        return montantTotal() - montantDeLaRemise();
    }

    @Override
    public int nombreBouteillesGratuites() {
        if ("Particulier".equals(client.getTypeClient()))
            return nombreBouteillesGratuites(12);
        if ("Établissement public".equals(client.getTypeClient()))
            return nombreBouteillesGratuites(60);
        if ("Entreprise".equals(client.getTypeClient()))
            return nombreBouteillesGratuites(120);
        return 0;
    }

    private int nombreBouteillesGratuites(int bloc) {
        return lignesDeCommande.stream().reduce(0, (nb, ligne) -> nb + (ligne.getQuantite() / bloc), Integer::sum);
    }

    public void addLigneCommande(Eau eau, int quantite) {
        lignesDeCommande.add(new LigneDeCommande(eau, quantite));
    }

    void updateLigneCommande(int index, int quantite) {
        LigneDeCommande ligneDeCommande = lignesDeCommande.remove(index);
        lignesDeCommande.add(new LigneDeCommande(ligneDeCommande.getEau(), quantite));
    }

    public Client getClient() {
        return client;
    }

    public int getId() {
        return id;
    }

    public ObservableList<LigneDeCommande> getLignesDeCommande() {
        return lignesDeCommande;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Commande commande = (Commande) o;
        return id == commande.id && Objects.equals(lignesDeCommande, commande.lignesDeCommande) && Objects.equals(client, commande.client);
    }
}
