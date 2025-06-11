package fr.univartois.butinfo.sae.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CommandeTest {


	@Test
	@DisplayName("Test l'ajout de ligne de commande.")
	void testAddLigneCommande() {
		Eau eau = new Eau("Evian", "Bouteille", 1.5);
		ClientParticulier client = new ClientParticulier();
		Commande commande = new Commande(client);
		commande.addLigneCommande(eau,10);
		assertEquals(1, commande.getLignesDeCommande().size());
	}

	@Test
	@DisplayName("Test la méthode Equals().")
	void testEquals() {
		Eau eau1 = new Eau("Evian", "Bouteille", 1.5);
		Eau eau2 = new Eau("Evian", "Bouteille", 1.5);
		ClientParticulier client1 = new ClientParticulier();
		ClientParticulier client2 = new ClientParticulier();
		Commande commande1 = new Commande(client1);
		Commande commande2 = new Commande(client2);
		commande1.addLigneCommande(eau1, 10);
		commande2.addLigneCommande(eau2, 10);
		assertThat(commande1).isNotEqualTo(commande2);
	}

	@Test
	@DisplayName("Test la mise à jour de ligne de commande.")
	void testUpdateLigneCommande(){
		Eau eau = new Eau("Evian", "Bouteille", 1.5);
		ClientParticulier client = new ClientParticulier();
		Commande commande = new Commande(client);
		commande.addLigneCommande(eau,10);
		commande.updateLigneCommande(0, 20);
		assertEquals(20, commande.getLignesDeCommande().getFirst().getQuantite());
	}

	@Test
	@DisplayName("Test le montant de la remise.")
	void testMontantDeLaRemise() {
		Eau eau = new Eau("Evian", "Bouteille", 1.5);

		ClientParticulier clientParticulier = new ClientParticulier();
		clientParticulier.ajoutPointsFidelite(5000);
		Commande commandeParticulier = new Commande(clientParticulier);
		commandeParticulier.addLigneCommande(eau, 10);
		assertEquals(50.0, commandeParticulier.montantDeLaRemise());

		ClientEtablissementPublic clientEtab = new ClientEtablissementPublic();
		clientEtab.ajoutPointsFidelite(600);
		Commande commandeEtab = new Commande(clientEtab);
		commandeEtab.addLigneCommande(eau, 10);
		assertEquals(0.0, commandeEtab.montantDeLaRemise());

		ClientEntreprise clientEntreprise = new ClientEntreprise();
		clientEntreprise.ajoutPointsFidelite(1000);
		Commande commandeEntreprise = new Commande(clientEntreprise);
		commandeEntreprise.addLigneCommande(eau, 10);
		assertEquals(0.0, commandeEntreprise.montantDeLaRemise(), 0.01);
	}

	@Test
	@DisplayName( "Test le nombre de bouteilles gratuites.")
	void testNombreBouteillesGratuites() {
		Eau eau = new Eau("Evian", "Bouteille", 1.5);

		ClientParticulier clientParticulier = new ClientParticulier();
		Commande commandeParticulier = new Commande(clientParticulier);
		commandeParticulier.addLigneCommande(eau, 25);
		assertEquals(2, commandeParticulier.nombreBouteillesGratuites());

		ClientEtablissementPublic clientEtab = new ClientEtablissementPublic();
		Commande commandeEtab = new Commande(clientEtab);
		commandeEtab.addLigneCommande(eau, 130);
		assertEquals(2, commandeEtab.nombreBouteillesGratuites());

		ClientEntreprise clientEntreprise = new ClientEntreprise();
		Commande commandeEntreprise = new Commande(clientEntreprise);
		commandeEntreprise.addLigneCommande(eau, 250);
		assertEquals(2, commandeEntreprise.nombreBouteillesGratuites());
	}
	@Test
	@DisplayName("Test le montant total de la commande.")
	void testMontant() {
		Eau eau = new Eau("Evian", "Bouteille", 1.5);
		ClientParticulier client = new ClientParticulier();
		Commande commande = new Commande(client);
		commande.addLigneCommande(eau, 10);
		assertEquals(10.0, commande.montant(), 0.01);

		client.ajoutPointsFidelite(500);
		assertEquals(10.0, commande.montant(), 0.01);
	}
}