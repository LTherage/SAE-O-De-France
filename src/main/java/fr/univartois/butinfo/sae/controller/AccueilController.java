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

public class AccueilController {

    @FXML
    private Button connexion;

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

    @FXML
    private void client() {
        System.out.println("Bouton : Application pour les clients");
        Stage stage = (Stage) connexion.getScene().getWindow();
        changerVue(stage, "view/Client-view.fxml");
    }

    @FXML
    private void StockEau() {
        System.out.println("Bouton : Application pour les clients");
        Stage stage = (Stage) connexion.getScene().getWindow();
        changerVue(stage, "view/StockEauView.fxml");
    }

    @FXML
    private void commande() {
        Stage stage = (Stage) connexion.getScene().getWindow();
        changerVue(stage, "view/Commande-view.fxml");
    }


    @FXML
    private void onClickButtonMainPage(ActionEvent event) {
        // Obtenir le bouton qui a déclenché l'événement
        Button button = (Button) event.getSource();
        // Obtenir la scène à partir du bouton
        Stage stage = (Stage) button.getScene().getWindow();
        changerVue(stage, "view/Accueil-view.fxml");
    }
}
