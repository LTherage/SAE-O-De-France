package fr.univartois.butinfo.sae.controller;

import fr.univartois.butinfo.sae.model.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class StockEauAjoutModifController {

    @FXML private TextField communeCodeField;
    @FXML private TextField communeNomField;
    @FXML private TextField communeDepartementField;

    @FXML private ComboBox<Categorie> categorieComboBox;
    @FXML private TextField quantiteTextField;
    @FXML private TextField codeEntrepotField;
    @FXML private TextField nomEntrepotField;
    @FXML private TextField numeroAdresseField;
    @FXML private TextField voieAdresseField;

    @FXML private Label errorLabel;

    private StockEau stock;


    @FXML
    private void initialize() {
        categorieComboBox.setItems(FXCollections.observableArrayList(Categorie.values()));
    }

    @FXML
    private void onAnnuler() {
        Stage stage = (Stage) categorieComboBox.getScene().getWindow();
        stage.close();
    }

    public void setStock(StockEau stock) {
        this.stock = stock;

        if (stock != null) {
            categorieComboBox.setValue(stock.getCategorie());
            quantiteTextField.setText(String.valueOf(stock.getQuantite()));

            Entrepot entrepot = stock.getEntrepot();
            if (entrepot != null) {
                codeEntrepotField.setText(String.valueOf(entrepot.getCode()));
                nomEntrepotField.setText(entrepot.getNom());

                Adresse adresse = entrepot.getAdresse();
                if (adresse != null) {
                    numeroAdresseField.setText(String.valueOf(adresse.getNumero()));
                    voieAdresseField.setText(adresse.getVoie());

                    Commune commune = adresse.getCommune();
                    if (commune != null) {
                        communeCodeField.setText(commune.getCode());
                        communeNomField.setText(commune.getNom());
                        communeDepartementField.setText(commune.getDepartement());
                    }
                }
            }
        }
    }

    @FXML
    private void onValider() {
        errorLabel.setText("");

        if (stock == null) return;

        try {
            if (categorieComboBox.getValue() == null) {
                errorLabel.setText("Veuillez sélectionner une catégorie.");
                return;
            }

            int quantite;
            try {
                quantite = Integer.parseInt(quantiteTextField.getText());
                if (quantite < 0) {
                    errorLabel.setText("La quantité doit être positive.");
                    return;
                }
            } catch (NumberFormatException e) {
                errorLabel.setText("La quantité doit être un nombre entier.");
                return;
            }

            int codeEntrepot;
            try {
                codeEntrepot = Integer.parseInt(codeEntrepotField.getText());
                if (codeEntrepot < 0) {
                    errorLabel.setText("Le code de l'entrepôt doit être un nombre positif.");
                    return;
                }
            } catch (NumberFormatException e) {
                errorLabel.setText("Le code de l'entrepôt doit être un nombre entier.");
                return;
            }

            int numeroAdresse;
            try {
                numeroAdresse = Integer.parseInt(numeroAdresseField.getText());
                if (numeroAdresse < 0) {
                    errorLabel.setText("Le numéro d'adresse doit être positif.");
                    return;
                }
            } catch (NumberFormatException e) {
                errorLabel.setText("Le numéro d'adresse doit être un nombre entier.");
                return;
            }

            // Champs texte obligatoires
            if (nomEntrepotField.getText().isBlank()) {
                errorLabel.setText("Le nom de l'entrepôt est obligatoire.");
                return;
            }

            if (voieAdresseField.getText().isBlank()) {
                errorLabel.setText("La voie d'adresse est obligatoire.");
                return;
            }

            if (communeCodeField.getText().isBlank() || communeNomField.getText().isBlank() || communeDepartementField.getText().isBlank()) {
                errorLabel.setText("Tous les champs de la commune sont obligatoires.");
                return;
            }

            stock.setCategorie(categorieComboBox.getValue());
            stock.setQuantite(quantite);

            Commune commune = new Commune(communeCodeField.getText(), communeNomField.getText(), communeDepartementField.getText());
            Adresse adresse = new Adresse(numeroAdresse, voieAdresseField.getText(), commune);
            Entrepot entrepot = new Entrepot(codeEntrepot, nomEntrepotField.getText(), adresse);
            stock.setEntrepot(entrepot);

            // Fermer la fenêtre modale
            Stage stage = (Stage) categorieComboBox.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            errorLabel.setText("Erreur inattendue : " + e.getMessage());
        }
    }

}