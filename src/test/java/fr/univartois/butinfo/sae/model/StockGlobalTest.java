package fr.univartois.butinfo.sae.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StockGlobalTest {

	@Test
	void add() {
		StockGlobal stockGlobal = new StockGlobal();
		Eau eau1 = new Eau("Evian", "Bouteille", 1.5);
		StockEau stock1 = new StockEau();

		stockGlobal.add(stock1);
		assertThat(stockGlobal.getStocks() != null);

	}

	@Test
	void sub() {
		StockGlobal stockGlobal = new StockGlobal();
		StockEau stock = new StockEau();
		stock.setQuantite(10);
		stockGlobal.add(stock);

		stockGlobal.sub(0, 5);

		assertEquals(5, stock.getQuantite());

	}

	@Test
	void triQuantite() {
		StockGlobal stockGlobal = new StockGlobal();
		StockEau stock1 = new StockEau();
		StockEau stock2 = new StockEau();
		stockGlobal.add(stock1);
		stockGlobal.add(stock2);

		stockGlobal.triQuantite();

		assertEquals(stock1, stockGlobal.getStocks()[0]);
		assertEquals(stock2, stockGlobal.getStocks()[1]);
	}
}