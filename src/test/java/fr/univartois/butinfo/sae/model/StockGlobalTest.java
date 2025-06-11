package fr.univartois.butinfo.sae.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StockGlobalTest {

	@Test
	@DisplayName( "Test l'ajout d'un stock.")
	void add() {
		StockGlobal stockGlobal = new StockGlobal();
		StockEau stock1 = new StockEau();

		stockGlobal.add(stock1);
		assertThat(stockGlobal.getStocks() != null);

	}

	@Test
	@DisplayName( "Test la suppression d'un stock.")
	void sub() {
		StockGlobal stockGlobal = new StockGlobal();
		StockEau stock = new StockEau();
		stock.setQuantite(10);
		stockGlobal.add(stock);

		stockGlobal.sub(0, 5);

		assertEquals(5, stock.getQuantite());

	}

	@Test
	@DisplayName("Test de quantité des stocks.")
	void testTriQuantite() {
		StockGlobal stockGlobal = new StockGlobal();
		StockEau stock1 = new StockEau();
		StockEau stock2 = new StockEau();
		StockEau stock3 = new StockEau();

		stock1.setQuantite(30);
		stock2.setQuantite(10);
		stock3.setQuantite(20);

		stockGlobal.add(stock1);
		stockGlobal.add(stock2);
		stockGlobal.add(stock3);

		stockGlobal.triQuantite();

		StockEau[] stocks = stockGlobal.getStocks();
		assertEquals(10, stocks[0].getQuantite());
		assertEquals(20, stocks[1].getQuantite());
		assertEquals(30, stocks[2].getQuantite());
	}
}