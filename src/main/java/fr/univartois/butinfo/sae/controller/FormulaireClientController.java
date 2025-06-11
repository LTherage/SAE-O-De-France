package fr.univartois.butinfo.sae.controller;

import fr.univartois.butinfo.sae.model.*;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

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

	@FXML
	public void valider() {
		TypeClient type = choiceTypeClient.getValue();
		if (type == null) {
			// Ajouter gestion erreur (message utilisateur)
			return;
		}

		String tel = champTelephone.getText();
		String mail = champEmail.getText();

		// Adresse parsing
		String adresseStr = champAdresse.getText();
		int numero = 0;
		String voie = "";
		if (adresseStr != null && adresseStr.contains(" ")) {
			String[] parts = adresseStr.split(" ", 2);
			try {
				numero = Integer.parseInt(parts[0]);
				voie = parts[1];
			} catch (NumberFormatException e) {
				// gérer erreur (par exemple afficher un message)
			}
		}

		String nomCommune = champNomCommune.getText();
		String codePostal = champCodePostal.getText();
		String departement = champDepartement.getText();

		Commune commune = new Commune(nomCommune, codePostal, departement);
		Adresse adresse = new Adresse(numero, voie, commune);

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
			if (listView != null) listView.refresh();
			champTelephone.getScene().getWindow().hide();
		}
	}

	@FXML
	public void annuler() {
		champTelephone.getScene().getWindow().hide();
	}
}
