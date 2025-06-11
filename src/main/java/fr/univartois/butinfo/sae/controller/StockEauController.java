package fr.univartois.butinfo.sae.controller;

import fr.univartois.butinfo.sae.model.StockEau;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class StockEauController {

    @FXML
    private ListView<StockEau> waterListView;
    @FXML
    private Label categorieLabel;
    @FXML
    private Label entrepotLabel;
    @FXML
    private Label quantiteLabel;

    private final ObservableList<StockEau> stockList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        waterListView.setItems(stockList);
        waterListView.setCellFactory(list -> new ListCell<>() {
            @Override
            protected void updateItem(StockEau item, boolean empty) {
                super.updateItem(item, empty);
                setText((empty || item == null) ? null : item.getCategorie() + " - " + item.getEntrepot());
            }
        });

        waterListView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> afficherDetails(newSelection));
    }

    private void afficherDetails(StockEau stock) {
        if (stock != null) {
            categorieLabel.setText("Catégorie : " + stock.getCategorie());
            entrepotLabel.setText("Entrepôt : " + stock.getEntrepot());
            quantiteLabel.setText("Quantité : " + stock.getQuantite());
        } else {
            categorieLabel.setText("");
            entrepotLabel.setText("");
            quantiteLabel.setText("");
        }
    }

    @FXML
    private void ajouterStock() {
        return;
    }

    @FXML
    private void modifierStock() {
        return;
    }

    @FXML
    private void supprimerStock() {
        StockEau selected = waterListView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            stockList.remove(selected);
        }
    }

    public void setStockList(ObservableList<StockEau> list) {
        stockList.setAll(list);
    }
}
