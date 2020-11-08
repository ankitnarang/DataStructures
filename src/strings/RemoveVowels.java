package strings;

import java.util.HashSet;
import java.util.Set;

public class RemoveVowels {

    public static void main(String[] args) {
        String str = "leetcodeiscommunityforcoders";
        System.out.println("The String \'" + str + "\' after removing the vowels is \'" + removeVowels(str) + "\'");
    }

    private static String removeVowels(String str) {
        StringBuilder result = new StringBuilder();
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        for (char ch : str.toCharArray()){
            if(!vowels.contains(ch)){
                result.append(ch);
            }
        }
        return result.toString();
    }

}
