package fr.univartois.butinfo.sae.controller;

import fr.univartois.butinfo.sae.model.Client;
import fr.univartois.butinfo.sae.model.Commande;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

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

}
