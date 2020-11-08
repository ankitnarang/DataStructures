package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetectCapitals {
    public static void main(String[] args) {
        String[] words = {
                "USA",
                "Flag",
                "flaG",
                "leetcode",
                "flAg"
        };
        List<Boolean> result = detectCapitalUse(words);
        result.forEach((x) -> System.out.println(x));
    }

    private static List<Boolean> detectCapitalUse(String[] words) {
        List<Boolean> resultList = new ArrayList<>();
        for(String word : words){
            int count = 0;
            for(char ch : word.toCharArray()){
                if(Character.isUpperCase(ch)){
                    count++;
                }
            }
            boolean result = (count == word.length())
                    || (count == 0)
                    || (count == 1 && Character.isUpperCase(word.charAt(0)));
            resultList.add(result);
        }
        return resultList;
    }
}
