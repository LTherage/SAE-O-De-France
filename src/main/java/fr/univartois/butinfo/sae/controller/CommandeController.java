package fr.univartois.butinfo.sae.controller;

import fr.univartois.butinfo.sae.HelloApplication;
import fr.univartois.butinfo.sae.model.Client;
import fr.univartois.butinfo.sae.model.Commande;
import fr.univartois.butinfo.sae.model.Eau;
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

    // Utilisation des listes statiques du contrôleur principal
    private final ObservableList<Commande> commandes = AccueilController.commandesAll;
    private final ObservableList<Client> clients = AccueilController.clientsAll;
    private final ObservableList<StockEau> stocks = AccueilController.stocksAll;
    private final ObservableList<Eau> eauxPreenregistrees = AccueilController.eauxPreenregistrees;


    @FXML
    public void initialize() {
        listeCommandes.setItems(commandes);

        listeCommandes.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            System.out.println(newVal.getClient() + " " + newVal.getId() + " " + newVal.getClient().getAdresse());
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
