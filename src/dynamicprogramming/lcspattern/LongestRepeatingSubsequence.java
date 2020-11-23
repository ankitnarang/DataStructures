package dynamicprogramming.lcspattern;

public class LongestRepeatingSubsequence {
    // Question Link : https://www.geeksforgeeks.org/longest-repeated-subsequence/
    // Reference Link : https://www.youtube.com/watch?v=hbTaCmQGqLg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=30&ab_channel=AdityaVerma
    public static void main(String[] args) {
        String str =  "abb";// "AABEBCDD";
        int[][] result = lcs(str);
        String resultant = printLCS(str,result);
        System.out.println("The Longest repeating sub sequence is " + resultant);
    }

    private static String printLCS(String str, int[][] result) {
        int i = str.length();
        int j = str.length();
        StringBuilder sb = new StringBuilder("");
        while (i > 0 && j > 0){
            if(result[i][j] == result[i-1][j-1] + 1){
                sb.append(str.charAt(i-1));
                i--;
                j--;
            } else if(result[i][j] == result[i-1][j]){
                i--;
            } else {
                j--;
            }
        }
        return sb.reverse().toString();
    }

    private static int[][] lcs(String str) {
        int n = str.length();

        int[][] dp = new int[n+1][n+1];

        for(int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = 0;
            }
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
               if( (str.charAt(i-1) == str.charAt(j-1)) && (i != j) ) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp;
    }
}
