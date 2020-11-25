package dynamicprogramming.matrixchainmultiplicationpattern;

public class MatrixChainMultiplication {
    // Question Link :
    // Reference Link :
    static int[][] dp;
    public static void main(String[] args) {
        int[] arr = {10, 20, 30};
        // {10, 20, 30, 40, 30}; // {40, 20, 30, 10, 30}; //{1, 2, 3, 4, 3 };
        int n = arr.length;
        int result = matrixChainOrderRecursive(arr,1,n-1);
        System.out.println("Minimum number of multiplications needed is " + result);

        dp = new int[1001][1001]; // considering this size from constraint given in problem statement
        for(int i = 0; i < 1001; i++){
            for(int j = 0; j < 1001; j++){
                dp[i][j] = -1;
            }
        }
        result = matrixChainOrderTopDownMemoization(arr,1,n-1);
        System.out.println("Minimum number of multiplications needed is " + result);
    }

    private static int matrixChainOrderTopDownMemoization(int[] arr, int i, int j) {
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(i >= j){
            return 0;
        }
        dp[i][j] = Integer.MAX_VALUE;
        for(int k = i ; k <= j-1; k++){
            dp[i][j]= Math.min
                    ( dp[i][j],
                     ( matrixChainOrderTopDownMemoization(arr,i,k) +
                       matrixChainOrderTopDownMemoization(arr,k+1,j) +
                       (arr[i-1] * arr[k] * arr[j]) )
                     );
        }
        return dp[i][j];
    }

    private static int matrixChainOrderRecursive(int[] arr, int i, int j) {
        if(i >= j){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int k = i ; k <= j-1; k++){
            int count = matrixChainOrderRecursive(arr,i,k) +
                    matrixChainOrderRecursive(arr,k+1,j) +
                    (arr[i-1] * arr[k] * arr[j]);
            min = Math.min(count,min);
        }
        return min;
    }
}
