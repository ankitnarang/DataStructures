package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String str = "treedte";
        String result = frequencySort(str);
        System.out.println("Result is " + result);
    }

    private static String frequencySort(String str) {

        Map<Character,Integer> map = new HashMap<>();
        for(char ch : str.toCharArray() ){
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());

        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()){
            char current = maxHeap.remove();
            for(int i = 0; i < map.get(current); i++){
                result.append(current);
            }
        }

        return result.toString();
    }
}
