package dynamicprogramming.lcspattern;

public class MinimumInsertionAndDeletion {
    // Reference Link : https://www.youtube.com/watch?v=-fx6aDxcWyg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=25&ab_channel=AdityaVerma
    // Question Link : https://www.geeksforgeeks.org/minimum-number-deletions-insertions-transform-one-string-another/
    public static void main(String[] args) {
        String str1 = "geeksforgeeks"; //""heap";
        String str2 = "geeks"; //"pea";
        int m = str1.length();
        int n = str2.length();
        int lcs = lcsIterative(str1,str2,m,n);
        int del = m - lcs;
        int ins = n - lcs;
        System.out.println("To convert string " + str1 + " to string " +
                str2 + ", number of insertion is " + ins + " and number of deletion is " + del);
    }

    private static int lcsIterative(String str1, String str2, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i < m + 1; i++){
            for(int j = 0; j < n + 1; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                } else if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
