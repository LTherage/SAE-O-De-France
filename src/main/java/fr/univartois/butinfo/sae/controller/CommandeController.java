package fr.univartois.butinfo.sae.controller;

import fr.univartois.butinfo.sae.HelloApplication;
import fr.univartois.butinfo.sae.model.Client;
import fr.univartois.butinfo.sae.model.Commande;
import fr.univartois.butinfo.sae.model.StockEau;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class CommandeController {

    @FXML
    private ListView<Commande> listeCommandes;

    @FXML
    private Label labelNom;

    @FXML
    private Label labelCommande;

    @FXML
    private Label labelAdresse;

    // Utilisation des listes statiques du contrôleur principal
    private final ObservableList<Commande> commandes = AccueilController.commandesAll;
    private final ObservableList<Client> clients = AccueilController.clientsAll;
    private final ObservableList<StockEau> stocks = AccueilController.stocksAll;

    @FXML
    public void initialize() {
        listeCommandes.setItems(commandes);

        listeCommandes.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                if (newVal.getClient() != null) {
                    labelNom.setText(newVal.getClient().toString());
                } else {
                    labelNom.setText("-");
                }
                labelCommande.setText(String.valueOf(newVal.getId()));
                if (newVal.getClient() != null && newVal.getClient().getAdresse() != null) {
                    labelCommande.setText(String.valueOf(newVal.getId()));
                } else {
                    labelCommande.setText("-");
                }
            } else {
                labelNom.setText("-");
                labelCommande.setText("-");
                labelAdresse.setText("-");
            }
        });
    }

    @FXML
    private void ajouterCommande() {
        ouvrirVueCommande(null);
    }

    @FXML
    private void modifierCommande() {
        Commande selected = listeCommandes.getSelectionModel().getSelectedItem();
        if (selected != null) {
            ouvrirVueCommande(selected);
        }
    }

    @FXML
    private void supprimerCommande() {
        Commande selected = listeCommandes.getSelectionModel().getSelectedItem();
        if (selected != null) {
            commandes.remove(selected);
        }
    }

    private void ouvrirVueCommande(Commande commande) {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("view/CommandeAjoutModif.fxml"));
            Parent root = loader.load();

            CommandeAjoutModifController controller = loader.getController();

            // Passer les listes statiques à l'autre contrôleur
            controller.setCommandes(commandes);
            controller.setClients(clients);
            controller.setStocks(stocks);

            controller.setCommande(commande);

            Stage stage = new Stage();
            stage.setTitle((commande == null ? "Ajouter" : "Modifier") + " une commande");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onClickButtonMainPage() {
        // code pour revenir à la page principale
    }

    @FXML
    private void quitterApp() {
        System.exit(0);
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

}
