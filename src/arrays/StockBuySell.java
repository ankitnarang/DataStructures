package arrays;

import java.util.ArrayList;

/*
    Buy and Sell stocks multiple times
 */
public class StockBuySell {
    static class Interval {
        private int buy;
        private int sell;
    }

    public static void main(String[] args) {
        int prices[] = {7,1,5,3,6,4};// {100,180,260,310,40,535,695};
        stockBuySell(prices);
    }

    private static void stockBuySell(int[] prices) {
        int n = prices.length;
        int count = 0;
        int i = 0;
        ArrayList<Interval> list = new ArrayList<>();
        while(i < n - 1){
            //Find local minima
            while(i < n-1 && prices[i] >= prices[i+1]){
                i++;
            }
            if(i == n-1){
                break;
            }

            Interval interval = new Interval();
            interval.buy = i;
            i++;

            //Find local maxima
            while (i < n && prices[i-1] <= prices[i]){
                i++;
            }

            interval.sell = i-1;
            list.add(interval);
            count++;
        }

        if(count == 0){
            System.out.println("There's no days when buying and selling will make profit");
        } else {
            for (Interval interval : list){
                System.out.println("Buy on day : " + interval.buy +
                        " and selling on day : " + interval.sell);
            }
        }
    }

}
