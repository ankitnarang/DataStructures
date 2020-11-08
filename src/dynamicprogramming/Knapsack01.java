package dynamicprogramming;

public class Knapsack01 {
    public static void main(String[] args) {
        int price[] = {60,100,120};
        int weight[] = {10,20,30};

        int W = 50;

        int len = price.length;

        System.out.println("Max price after filling knapsack is " + knapsackRecursive(W,weight,price,len));
        System.out.println("Max price after filling knapsack is " + knapsackIterative(W,weight,price,len));
    }

    private static int knapsackRecursive(int W, int[] weight, int[] price, int n) {
        if(W == 0 || n == 0){
            return 0;
        }
        if(weight[n-1] > W){
            return knapsackRecursive(W,weight,price,n-1);
        }
        else {
            return Math.max(price[n-1] + knapsackRecursive(W-weight[n-1],weight,price,n-1),
                    knapsackRecursive(W,weight,price,n-1));
        }
    }

    private static int knapsackIterative(int W, int[] weight, int[] price, int n) {
        int[][] dp = new int[n + 1][W + 1];

        for (int item = 0; item < n + 1; item++) {
            for (int weigh = 0; weigh < W + 1; weigh++) {
                if (item == 0 || weigh == 0) {
                    dp[item][weigh] = 0;
                } else if (weight[item - 1] <= weigh) {
                    dp[item][weigh] = Math.max(
                            price[item - 1] + dp[item - 1][weigh - weight[item - 1]],
                            dp[item - 1][weigh]
                    );
                } else {
                    dp[item][weigh] = dp[item - 1][weigh];
                }
            }
        }

        return dp[n][W];
    }
}
