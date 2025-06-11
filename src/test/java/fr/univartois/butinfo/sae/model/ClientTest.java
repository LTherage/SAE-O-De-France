package fr.univartois.butinfo.sae.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

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
}