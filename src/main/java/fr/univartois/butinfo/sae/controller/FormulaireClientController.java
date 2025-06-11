package fr.univartois.butinfo.sae.controller;

import fr.univartois.butinfo.sae.HelloApplication;
import fr.univartois.butinfo.sae.model.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class FormulaireClientController {

	private ObservableList<Client> clients;
	private ListView<Client> listView;

	@FXML
	private ChoiceBox<TypeClient> choiceTypeClient;

	@FXML
	private TextField champTelephone;

	@FXML
	private TextField champEmail;

	@FXML
	private TextField champNom;

	@FXML
	private TextField champPrenom;

	@FXML
	private TextField champNomEtablissement;

	@FXML
	private ChoiceBox<TypeEtablissement> choiceTypeEtablissement;

	@FXML
	private TextField champAdresse;

	@FXML
	private TextField champNomCommune;

	@FXML
	private TextField champCodePostal;

	@FXML
	private TextField champDepartement;

	@FXML
	public void initialize() {
		choiceTypeClient.getItems().addAll(TypeClient.values());
		choiceTypeEtablissement.getItems().addAll(TypeEtablissement.values());

		choiceTypeClient.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
			boolean showNomPrenom = (newVal == TypeClient.PARTICULIER || newVal == TypeClient.ENTREPRISE);
			champNom.setVisible(showNomPrenom);
			champPrenom.setVisible(showNomPrenom);

			boolean showEtabFields = (newVal == TypeClient.ETABLISSEMENT_PUBLIC);
			champNomEtablissement.setVisible(showEtabFields);
			choiceTypeEtablissement.setVisible(showEtabFields);
		});
	}

	public void setClients(ObservableList<Client> clients) {
		this.clients = clients;
	}

	public void setListView(ListView<Client> listView) {
		this.listView = listView;
	}

	private Client clientAModifier;


	@FXML
	public void valider() {
		TypeClient type = choiceTypeClient.getValue();
		if (type == null) {
			return;
		}

		String tel = champTelephone.getText();
		String mail = champEmail.getText();

		String adresseStr = champAdresse.getText();
		int numero = 0;
		String voie = "";
		if (adresseStr != null && adresseStr.contains(" ")) {
			String[] parts = adresseStr.split(" ", 2);
			try {
				numero = Integer.parseInt(parts[0]);
				voie = parts[1];
			} catch (NumberFormatException ignore) {

			}
		}

		String nomCommune = champNomCommune.getText();
		String codePostal = champCodePostal.getText();
		String departement = champDepartement.getText();

		Commune commune = new Commune(nomCommune, codePostal, departement);
		Adresse adresse = new Adresse(numero, voie, commune);

		if (clientAModifier != null) {
			clientAModifier.setTelephone(tel);
			clientAModifier.setEmail(mail);
			clientAModifier.setAdresse(adresse);

			switch (type) {
				case PARTICULIER -> {
					if (clientAModifier instanceof ClientParticulier cp) {
						cp.setNom(champNom.getText());
						cp.setPrenom(champPrenom.getText());
					}
				}
				case ENTREPRISE -> {
					if (clientAModifier instanceof ClientEntreprise ce) {
						ce.setNom(champNom.getText());
						ce.setPrenom(champPrenom.getText());
					}
				}
				case ETABLISSEMENT_PUBLIC -> {
					if (clientAModifier instanceof ClientEtablissementPublic cep) {
						cep.setNom(champNomEtablissement.getText());
						cep.setType(choiceTypeEtablissement.getValue());
					}
				}
			}
		} else {
			// Mode création : on crée un nouveau client
			Client nouveauClient = null;

			switch (type) {
				case PARTICULIER -> {
					ClientParticulier cp = new ClientParticulier();
					cp.setNom(champNom.getText());
					cp.setPrenom(champPrenom.getText());
					cp.setAdresse(adresse);
					nouveauClient = cp;
				}
				case ENTREPRISE -> {
					ClientEntreprise ce = new ClientEntreprise();
					ce.setNom(champNom.getText());
					ce.setPrenom(champPrenom.getText());
					ce.setAdresse(adresse);
					nouveauClient = ce;
				}
				case ETABLISSEMENT_PUBLIC -> {
					ClientEtablissementPublic cep = new ClientEtablissementPublic();
					cep.setNom(champNomEtablissement.getText());
					cep.setType(choiceTypeEtablissement.getValue());
					cep.setAdresse(adresse);
					nouveauClient = cep;
				}
			}

			if (nouveauClient != null) {
				nouveauClient.setTelephone(tel);
				nouveauClient.setEmail(mail);
				clients.add(nouveauClient);
			}
		}

		if (listView != null) listView.refresh();
		champTelephone.getScene().getWindow().hide();
	}


	public void setClientAModifier(Client client) {
		this.clientAModifier = client;

		if (client == null) return;

		if (client instanceof ClientParticulier) {
			choiceTypeClient.setValue(TypeClient.PARTICULIER);
			champNom.setText(((ClientParticulier) client).getNom());
			champPrenom.setText(((ClientParticulier) client).getPrenom());
		} else if (client instanceof ClientEntreprise) {
			choiceTypeClient.setValue(TypeClient.ENTREPRISE);
			champNom.setText(((ClientEntreprise) client).getNom());
			champPrenom.setText(((ClientEntreprise) client).getPrenom());
		} else if (client instanceof ClientEtablissementPublic) {
			choiceTypeClient.setValue(TypeClient.ETABLISSEMENT_PUBLIC);
			champNomEtablissement.setText(((ClientEtablissementPublic) client).getNom());
			choiceTypeEtablissement.setValue((TypeEtablissement) ((ClientEtablissementPublic) client).getType());

		}

		champTelephone.setText(client.getTelephone());
		champEmail.setText(client.getEmail());

		if (client.getAdresse() != null) {
			champAdresse.setText(client.getAdresse().getNumero() + " " + client.getAdresse().getVoie());
			champNomCommune.setText(client.getAdresse().getCommune().getNom());
			champCodePostal.setText(client.getAdresse().getCommune().getCode());
			champDepartement.setText(client.getAdresse().getCommune().getDepartement());
		}
	}


	@FXML
	public void annuler() {
		champTelephone.getScene().getWindow().hide();
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
