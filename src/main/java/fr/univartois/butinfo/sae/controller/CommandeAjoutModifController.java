package fr.univartois.butinfo.sae.controller;

import fr.univartois.butinfo.sae.model.Client;
import fr.univartois.butinfo.sae.model.Commande;
import fr.univartois.butinfo.sae.model.StockEau;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class CommandeAjoutModifController {

    @FXML
    private ComboBox<Client> clientComboBox;

    @FXML
    private ComboBox<StockEau> comboStockEau;

    @FXML
    private Button boutonValider;
    @FXML
    private Button boutonAnnuler;

    private ObservableList<Commande> commandes;
    private ObservableList<Client> clients;
    private ObservableList<StockEau> stocks;

    private Commande commande;

    public void setCommandes(ObservableList<Commande> commandes) {
        this.commandes = commandes;
    }

    public void setClients(ObservableList<Client> clients) {
        this.clients = clients;
        clientComboBox.setItems(clients);
    }

    public void setStocks(ObservableList<StockEau> stocks) {
        this.stocks = stocks;
        comboStockEau.setItems(stocks);
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
        if (commande != null) {
            clientComboBox.setValue(commande.getClient());
            // Si besoin : initialiser comboStockEau avec la ligne ou autre selon ton modèle
        }
    }

    @FXML
    private void onValider() {
        if (commande == null) {
            // Création nouvelle commande
            Commande nouvelleCommande = new Commande(clientComboBox.getValue());
            commandes.add(nouvelleCommande);
        } else {
            // Modifier commande existante (à adapter selon besoins)
        }
        fermerFenetre();
    }

    @FXML
    private void onAnnuler() {
        fermerFenetre();
    }

    private void fermerFenetre() {
        Stage stage = (Stage) clientComboBox.getScene().getWindow();
        stage.close();
    }
}
