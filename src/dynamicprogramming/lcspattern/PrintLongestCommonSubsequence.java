package dynamicprogramming.lcspattern;

public class PrintLongestCommonSubsequence {
    // Question Link : https://www.geeksforgeeks.org/printing-longest-common-subsequence/
    // Reference Link : https://www.youtube.com/watch?v=x5hQvnUcjiM&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=23&ab_channel=AdityaVerma
    public static void main(String[] args) {
        String str1 = "abbcdgf"; //"aaaaaa";
        String str2 =  "bbadcgf"; //"ababab";

        int result[][] = lcsIterative(str1,str2);
        String res = printLCS(result,str1,str2);
        System.out.println("longest common subsequence is " + res);
    }

    private static String printLCS(int[][] result, String str1, String str2) {
        int i = str1.length();
        int j = str2.length();
        StringBuilder sb = new StringBuilder("");
        while (i > 0 && j > 0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            } else if(result[i-1][j] > result[i][j-1]){
                i--;
            } else {
                j--;
            }
        }
        return sb.reverse().toString();
    }

    private static int[][] lcsIterative(String str1, String str2) {
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

        return dp;
    }

}
