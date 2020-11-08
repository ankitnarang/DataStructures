package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        String digits = "279";
        result = letterCombinations(digits);
        result.forEach((x) -> System.out.print(x + " "));
    }

    private static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return result;
        }

        String[] mapping = {
                "0",
                "1",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };

        letterCombinationsRecursive(result,digits,mapping,"",0);
        return result;
    }

    private static void letterCombinationsRecursive(List<String> result, String digits,
                                                    String[] mapping, String current, int index) {
        if(index == digits.length()){
            result.add(current);
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];
        for(int i = 0; i < letters.length(); i++){
            letterCombinationsRecursive(result,digits,mapping,current + letters.charAt(i),index+1);
        }

    }
}
