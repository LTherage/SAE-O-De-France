package fr.univartois.butinfo.sae.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test pour {@link Client} et ses sous-classes.
 */
class ClientTest {

	/**
	 * Vérifie l'ajout de points de fidélité pour chaque type de client.
	 */
	@Test
	void ajoutPointsFidelite() {
		ClientEntreprise clientEntreprise = new ClientEntreprise();
		ClientEtablissementPublic clientEtablissementPublic = new ClientEtablissementPublic();
		ClientParticulier clientParticulier = new ClientParticulier();
		clientEntreprise.ajoutPointsFidelite(5000);
		clientEtablissementPublic.ajoutPointsFidelite(5000);
		clientParticulier.ajoutPointsFidelite(5000);
		assertEquals(50, clientEntreprise.getPointsFidelite());
		assertEquals(100, clientEtablissementPublic.getPointsFidelite());
		assertEquals(500, clientParticulier.getPointsFidelite());
	}

	@Test
	@DisplayName("Teste la méthode equals pour les clients.")
	void testEquals() {
		ClientEntreprise clientEntreprise1 = new ClientEntreprise();
		ClientEntreprise clientEntreprise2 = new ClientEntreprise();
		ClientEtablissementPublic clientEtablissementPublic1 = new ClientEtablissementPublic();
		ClientEtablissementPublic clientEtablissementPublic2 = new ClientEtablissementPublic();
		ClientParticulier clientParticulier1 = new ClientParticulier();
		ClientParticulier clientParticulier2 = new ClientParticulier();

		assertEquals(clientEntreprise1, clientEntreprise2);
		assertEquals(clientEtablissementPublic1, clientEtablissementPublic2);
		assertEquals(clientParticulier1, clientParticulier2);
		assertNotEquals(clientEntreprise1, clientEtablissementPublic1);
		assertNotEquals(clientEntreprise1, clientParticulier1);
	}

	@Test
	@DisplayName("Teste la méthode toString pour les clients.")
	void testToString() {
		ClientEntreprise clientEntreprise = new ClientEntreprise();
		ClientEtablissementPublic clientEtablissementPublic = new ClientEtablissementPublic();
		ClientParticulier clientParticulier = new ClientParticulier();

		String expectedEntreprise = "ClientEntreprise{prenom='null', code=0, dateInscription=null, adresse=null, telephone='null', email='null', pointsFidelite=0}";
		String expectedEtablissementPublic = "ClientEtablissementPublic{type=null, code=0, dateInscription=null, adresse=null, telephone='null', email='null', pointsFidelite=0}";
		String expectedParticulier = "ClientParticulier{nom='null', prenom='null', code=0, dateInscription=null, adresse=null, telephone='null', email='null', pointsFidelite=0}";

		assertEquals(expectedEntreprise, clientEntreprise.toString());
		assertEquals(expectedEtablissementPublic, clientEtablissementPublic.toString());
		assertEquals(expectedParticulier, clientParticulier.toString());
	}
}