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

/**
 * Contrôleur JavaFX pour la gestion des commandes.
 * Permet d'afficher, ajouter, modifier, supprimer des commandes et de naviguer entre les vues.
 */
public class CommandeController {

    /** ListView affichant la liste des clients associés aux commandes. */
    @FXML
    private ListView<Client> listeCommandes;

    /** Label affichant le nom du client sélectionné. */
    @FXML
    private Label labelNom;

    /** Label affichant les informations de la commande sélectionnée. */
    @FXML
    private Label labelCommande;

    /** Label affichant l'adresse du client sélectionné. */
    @FXML
    private Label labelAdresse;

    /** Liste observable contenant les commandes. */
    private final ObservableList<Commande> commandes = FXCollections.observableArrayList();

    /**
     * Initialise le contrôleur après le chargement du FXML.
     */
    @FXML
    public void initialize() {
        // À compléter selon la logique métier
    }

    /**
     * Ouvre une fenêtre pour ajouter une nouvelle commande.
     */
    @FXML
    public void ajouterCommande() {
        // À implémenter
    }

    /**
     * Permet de modifier la commande sélectionnée.
     */
    @FXML
    void modifierCommande() {
        // À implémenter
    }

    /**
     * Supprime la commande sélectionnée de la liste.
     */
    @FXML
    private void supprimerCommande() {
        // À implémenter
    }

    /**
     * Ferme l'application.
     */
    @FXML
    private void quitterApp() {
        System.exit(0);
    }

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