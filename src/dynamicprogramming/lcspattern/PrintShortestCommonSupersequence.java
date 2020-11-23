package dynamicprogramming.lcspattern;

public class PrintShortestCommonSupersequence {
    // Question Link : https://www.geeksforgeeks.org/print-shortest-common-supersequence/
    // Reference Link : https://www.youtube.com/watch?v=VDhRg-ZJTuc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=29&ab_channel=AdityaVerma
    public static void main(String[] args) {
        String str1 = "HELLO"; // "AGGTAB";
        String str2 = "GEEK"; // "GXTXAYB";
        int[][] result = lcs(str1,str2);
        String resultantString = printSCS(str1,str2,result);
        System.out.println("The Shortest common subsequence is " + resultantString);
    }

    private static String printSCS(String str1, String str2, int[][] result) {
        StringBuilder sb = new StringBuilder();
        int i = str1.length();
        int j = str2.length();
        while (i > 0 && j > 0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            } else if(result[i-1][j] > result[i][j-1]){
                sb.append(str1.charAt(i-1));
                i--;
            } else {
                sb.append(str2.charAt(j-1));
                j--;
            }
        }
        while (i > 0 ){
            sb.append(str1.charAt(i-1));
            i--;
        }
        while (j > 0){
            sb.append(str2.charAt(j-1));
            j--;
        }
        return sb.reverse().toString();
    }

    private static int[][] lcs(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for(int i = 0; i < str1.length() + 1; i++){
            dp[i][0] = 0;
        }
        for(int i = 0; i < str2.length() + 1; i++){
            dp[0][i] = 0;
        }

        for(int i = 1; i < str1.length() + 1; i++){
            for(int j = 1; j < str2.length(); j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp;
    }
}
