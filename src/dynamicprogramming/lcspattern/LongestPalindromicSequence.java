package dynamicprogramming.lcspattern;

public class LongestPalindromicSequence {
    // Reference Link : https://www.youtube.com/watch?v=wuOOOATz_IA&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=26&ab_channel=AdityaVerma
    // Question Link : https://www.geeksforgeeks.org/longest-palindromic-subsequence-dp-12/
    public static void main(String[] args) {
        String sequence = "GEEKSFORGEEKS"; // "BBABCBCAB";
        int n = sequence.length();
        System.out.println("The Length of LPS is " + lps(sequence.toCharArray(),0,n-1));
        System.out.println("The Length of LPS is (using lcs approach) " + lpsAnotherApproach(sequence));
    }

    private static int lpsAnotherApproach(String sequence) {
        String reverse = new StringBuilder(sequence).reverse().toString();
        int lcs = lcs(sequence,reverse);
        return lcs;
    }

    private static int lcs(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m+1][n+1];

        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                } else if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }

    //Recursive Approach
    private static int lps(char[] sequence, int i, int j){
        if(i == j){
            return 1;
        }
        if((sequence[i] == sequence[j]) && i+1 == j){
            return 2;
        }
        if(sequence[i] == sequence[j]){
            return lps(sequence,i+1,j-1) + 2;
        }

        return Math.max(lps(sequence,i+1,j),
                lps(sequence,i,j-1));
    }

}
