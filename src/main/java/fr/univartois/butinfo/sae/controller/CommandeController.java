package fr.univartois.butinfo.sae.controller;

import fr.univartois.butinfo.sae.HelloApplication;
import fr.univartois.butinfo.sae.model.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class CommandeController {

    @FXML
    private ListView<Commande> listeCommandes;

    @FXML
    private Label labelClient;

    @FXML
    private Label labelCommande;

    @FXML
    private Label labelLigneDeCommande;

    // Utilisation des listes statiques du contrôleur principal
    private final ObservableList<Commande> commandes = AccueilController.commandesAll;
    private final ObservableList<Client> clients = AccueilController.clientsAll;
    private final ObservableList<StockEau> stocks = AccueilController.stocksAll;
    private final ObservableList<Eau> eauxPreenregistrees = AccueilController.eauxPreenregistrees;


    @FXML
    public void initialize() {
        listeCommandes.setItems(commandes);

        // Cellule personnalisée pour afficher plus d'infos dans la liste
        listeCommandes.setCellFactory(list -> new ListCell<>() {
            @Override
            protected void updateItem(Commande item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    String text = "ID: " + item.getId() + ", Client: " + (item.getClient() != null ? item.getClient().getTypeClient() : "Aucun client");
                    setText(text);
                }
            }
        });

        listeCommandes.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal.getClient() != null) {
                labelClient.setText(newVal.getClient().toString());
            } else {
                labelClient.setText("-");
            }




            if (newVal.getLignesDeCommande() != null && !newVal.getLignesDeCommande().isEmpty()) {
                String str = "";
                for (LigneDeCommande ligne : newVal.getLignesDeCommande()) {
                    str = str + ligne.toString() + "\n";
                }
                labelLigneDeCommande.setText(str);
            } else {
                labelLigneDeCommande.setText("-");
            }

            labelCommande.setText(String.valueOf(newVal.getId()));
            if (newVal.getClient() != null && newVal.getClient().getAdresse() != null) {
                labelCommande.setText(String.valueOf(newVal.getId()));
            } else {
                labelCommande.setText("-");
            }
        });
    }

    @FXML
    private void ajouterCommande() {
        ouvrirVueCommande();
    }

    @FXML
    private void supprimerCommande() {
        Commande selected = listeCommandes.getSelectionModel().getSelectedItem();
        if (selected != null) {
            commandes.remove(selected);
        }
    }

    private void ouvrirVueCommande() {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("view/CommandeAjoutModif.fxml"));
            Parent root = loader.load();

            CommandeAjoutModifController controller = loader.getController();

            // Récupérer la liste des eaux enregistrées (à adapter selon ta structure)

            // Si on ajoute une commande, on crée un nouvel objet

            // Injecter les données dans le contrôleur
            controller.initData(clients, stocks, eauxPreenregistrees, commandes);

            Stage stage = new Stage();
            stage.setTitle("Ajouter une commande");
            stage.setScene(new Scene(root));
            stage.initOwner(labelClient.getScene().getWindow());
            stage.initModality(Modality.WINDOW_MODAL);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onClickButtonMainPage() {
        // code pour revenir à la page principale
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
            stage.setScene(new Scene(root));
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
