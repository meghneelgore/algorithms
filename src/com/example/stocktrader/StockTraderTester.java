package com.example.stocktrader;

public class StockTraderTester {

	public static void main(String[] args) {
		int[] prices = {3, 3, 5, 7, 6};
		StockTrader trader = new StockTrader();
		System.out.println("Max profit: " + trader.maxProfit(prices));
	}
}

