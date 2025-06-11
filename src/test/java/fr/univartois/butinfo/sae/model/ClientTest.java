package fr.univartois.butinfo.sae.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

	@Test
	@DisplayName("test des points de fidélité des clients")
	void ajoutPointsFidelite() {

		ClientEntreprise clientEntreprise = new ClientEntreprise();
		ClientEtablissementPublic clientEtablissementPublic = new ClientEtablissementPublic();
		ClientParticulier clientParticulier = new ClientParticulier();
		clientEntreprise.ajoutPointsFidelite(5000);
		clientEtablissementPublic.ajoutPointsFidelite(5000);
		clientParticulier.ajoutPointsFidelite(5000);
		assertEquals(50, clientEntreprise.getPointsFidelite());
		assertEquals(1000, clientEtablissementPublic.getPointsFidelite());
		assertEquals(500, clientParticulier.getPointsFidelite());
	}
}