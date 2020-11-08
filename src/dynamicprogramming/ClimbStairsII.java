package dynamicprogramming;

public class ClimbStairsII {
    public static void main(String[] args) {
        int stairs = 5;
        int m = 5;
        System.out.println("Number of ways " + countWays(stairs,m));
    }

    private static int countWays(int stairs, int m) {
        return countWaysUtil(stairs + 1, m);
    }

    private static int countWaysUtil(int n, int m) {
        if(n <= 1){
            return n;
        }
        int res = 0;
        for(int i = 1; i <= n && i <= m; i++){
            res += countWaysUtil(n-i,m);
        }
        return res;
    }
}
