package fr.univartois.butinfo.sae.controller;

import fr.univartois.butinfo.sae.HelloApplication;
import fr.univartois.butinfo.sae.model.*;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    public static final ObservableList<Commande> commandesAll = FXCollections.observableArrayList();
    public static final ObservableList<Client> clientsAll = FXCollections.observableArrayList();
    public static final ObservableList<StockEau> stocksAll = FXCollections.observableArrayList();
    public static final ObservableList<Eau> eauxPreenregistrees = FXCollections.observableArrayList(
            new Eau("O-De-France", Categorie.EAU_PLATE.toString(), 0.85),
            new Eau("Bas-De-France", Categorie.EAU_PLATE.toString(), 0.85)
    );
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
            stage.setScene(new Scene(root));
            // Récupère les dimensions de l'écran disponible
            javafx.geometry.Rectangle2D screenBounds = javafx.stage.Screen.getPrimary().getVisualBounds();
            stage.setX(screenBounds.getMinX());
            stage.setY(screenBounds.getMinY());
            stage.setWidth(screenBounds.getWidth());
            stage.setHeight(screenBounds.getHeight());
            stage.show();
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
}