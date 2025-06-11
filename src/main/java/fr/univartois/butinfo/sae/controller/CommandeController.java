package fr.univartois.butinfo.sae.controller;

import fr.univartois.butinfo.sae.HelloApplication;
import fr.univartois.butinfo.sae.model.Client;
import fr.univartois.butinfo.sae.model.Commande;
import javafx.collections.FXCollections;
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
    private ListView<Client> listeCommandes;


    @FXML
    private Label labelNom;

    @FXML
    private Label labelCommande;

    @FXML
    private Label labelAdresse;

    private final ObservableList<Commande> commandes = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

    }

    @FXML
    public void ajouterCommande() {
        //
    }

    @FXML void modifierCommande(){
        //
    }

    @FXML
    private void supprimerCommande() {

    }

    @FXML
    private void quitterApp(){
        System.exit(0);
    }

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
    private void onClickButtonMainPage(ActionEvent event) {
        // Obtenir le bouton qui a déclenché l'événement
        Button button = (Button) event.getSource();
        // Obtenir la scène à partir du bouton
        Stage stage = (Stage) button.getScene().getWindow();
        changerVue(stage, "view/Accueil-view.fxml");
    }

}
