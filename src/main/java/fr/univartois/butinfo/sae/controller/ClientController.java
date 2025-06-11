package fr.univartois.butinfo.sae.controller;

import fr.univartois.butinfo.sae.model.Client;
import fr.univartois.butinfo.sae.model.ClientParticulier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class ClientController {

    @FXML
    private ListView<Client> listeClients;

    @FXML
    private Label labelNom;

    @FXML
    private Label labelType;

    @FXML
    private Label labelPoints;

    private final ObservableList<Client> clients = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

    }

    @FXML
    public void ajouterClient() {
        //
    }

    @FXML void modifierClient(){
        //
    }





}
