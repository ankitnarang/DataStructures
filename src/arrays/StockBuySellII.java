package arrays;

public class StockBuySellII {

    public static void main(String[] args) {
        int [] array = {7,6,4,3,1}; // {7,1,5,3,6,4};
        System.out.println("Profit is " + maxProfit(array));

    }

    private static int maxProfit(int[] array) {
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < array.length; i++){
            if(array[i] < min){
                min = array[i];
            } else {
                maxProfit = Math.max(maxProfit,array[i] - min);
            }
        }
        return maxProfit;
    }

}
