package fr.univartois.butinfo.sae.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Classe de test pour {@link Commune}.
 */
public class CommuneTest {

    /**
     * Teste la méthode toString de la classe Commune.
     */
    @Test
    @DisplayName("Test la méthode toString.")
    void testToString() {
        Commune commune = new Commune("12345", "Testville", "Testville");
        String expected = "Commune{code='12345', nom='Testville', departement='Testville'}";
        assert commune.toString().equals(expected);
    }

    /**
     * Teste le constructeur et la méthode equals de la classe Commune.
     */
    @Test
    @DisplayName("Test le constructeur et les accesseurs.")
    void testEquals() {
        Commune commune1 = new Commune("12345", "Testville", "Testville");
        Commune commune2 = new Commune("12345", "Testville", "Testville");
        Commune commune3 = new Commune("54321", "AnotherVille", "AnotherVille");

        assert commune1.equals(commune2);
        assert !commune1.equals(commune3);
        assert !commune1.equals(null);
        assert !commune1.equals(new Object());
    }
}