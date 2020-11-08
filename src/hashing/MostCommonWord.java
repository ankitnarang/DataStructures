package hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MostCommonWord {
    public static void main(String[] args) {
        String paragraph = "Bob hit a ball the hit BALL flew far after it was hit";
        String[] banned = {"hit"};
        String result = mostCommonWord(paragraph,banned);
        System.out.println("Result is " + result);
    }

    private static String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedWords = new HashSet<>();
        for(String word : banned){
            bannedWords.add(word);
        }

        HashMap<String,Integer> counts = new HashMap<>();
        String[] words = paragraph.replaceAll("[^a-zA-Z]"," ").toLowerCase().split(" ");
        for(String word : words){
            if(!bannedWords.contains(word)){
                counts.put(word,counts.getOrDefault(word,0) + 1);
            }
        }

        String result = "";
        for(String key : counts.keySet()){
            if(result.equals("") || counts.get(key) > counts.get(result)){
                result = key;
            }
        }

        return result;
    }

}
