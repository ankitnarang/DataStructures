package strings;

public class ValidPalindromeII {

    public static void main(String[] args) {
        String str = "abcda"; // "aba" // "abca"
        System.out.println("Can we remove atmost 1 character from string "
                + str + " and still mak rest of string as palindrome ? " + validPalindrome(str));
    }

    private static boolean validPalindrome(String str) {
        int i = 0;
        int j = str.length()-1;
        while (i < j ){
            if(str.charAt(i) != str.charAt(j)){
                return isPalindrome(str,i+1,j) || isPalindrome(str,i,j-1);
            }
            i++;
            j--;
        }
        return true;
    }

    private static boolean isPalindrome(String str, int i, int j) {
        while (i < j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return  true;
    }
}
