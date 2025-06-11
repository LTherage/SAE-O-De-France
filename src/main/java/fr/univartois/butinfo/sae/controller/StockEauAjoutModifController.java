package fr.univartois.butinfo.sae.controller;

import fr.univartois.butinfo.sae.model.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

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

    private StockEau stock;

    @FXML
    private void initialize() {
        categorieComboBox.setItems(FXCollections.observableArrayList(Categorie.values()));
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
        if (stock == null) return;

        try {
            stock.setCategorie(categorieComboBox.getValue());
            stock.setQuantite(Integer.parseInt(quantiteTextField.getText()));

            int code = Integer.parseInt("0" + codeEntrepotField.getText());
            String nom = nomEntrepotField.getText();
            int numero = Integer.parseInt("0" + numeroAdresseField.getText());
            String voie = voieAdresseField.getText();

            Commune commune = new Commune(communeCodeField.getText(), communeNomField.getText(), communeDepartementField.getText());
            Adresse adresse = new Adresse(numero, voie, commune);
            Entrepot entrepot = new Entrepot(code, nom, adresse);
            stock.setEntrepot(entrepot);

            System.out.println("Stock validé : " + stock);

        } catch (Exception e) {
            System.out.println("Erreur de saisie : " + e.getMessage());
            return; // on ne ferme pas la fenêtre si erreur
        }

        // Fermer la fenêtre modale
        Stage stage = (Stage) categorieComboBox.getScene().getWindow();
        stage.close();
    }

}