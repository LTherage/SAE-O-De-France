package fr.univartois.butinfo.sae.model;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdresseTest {

    @Test
    @DisplayName("Test de la classe Adresse")
    public void testAdresse() {
        Commune commune = new Commune("62300", "Paris", "ile-de-France");
        Adresse adresse = new Adresse(123, "75001", commune);
        assertEquals(123, adresse.getNumero());
        assertEquals("75001", adresse.getVoie());
        assertEquals("Paris", adresse.getCommune());

    }

    @Test
    @DisplayName("Test de l'égalité des adresses")
    public void testAdresseEquals() {
        Commune commune1 = new Commune("62300", "Paris", "ile-de-France");
        Commune commune2 = new Commune("62300", "Paris", "ile-de-France");
        Adresse adresse1 = new Adresse(123, "75001", commune1);
        Adresse adresse2 = new Adresse(123, "75001", commune2);

        assertEquals(adresse1, adresse2);
    }

    @Test
    @DisplayName("Test de la méthode toString de l'adresse")
    public void testAdresseToString() {
        Commune commune = new Commune("62300", "Paris", "ile-de-France");
        Adresse adresse = new Adresse(123, "75001", commune);
        String expectedString = "Adresse{numero=123, voie='75001', commune=Commune{code='62300', nom='Paris', departement='ile-de-France'}}";
        assertEquals(expectedString, adresse.toString());
    }

}
