package dynamicprogramming.lcspattern;

public class LongestCommonSequence {
    //Reference Link : Scalar Video
    public static void main(String[] args) {
        String str1 = "abbcdgf"; //"aaaaaa";
        String str2 =  "bbadcgf"; //"ababab";

        int result = lcsRecursive(str1,str2);
        System.out.println("Length of longest common subsequence is " + result);

        result = lcsIterative(str1,str2);
        System.out.println("Length of longest common subsequence is " + result);

    }

    private static int lcsIterative(String str1, String str2) {
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

    private static int lcsRecursive(String str1, String str2) {
        return lcs(str1.length()-1,str2.length()-1,str1,str2);
    }

    private static int lcs(int i, int j,String str1, String str2){

        if(i < 0 || j < 0){
            return 0;
        }

        if(i == 0 || j == 0){
            return 1;
        }

        if(str1.charAt(i) == str2.charAt(j)){
            return 1 + lcs(i-1,j-1,str1,str2);
        }

        return Math.max(lcs(i,j-1,str1,str2),
                lcs(i-1,j,str1,str2));
    }

}
