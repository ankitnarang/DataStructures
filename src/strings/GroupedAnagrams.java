package strings;

import java.util.*;

public class GroupedAnagrams {
    public static void main(String[] args) {
        String[] strs = {
                "eat",
                "tea",
                "tan",
                "ate",
                "nat",
                "bat"
        };

        List<List<String>> result = groupAnagrams(strs);
        result.forEach((x) -> System.out.println(x));
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groupedAnagrams = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String current : strs){
            char[] characters = current.toCharArray();
            Arrays.sort(characters);
            String sortedString = new String(characters);

            if(!map.containsKey(sortedString)){
                map.put(sortedString,new ArrayList<>());
            }

            map.get(sortedString).add(current);
        }

        groupedAnagrams.addAll(map.values());
        return groupedAnagrams;
    }
}
