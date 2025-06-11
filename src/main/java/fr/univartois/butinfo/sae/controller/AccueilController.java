package fr.univartois.butinfo.sae.controller;

import fr.univartois.butinfo.sae.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Contrôleur JavaFX pour la page d'accueil de l'application.
 * Permet la navigation vers les différentes vues (clients, commandes, stock d'eau, accueil).
 */
public class AccueilController {

    /**
     * Bouton permettant d'accéder à la gestion des clients.
     */
    @FXML
    private Button connexion;

    /**
     * Change la vue affichée dans la fenêtre principale.
     *
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
     * Gère le clic sur le bouton "Clients" et affiche la vue correspondante.
     */
    @FXML
    private void client() {
        System.out.println("Bouton : Application pour les clients");
        Stage stage = (Stage) connexion.getScene().getWindow();
        changerVue(stage, "view/Client-view.fxml");
    }

    /**
     * Gère le clic sur le bouton "Stock d'eau" et affiche la vue correspondante.
     */
    @FXML
    private void StockEau() {
        System.out.println("Bouton : Application pour les clients");
        Stage stage = (Stage) connexion.getScene().getWindow();
        changerVue(stage, "view/StockEauView.fxml");
    }

    /**
     * Gère le clic sur le bouton "Commandes" et affiche la vue correspondante.
     */
    @FXML
    private void commande() {
        Stage stage = (Stage) connexion.getScene().getWindow();
        changerVue(stage, "view/Commande-view.fxml");
    }

    /**
     * Gère le retour à la page d'accueil lors du clic sur le bouton correspondant.
     *
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