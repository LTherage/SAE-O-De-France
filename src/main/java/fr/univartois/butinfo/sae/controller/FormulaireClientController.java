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

/**
 * Contrôleur JavaFX pour le formulaire d'ajout ou de modification d'un client.
 * Permet de saisir ou modifier les informations d'un client (particulier, entreprise ou établissement public).
 */
public class FormulaireClientController {
	/** Liste observable des clients à mettre à jour après ajout ou modification. */
	private ObservableList<Client> clients;
	/** ListView associée à la liste des clients (pour rafraîchir l'affichage). */
	private ListView<Client> listView;
	/** Choix du type de client (particulier, entreprise, établissement public). */
	@FXML
	private ChoiceBox<TypeClient> choiceTypeClient;
	/** Champ de saisie du téléphone. */
	@FXML
	private TextField champTelephone;
	/** Champ de saisie de l'email. */
	@FXML
	private TextField champEmail;
	/** Champ de saisie du nom (particulier ou entreprise). */
	@FXML
	private TextField champNom;
	/** Champ de saisie du prénom (particulier ou entreprise). */
	@FXML
	private TextField champPrenom;
	/** Champ de saisie du nom de l'établissement (établissement public). */
	@FXML
	private TextField champNomEtablissement;
	/** Choix du type d'établissement (établissement public). */
	@FXML
	private ChoiceBox<TypeEtablissement> choiceTypeEtablissement;
	/** Champ de saisie de l'adresse (numéro et voie). */
	@FXML
	private TextField champAdresse;
	/** Champ de saisie du nom de la commune. */
	@FXML
	private TextField champNomCommune;
	/** Champ de saisie du code postal. */
	@FXML
	private TextField champCodePostal;
	/** Champ de saisie du département. */
	@FXML
	private TextField champDepartement;
	/** Client à modifier (null si création). */
	private Client clientAModifier;

	/**
	 * Initialise le contrôleur après le chargement du FXML.
	 * Configure les choix disponibles et l'affichage dynamique des champs selon le type de client.
	 */
	@FXML
	public void initialize() {
		choiceTypeClient.getItems().addAll(TypeClient.values());
		choiceTypeEtablissement.getItems().addAll(TypeEtablissement.values());

		choiceTypeClient.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
			updateVisibility(newVal);
		});
	}

	/**
	 * Met à jour la visibilité des champs selon le type de client sélectionné.
	 * @param type Type de client sélectionné.
	 */
	private void updateVisibility(TypeClient type) {
		boolean showNomPrenom = (type == TypeClient.PARTICULIER || type == TypeClient.ENTREPRISE);
		champNom.setVisible(showNomPrenom);
		champPrenom.setVisible(showNomPrenom);

		boolean showEtabFields = (type == TypeClient.ETABLISSEMENT_PUBLIC);
		champNomEtablissement.setVisible(showEtabFields);
		choiceTypeEtablissement.setVisible(showEtabFields);
	}

	/**
	 * Définit la liste observable des clients à mettre à jour.
	 * @param clients Liste observable des clients.
	 */
	public void setClients(ObservableList<Client> clients) {
		this.clients = clients;
	}
	/**
	 * Définit la ListView associée à la liste des clients.
	 * @param listView ListView à rafraîchir après ajout ou modification.
	 */
	public void setListView(ListView<Client> listView) {
		this.listView = listView;
	}


	/**
	 * Valide le formulaire, crée ou modifie un client selon le contexte,
	 * met à jour la liste et ferme la fenêtre.
	 */
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
				// Peut-être afficher une erreur ou loguer ici
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

	/**
	 * Pré-remplit le formulaire avec les informations du client à modifier.
	 * @param client Le client à modifier.
	 */
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

		// Mise à jour visibilité selon le type sélectionné
		updateVisibility(choiceTypeClient.getValue());

		champTelephone.setText(client.getTelephone());
		champEmail.setText(client.getEmail());

		if (client.getAdresse() != null) {
			champAdresse.setText(client.getAdresse().getNumero() + " " + client.getAdresse().getVoie());
			champNomCommune.setText(client.getAdresse().getCommune().getNom());
			champCodePostal.setText(client.getAdresse().getCommune().getCode());
			champDepartement.setText(client.getAdresse().getCommune().getDepartement());
		}
	}

	/**
	 * Annule la saisie et ferme la fenêtre du formulaire.
	 */
	@FXML
	public void annuler() {
		champTelephone.getScene().getWindow().hide();
	}
	/**
	 * Change la vue affichée dans la fenêtre principale.
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
	 * @param event L'événement de clic.
	 */
	@FXML
	private void onClickButtonMainPage(ActionEvent event) {
		Button button = (Button) event.getSource();
		Stage stage = (Stage) button.getScene().getWindow();
		changerVue(stage, "view/Accueil-view.fxml");
	}

}
