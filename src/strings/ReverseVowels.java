package strings;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {

    public static void main(String[] args) {
        String str = "leetcode";
        System.out.println("The String \'" + str + "\' after reversing the vowels is \'" + reverse(str) + "\'");
    }

    private static String reverse(String str) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('A');
        vowels.add('a');
        vowels.add('E');
        vowels.add('e');
        vowels.add('I');
        vowels.add('i');
        vowels.add('O');
        vowels.add('o');
        vowels.add('U');
        vowels.add('u');

        char[] result = str.toCharArray();

        int i = 0;
        int j = result.length - 1;

        while (i < j){
            while (i < j && !vowels.contains(result[i])){
                i++;
            }
            while (i < j && !vowels.contains(result[j])){
                j--;
            }
            char temp = result[i];
            result[i] = result[j];
            result[j] = temp;
            i++;
            j--;
        }
        return new String(result);
    }
}
