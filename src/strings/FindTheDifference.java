package strings;

import java.util.HashMap;
import java.util.Map;

/*
    Find the different letter added in second string

 */

public class FindTheDifference {
    public static void main(String[] args) {
        String str1 = "abfcd";
        String str2 = "abcd";

        System.out.println("The difference in the character " +
                "between 2 strings is " + findDifference(str1,str2));

    }

    private static char findDifference(String str1, String str2) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c : str1.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c) + 1);
            } else {
                map.put(c,1);
            }
        }

        for(char c : str2.toCharArray()){
            if((map.containsKey(c) && map.get(c) == 0) || !map.containsKey(c)){
                return c;
            } else {
                map.put(c,map.get(c) - 1);
            }
        }

        return '!';
    }
}
