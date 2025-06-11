package fr.univartois.butinfo.sae.model;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class EntrepotTest {
    @Test
    @DisplayName("Test la méthode Equals.")
    public void testEquals() {
        Adresse adresse = new Adresse(123, "75001", new Commune("62300", "Paris", "ile-de-France"));
        Entrepot entrepot1 = new Entrepot(1, "123 Rue de Paris", adresse);
        Entrepot entrepot2 = new Entrepot(2, "123 Rue de Paris", adresse);
        assertThat(entrepot1).isNotEqualTo(entrepot2);
    }

    @Test
    @DisplayName("Compare les identifiants des entrepots.")
    public void compareId() {
        Adresse adresse3 = new Adresse(123, "75001", new Commune("62300", "Lens", "Nord-Pas-de-Calais"));
        Entrepot entrepot1 = new Entrepot(1, "123 Rue de Paris", adresse3);
        Entrepot entrepot2 = new Entrepot( 2,"456 Rue de Lyon", adresse3);
        assertThat(entrepot1.compareId(entrepot2)).isFalse();
    }
}
