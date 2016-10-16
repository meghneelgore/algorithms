package com.example.stocktrader;

/**
 * Finds the maximum profit that can be generated from a given array of stock prices. Each element corresponds to a particular time. 
 * Therefore, we only need to find the max difference between a previous element and a subsequent element and not the other way around.
 * No shorting, i.e. we must buy before we sell.
 * 
 * @author meghneel.gore
 *
 */
public class StockTrader {

	public int maxProfit(int[] stockPrices) {
		int profit = Integer.MIN_VALUE;
		int minElement = stockPrices[0];

		for(int i = 1; i < stockPrices.length; i++) {
			if(stockPrices[i] - minElement > profit) {
				profit = stockPrices[i] - minElement;
			}
			if(minElement > stockPrices[i]) {
				minElement = stockPrices[i];
			}
		}
		return profit;
	}
}
