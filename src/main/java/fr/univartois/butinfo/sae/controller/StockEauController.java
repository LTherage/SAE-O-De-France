package fr.univartois.butinfo.sae.controller;

import fr.univartois.butinfo.sae.HelloApplication;
import fr.univartois.butinfo.sae.model.StockEau;
import fr.univartois.butinfo.sae.model.Entrepot;
import fr.univartois.butinfo.sae.model.Adresse;
import fr.univartois.butinfo.sae.model.Commune;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Contrôleur JavaFX pour la gestion des stocks d'eau.
 * Permet d'afficher, ajouter, modifier, supprimer des stocks et de consulter leurs détails.
 */
public class StockEauController {
    /** ListView affichant la liste des stocks d'eau. */
    @FXML
    private ListView<StockEau> waterListView;
    /** Label affichant la catégorie du stock sélectionné. */
    @FXML
    private Label categorieLabel;
    /** Label affichant l'entrepôt du stock sélectionné. */
    @FXML
    private Label entrepotLabel;
    /** Label affichant l'adresse de l'entrepôt du stock sélectionné. */
    @FXML
    private Label adresseLabel;
    /** Label affichant la commune de l'entrepôt du stock sélectionné. */
    @FXML
    private Label communeLabel;
    /** Label affichant la quantité du stock sélectionné. */
    @FXML
    private Label quantiteLabel;
    /** Liste observable contenant les stocks d'eau. */
    private final ObservableList<StockEau> stockList = AccueilController.stocksAll;

    /**
     * Initialise le contrôleur après le chargement du FXML.
     * Configure la ListView et l'affichage des détails.
     */
    @FXML
    public void initialize() {
        waterListView.setItems(stockList);
        trierStocks();

        // Cellule personnalisée pour afficher plus d'infos dans la liste
        waterListView.setCellFactory(list -> new ListCell<>() {
            @Override
            protected void updateItem(StockEau item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    Entrepot entrepot = item.getEntrepot();
                    String entrepotInfo = (entrepot != null) ? entrepot.getNom() + " (Code: " + entrepot.getCode() + ")" : "Entrepôt inconnu";
                    setText(item.getCategorie() + " - " + entrepotInfo + " - Qté: " + item.getQuantite());
                }
            }
        });

        // Affiche les détails quand on sélectionne un élément dans la liste
        waterListView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> afficherDetails(newSelection)
        );
    }

    /**
     * Affiche les détails du stock sélectionné dans les labels.
     * @param stock Le stock sélectionné.
     */
    private void afficherDetails(StockEau stock) {
        if (stock != null) {
            categorieLabel.setText("Catégorie : " + stock.getCategorie());
            quantiteLabel.setText("Quantité : " + stock.getQuantite());

            Entrepot entrepot = stock.getEntrepot();
            if (entrepot != null) {
                entrepotLabel.setText("Entrepôt : " + entrepot.getNom() + " (Code: " + entrepot.getCode() + ")");

                Adresse adresse = entrepot.getAdresse();
                if (adresse != null) {
                    adresseLabel.setText("Adresse : " + adresse.getNumero() + " " + adresse.getVoie());

                    Commune commune = adresse.getCommune();
                    if (commune != null) {
                        communeLabel.setText("Commune : " + commune.getNom() + " (Code: " + commune.getCode() + "), Département : " + commune.getDepartement());
                    } else {
                        communeLabel.setText("Commune : inconnue");
                    }
                } else {
                    adresseLabel.setText("Adresse : inconnue");
                    communeLabel.setText("Commune : inconnue");
                }
            } else {
                entrepotLabel.setText("Entrepôt : inconnu");
                adresseLabel.setText("Adresse : inconnue");
                communeLabel.setText("Commune : inconnue");
            }
        } else {
            // Réinitialiser les labels si aucune sélection
            categorieLabel.setText("");
            entrepotLabel.setText("");
            adresseLabel.setText("");
            communeLabel.setText("");
            quantiteLabel.setText("");
        }
    }

    /**
     * Ajoute un nouveau stock d'eau et ouvre la fenêtre d'édition.
     */
    @FXML
    private void ajouterStock() {
        StockEau newStock = new StockEau();
        stockList.add(newStock);
        ouvrirFenetreStock(newStock);
        if (newStock.equals(new StockEau())) stockList.remove(newStock);
        trierStocks();
    }

    /**
     * Modifie le stock d'eau sélectionné en ouvrant la fenêtre d'édition.
     */
    @FXML
    private void modifierStock() {
        StockEau selected = waterListView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            ouvrirFenetreStock(selected);
        }
        trierStocks();
    }

    /**
     * Ouvre la fenêtre modale pour ajouter ou modifier un stock d'eau.
     * @param stock Le stock à éditer.
     */
    private void ouvrirFenetreStock(StockEau stock) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/StockEauAjout&ModifView.fxml"));
            Parent root = loader.load();

            StockEauAjoutModifController controller = loader.getController();
            controller.setStock(stock);

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Ajouter / Modifier un Stock d'eau");
            dialogStage.initOwner(waterListView.getScene().getWindow());
            dialogStage.initModality(Modality.WINDOW_MODAL); // bloque la fenêtre principale
            dialogStage.setScene(new Scene(root));
            dialogStage.showAndWait();

            waterListView.refresh();
            afficherDetails(stock); // mettre à jour l'affichage des détails après modif

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Supprime le stock d'eau sélectionné de la liste.
     */
    @FXML
    private void supprimerStock() {
        StockEau selected = waterListView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            stockList.remove(selected);
        }
        trierStocks();
    }

    /**
     * Change la vue affichée dans la fenêtre principale.
     * @param stage La fenêtre principale.
     * @param fxml  Le chemin du fichier FXML à charger.
     */
    public static void changerVue(Stage stage, String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource(fxml));
            Parent root = loader.load();
            stage.setScene(new Scene(root, 900, 540));
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement de " + fxml);
            e.printStackTrace();
        }
    }

    /**
     * Gère le retour à la page d'accueil lors du clic sur le bouton correspondant.
     * @param event L'événement de clic.
     */
    @FXML
    private void onClickButtonMainPage(ActionEvent event) {
        // Obtenir le bouton qui a déclenché l'événement
        Button button = (Button) event.getSource();
        // Obtenir la scène à partir du bouton
        Stage stage = (Stage) button.getScene().getWindow();
        changerVue(stage, "view/Accueil-view.fxml");
    }

    private void trierStocks() {
        stockList.sort((s1, s2) -> {
            // On trie d'abord par catégorie, on gère les valeurs nulles en mettant "" à la place
            String cat1 = s1.getCategorie() != null ? s1.getCategorie().toString() : "";
            String cat2 = s2.getCategorie() != null ? s2.getCategorie().toString() : "";
            int res = cat1.compareToIgnoreCase(cat2);
            if (res != 0) return res;

            // Puis par nom d'entrepôt si les catégories sont égales
            String nomEntrepot1 = s1.getEntrepot() != null ? s1.getEntrepot().getNom() : "";
            String nomEntrepot2 = s2.getEntrepot() != null ? s2.getEntrepot().getNom() : "";
            return nomEntrepot1.compareToIgnoreCase(nomEntrepot2);
        });
    }
}
