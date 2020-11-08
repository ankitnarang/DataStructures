package strings;

import org.w3c.dom.ls.LSOutput;

public class PalindromeString {

    public static void main(String[] args) {
        String s = "race a car";  //"A man, a plan, a canal: Panama";
        boolean result = isPalindrome(s);
        System.out.println("Is String " + s  + " valid palindrome? " + result);
    }

    private static boolean isPalindrome(String s) {

        int i = 0;
        int j = s.length() - 1;

        while (i < j){
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }

            while (i < j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }

            if (i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)) ){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

}
