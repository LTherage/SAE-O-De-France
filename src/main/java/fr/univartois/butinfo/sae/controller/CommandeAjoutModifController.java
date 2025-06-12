package fr.univartois.butinfo.sae.controller;

import fr.univartois.butinfo.sae.model.Client;
import fr.univartois.butinfo.sae.model.Commande;
import fr.univartois.butinfo.sae.model.StockEau;
import fr.univartois.butinfo.sae.model.Eau;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CommandeAjoutModifController {

    @FXML
    private ComboBox<Client> clientComboBox;

    @FXML
    private ComboBox<String> categorieComboBox;

    @FXML
    private ComboBox<StockEau> comboStockEau;

    @FXML
    private ComboBox<Eau> eauComboBox;

    @FXML
    private TextField quantiteField;

    @FXML
    private Label quantiteMaxLabel;

    @FXML
    private Label stockDetailsLabel;

    @FXML
    private Label erreurLabel;

    @FXML
    private Button boutonValider;

    @FXML
    private Button boutonAnnuler;

    private ObservableList<Client> clients;
    private ObservableList<StockEau> stocks;
    private ObservableList<Eau> eauxPreenregistrees;

    private ObservableList<Commande> commandes;

    private int quantiteMax = 0;

    public void initData(ObservableList<Client> clients, ObservableList<StockEau> stocks,
                         ObservableList<Eau> eauxPreenregistrees, ObservableList<Commande> commandes) {
        this.clients = clients;
        this.stocks = stocks;
        this.eauxPreenregistrees = eauxPreenregistrees;
        this.commandes = commandes;

        clientComboBox.setItems(clients);

        ObservableList<String> categoriesDisponibles = FXCollections.observableArrayList();
        for (StockEau stock : stocks) {
            if (stock.getQuantite() > 0) {
                String cat = stock.getCategorie().toString();
                if (!categoriesDisponibles.contains(cat)) {
                    categoriesDisponibles.add(cat);
                }
            }
        }
        categorieComboBox.setItems(categoriesDisponibles);

        categorieComboBox.setOnAction(e -> filtrerStocksParCategorie());
        comboStockEau.setOnAction(e -> mettreAJourEauxEtQuantite());

        quantiteMaxLabel.setText("");
        stockDetailsLabel.setText("");
        erreurLabel.setText("");
    }

    private void filtrerStocksParCategorie() {
        String categorie = categorieComboBox.getValue();
        if (categorie == null) {
            comboStockEau.getItems().clear();
            eauComboBox.getItems().clear();
            quantiteMaxLabel.setText("");
            stockDetailsLabel.setText("");
            erreurLabel.setText("");
            return;
        }

        ObservableList<StockEau> stocksFiltres = FXCollections.observableArrayList();
        for (StockEau stock : stocks) {
            if (stock.getCategorie().toString().equals(categorie) && stock.getQuantite() > 0) {
                stocksFiltres.add(stock);
            }
        }
        comboStockEau.setItems(stocksFiltres);
        comboStockEau.getSelectionModel().clearSelection();

        eauComboBox.getItems().clear();
        quantiteMaxLabel.setText("");
        stockDetailsLabel.setText("");
        erreurLabel.setText("");
    }

    private void mettreAJourEauxEtQuantite() {
        StockEau stockSelectionne = comboStockEau.getValue();
        if (stockSelectionne == null) {
            eauComboBox.getItems().clear();
            quantiteMaxLabel.setText("");
            stockDetailsLabel.setText("");
            erreurLabel.setText("");
            return;
        }

        String categorie = stockSelectionne.getCategorie().toString();

        ObservableList<Eau> eauxFiltrees = FXCollections.observableArrayList();
        for (Eau eau : eauxPreenregistrees) {
            if (eau.getCategorie().equals(categorie)) {
                eauxFiltrees.add(eau);
            }
        }

        eauComboBox.getItems().clear();
        eauComboBox.setItems(eauxFiltrees);
        eauComboBox.getSelectionModel().clearSelection();

        quantiteMax = stockSelectionne.getQuantite();
        quantiteMaxLabel.setText("(max: " + quantiteMax + ")");

        String details = "Fournisseur: " + stockSelectionne.getEntrepot().getNom() + "\n" +
                "Catégorie: " + categorie + "\n" +
                "Quantité disponible: " + quantiteMax;
        stockDetailsLabel.setText(details);
        erreurLabel.setText("");
    }

    @FXML
    private void onValider() {
        erreurLabel.setText(""); // reset erreur

        Client client = clientComboBox.getValue();
        Eau eau = eauComboBox.getValue();
        String quantiteTexte = quantiteField.getText();

        if (client == null) {
            erreurLabel.setText("Veuillez sélectionner un client.");
            return;
        }
        if (eau == null) {
            erreurLabel.setText("Veuillez sélectionner une eau.");
            return;
        }
        if (quantiteTexte == null || quantiteTexte.isBlank()) {
            erreurLabel.setText("Veuillez saisir une quantité.");
            return;
        }

        int quantite;
        try {
            quantite = Integer.parseInt(quantiteTexte);
        } catch (NumberFormatException e) {
            erreurLabel.setText("La quantité doit être un nombre entier.");
            return;
        }

        if (quantite <= 0) {
            erreurLabel.setText("La quantité doit être strictement positive.");
            return;
        }
        if (quantite > quantiteMax) {
            erreurLabel.setText("La quantité ne peut pas dépasser la quantité maximale disponible (" + quantiteMax + ").");
            return;
        }

        Commande commande = new Commande(client);
        commande.addLigneCommande(eau, quantite);
        commandes.add(commande);

        // Fermer la fenêtre
        boutonValider.getScene().getWindow().hide();
    }

    @FXML
    private void onAnnuler() {
        boutonAnnuler.getScene().getWindow().hide();
    }
}
