package dynamicprogramming.lcspattern;

public class MinimumInsertionsToMakeStringPalindromic {
    // Reference Link : https://www.youtube.com/watch?v=CFwCCNbRuLY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=28&ab_channel=AdityaVerma
    // Question Link : https://www.geeksforgeeks.org/minimum-insertions-to-form-a-palindrome-dp-28/
    public static void main(String[] args) {
        String str = "abcde";
        int len = str.length();
        int lps = lps(str);
        int min = len - lps;
        System.out.println("Minimum number of insertions from String " + str +
                " to make it palindromic is " + min);
    }

    private static int lps(String str) {
        String reverse = new StringBuilder(str).reverse().toString();
        int lps = lcs(str,reverse);
        return lps;
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
}
