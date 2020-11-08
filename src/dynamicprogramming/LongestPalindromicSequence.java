package dynamicprogramming;

public class LongestPalindromicSequence {
    public static void main(String[] args) {
        String sequence = "BBABCBCAB"; //"GEEKSFORGEEKS";
        int n = sequence.length();
        System.out.println("The Length of LPS is " + lps(sequence.toCharArray(),0,n-1));
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
