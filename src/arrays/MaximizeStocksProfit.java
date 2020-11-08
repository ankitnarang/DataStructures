package arrays;

import java.util.ArrayList;

/*
 * 
 * Stock Buy Sell to Maximize Profit 
 * For example, if the given array is {100, 180, 260, 310, 40, 535, 695},
 * the maximum profit can earned by buying on day 0, selling on day 3. 
 * Again buy on day 4 and sell on day 6. 
 * If the given array of prices is sorted in decreasing order, then profit cannot be earned at all.
 * 
 */

public class MaximizeStocksProfit {

	public static void main(String[] args) {
		int[] prices = {100, 180, 260, 310, 40, 535, 695, 55, 54, 56, 100};
		maximizeProfit(prices);
	}

	private static void maximizeProfit(int[] prices) {
		int count = 0;
		int i = 0; 
		int size = prices.length;
		ArrayList<Interval> list = new ArrayList<>();
		while(i < size - 1) {
			while((i < size - 1) && (prices[i] >= prices[i+1])) {
				i++;
			}
			
			if(i == size - 1)
				break;
			
			Interval interval = new Interval();
			interval.setBuy(i);
			i++;
			
			while(i < size && prices[i] >= prices[i-1] ) {
				i++;
			}
			interval.setSell(i-1);
			list.add(interval);
			count++;
		}
		if(count == 0) {
			System.out.println("No day when buying and selling stock will make profit");
		}
		else {
			System.out.println("Buy on day\tSell on day");
			for(int j = 0 ; j < count; j++) {
				System.out.println("  " + list.get(j).getBuy() + " \t\t  " + list.get(j).getSell());
			}
		}
	}
	
}

class Interval{
	int buy;
	int sell;
	public int getBuy() {
		return buy;
	}
	public void setBuy(int buy) {
		this.buy = buy;
	}
	public int getSell() {
		return sell;
	}
	public void setSell(int sell) {
		this.sell = sell;
	}
}
