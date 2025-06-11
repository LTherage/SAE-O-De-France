package fr.univartois.butinfo.sae.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class EauTest {

	@Test
	@DisplayName("Test la méthode Equals.")
	public void testEquals() {
		Eau eau1 = new Eau("Evian", "Bouteille", 1.5);
		Eau eau2 = new Eau("Evian", "Bouteille", 1.5);
		assertThat(eau1).isNotEqualTo(eau2);
	}

	@Test
	@DisplayName("Compare les identifiants des bouteilles .")
	public void compareId() {
		Eau eau1 = new Eau("Evian", "Bouteille", 1.5);
		Eau eau2 = new Eau("Evian", "Bouteille", 1.5);
		assertThat(eau1.compareId(eau2)).isTrue();
	}

	@BeforeAll
	@DisplayName("Test les getters et les setters.")
	static void testGetterSetter() {
		Eau eau = new Eau("Evian", "Bouteille", 1.5);
		assertThat(eau.getMarque()).isEqualTo("Evian");
		eau.setMarque("Evian2");
		assertThat(eau.getMarque()).isEqualTo("Evian2");
		eau.setCategorie("Bouteille");
		assertThat(eau.getCategorie()).isEqualTo("Bouteille");
		eau.setPrix(1.5);
		assertThat(eau.getPrix()).isEqualTo(1.5);
	}
}