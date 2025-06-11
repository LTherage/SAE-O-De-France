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

/**
 * Contrôleur JavaFX pour le formulaire d'ajout ou de modification d'un stock d'eau.
 * Permet de saisir ou modifier les informations d'un stock, d'un entrepôt et de son adresse.
 */
public class StockEauAjoutModifController {

    /** Champ de saisie du code de la commune. */
    @FXML private TextField communeCodeField;
    /** Champ de saisie du nom de la commune. */
    @FXML private TextField communeNomField;
    /** Champ de saisie du département de la commune. */
    @FXML private TextField communeDepartementField;

    /** ComboBox pour sélectionner la catégorie d'eau. */
    @FXML private ComboBox<Categorie> categorieComboBox;
    /** Champ de saisie de la quantité d'eau. */
    @FXML private TextField quantiteTextField;
    /** Champ de saisie du code de l'entrepôt. */
    @FXML private TextField codeEntrepotField;
    /** Champ de saisie du nom de l'entrepôt. */
    @FXML private TextField nomEntrepotField;
    /** Champ de saisie du numéro d'adresse de l'entrepôt. */
    @FXML private TextField numeroAdresseField;
    /** Champ de saisie de la voie de l'adresse de l'entrepôt. */
    @FXML private TextField voieAdresseField;

    /** Stock d'eau à modifier ou à créer. */
    private StockEau stock;

    /**
     * Initialise le contrôleur après le chargement du FXML.
     * Remplit la ComboBox des catégories d'eau.
     */
    @FXML
    private void initialize() {
        categorieComboBox.setItems(FXCollections.observableArrayList(Categorie.values()));
    }

    /**
     * Définit le stock d'eau à modifier et pré-remplit les champs du formulaire.
     * @param stock Le stock d'eau à modifier.
     */
    public void setStock(StockEau stock) {
        this.stock = stock;
        // Pré-remplissage des champs si stock non nul
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

    /**
     * Valide le formulaire, met à jour le stock d'eau avec les valeurs saisies,
     * et ferme la fenêtre si la saisie est correcte.
     * Affiche un message d'erreur en cas de saisie invalide.
     */
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