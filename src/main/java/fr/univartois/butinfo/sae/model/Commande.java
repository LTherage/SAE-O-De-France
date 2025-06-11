package fr.univartois.butinfo.sae.model;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.Objects;

/**
 * Le type Commande.
 */
public class Commande implements RemisesPossibles {
    private final int id;


    private static int nextId = 0;
    private final ObservableList<LigneDeCommande> lignesDeCommande;
    private final Client client;

    /**
     * Instantie une nouvelle commande.
     *
     * @param client le client de la commande
     */
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

    /**
     * le montant total de la commande après application de la remise.
     *
     * @return le montant total de la commande après application de la remise
     */
    public double montant() {
        return montantTotal() - montantDeLaRemise();
    }

    /**
     *
     *
     * @return le nombre de bouteilles gratuites
     */
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

    /**
     * le nombre de bouteilles gratuites en fonction du bloc.
     *
     * @param bloc le bloc de bouteilles
     * @return le nombre de bouteilles gratuites
     */
    private int nombreBouteillesGratuites(int bloc) {
        return lignesDeCommande.stream().reduce(0, (nb, ligne) -> nb + (ligne.getQuantite() / bloc), Integer::sum);
    }

    /**
     * Ajoute une ligne de commande.
     *
     * @param eau l'objet eau
     * @param quantite la quantite de l'eau
     */
    public void addLigneCommande(Eau eau, int quantite) {
        lignesDeCommande.add(new LigneDeCommande(eau, quantite));
    }

    /**
     * Mettre à jour une ligne de commande.
     *
     * @param index l'indice de la ligne de commande à mettre à jour
     * @param quantite la nouvelle quantité de l'eau
     */
    void updateLigneCommande(int index, int quantite) {
        LigneDeCommande ligneDeCommande = lignesDeCommande.remove(index);
        lignesDeCommande.add(new LigneDeCommande(ligneDeCommande.getEau(), quantite));
    }

    /**
     * Recupere le client de la commande.
     *
     * @return le client de la commande
     */
    public Client getClient() {
        return client;
    }

    /**
     * Recupere l'id de la commande.
     *
     * @return l'id de la commande
     */
    public int getId() {
        return id;
    }

    /**
     * Recupere les lignes de commande de la commande.
     *
     * @return les lignes de commande de la commande
     */
    public ObservableList<LigneDeCommande> getLignesDeCommande() {
        return lignesDeCommande;
    }

    /**
     * Vérifie si l'objet en paramètre est égal à l'objet courant.
     *
     * @param o l'objet ClientEtablissementPublic en paramètre.
     * @return Si l'objet passé en paramètre est égal à l'objet courant.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Commande commande = (Commande) o;
        return id == commande.id && Objects.equals(lignesDeCommande, commande.lignesDeCommande) && Objects.equals(client, commande.client);
    }
}
