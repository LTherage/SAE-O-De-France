package fr.univartois.butinfo.sae.controller;

import fr.univartois.butinfo.sae.HelloApplication;
import fr.univartois.butinfo.sae.model.*;
import javafx.collections.FXCollections;
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
import javafx.stage.Stage;

import java.io.IOException;

public class ClientController {

    @FXML
    private ListView<Client> listeClients;

    @FXML
    private Label labelInfo;

    private final ObservableList<Client> clients = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        listeClients.setItems(clients);

        listeClients.setCellFactory(lv -> new ListCell<>() {
            @Override
            protected void updateItem(Client client, boolean empty) {
                super.updateItem(client, empty);
                if (empty || client == null) {
                    setText(null);
                } else {
                    switch (client.getTypeClient()) {
                        case "Particulier" -> {
                            ClientParticulier cp = (ClientParticulier) client;
                            setText(cp.getNom() + " " + cp.getPrenom() + " (Particulier)");
                        }
                        case "Entreprise" -> {
                            ClientEntreprise ce = (ClientEntreprise) client;
                            setText(ce.getNom() + " " + ce.getPrenom() + " (Entreprise)");
                        }
                        case "Établissement public" -> {
                            ClientEtablissementPublic cep = (ClientEtablissementPublic) client;
                            setText(cep.getNom() + " (Établissement public)");
                        }
                        default -> setText(client.toString());
                    }
                }
            }
        });

        listeClients.getSelectionModel().selectedItemProperty().addListener((obs, ancien, nouveau) -> {
            if (nouveau != null) {
                String info = "";

                String typeClient = nouveau.getTypeClient();
                switch (typeClient) {
                    case "Particulier" -> {
                        ClientParticulier cp = (ClientParticulier) nouveau;
                        info = "Type : Particulier\n" +
                                "Nom : " + cp.getNom() + "\n" +
                                "Prénom : " + cp.getPrenom() + "\n" +
                                "Téléphone : " + cp.getTelephone() + "\n" +
                                "Email : " + cp.getEmail() + "\n" +
                                "Adresse : " + (cp.getAdresse() != null ?
                                cp.getAdresse().getNumero() + " " +
                                        cp.getAdresse().getVoie() + ", " +
                                        cp.getAdresse().getCommune().getCode() + " " +
                                        cp.getAdresse().getCommune().getNom() : "N/A");
                    }
                    case "Entreprise" -> {
                        ClientEntreprise ce = (ClientEntreprise) nouveau;
                        info = "Type : Entreprise\n" +
                                "Nom : " + ce.getNom() + "\n" +
                                "Prénom : " + ce.getPrenom() + "\n" +
                                "Téléphone : " + ce.getTelephone() + "\n" +
                                "Email : " + ce.getEmail() + "\n" +
                                "Adresse : " + (ce.getAdresse() != null ?
                                ce.getAdresse().getNumero() + " " +
                                        ce.getAdresse().getVoie() + ", " +
                                        ce.getAdresse().getCommune().getCode() + " " +
                                        ce.getAdresse().getCommune().getNom() : "N/A");
                    }
                    case "Établissement public" -> {
                        ClientEtablissementPublic cep = (ClientEtablissementPublic) nouveau;
                        info = "Type : Établissement Public\n" +
                                "Nom : " + cep.getNom() + "\n" +
                                "Type Établissement : " + (cep.getType() != null ? cep.getType().toString() : "N/A") + "\n" +
                                "Téléphone : " + cep.getTelephone() + "\n" +
                                "Email : " + cep.getEmail() + "\n" +
                                "Adresse : " + (cep.getAdresse() != null ?
                                cep.getAdresse().getNumero() + " " +
                                        cep.getAdresse().getVoie() + ", " +
                                        cep.getAdresse().getCommune().getCode() + " " +
                                        cep.getAdresse().getCommune().getNom() : "N/A");
                    }
                    default -> info = "Type de client inconnu.";
                }

                labelInfo.setText(info);
            } else {
                labelInfo.setText("-");
            }
        });
    }


    @FXML
    public void ajouterClient() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/univartois/butinfo/sae/view/FourmulaireClient.fxml"));
            Parent root = loader.load();

            FormulaireClientController controller = loader.getController();
            controller.setClients(clients);
            controller.setListView(listeClients);

            Stage stage = new Stage();
            stage.setTitle("Ajouter un client");
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void modifierClient() {
        Client client = listeClients.getSelectionModel().getSelectedItem();
        if (client == null) return;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/univartois/butinfo/sae/view/FourmulaireClient.fxml"));
            Parent root = loader.load();

            FormulaireClientController controller = loader.getController();
            controller.setClients(listeClients.getItems());
            controller.setListView(listeClients);
            controller.setClientAModifier(client);

            Stage stage = new Stage();
            stage.setTitle("Modifier client");
            stage.setScene(new Scene(root));
            stage.showAndWait();

            listeClients.refresh();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @FXML
    public void supprimerClient() {
        Client selection = listeClients.getSelectionModel().getSelectedItem();
        if (selection != null) {
            clients.remove(selection);
        }
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
