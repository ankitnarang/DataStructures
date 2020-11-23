package dynamicprogramming.lcspattern;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String str1 = "zxabcdezy"; //"aaaaaa";
        String str2 =  "yzabcdezx"; //"ababab";
        int count = 0;
        int result = longestCommonSubstringRecursive(str1,str2,str1.length(),str2.length(),count);
        System.out.println("Length of Longest Common Substring is " + result);
        result = longestCommonSubstringIterative(str1,str2,str1.length(),str2.length());
        System.out.println("Length of Longest Common Substring is " + result);
    }

    private static int longestCommonSubstringIterative(String str1, String str2, int m, int n) {
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        int result = 0;

        for(int i = 0; i < str1.length() + 1; i++){
            for(int j = 0; j < str2.length() + 1; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                } else if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    result = Math.max(result,dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return result;
    }

    private static int longestCommonSubstringRecursive(String str1, String str2, int i, int j, int count) {
        if(i == 0 || j == 0){
            return count;
        }
        if(str1.charAt(i-1) == str2.charAt(j-1)){
            count = longestCommonSubstringRecursive(str1,str2,i-1,j-1,count+1);
        }
        count = Math.max(count,
                    Math.max(longestCommonSubstringRecursive(str1,str2,i,j-1,0),
                    longestCommonSubstringRecursive(str1,str2,i-1,j,0))
                );
        return count;
    }
}
