package strings;

import java.util.HashMap;
import java.util.Map;

public class RansomNotes {

    public static void main(String[] args) {
        String ransomNotes = "caa";
        String magazine = "abbca";
        System.out.println("Can we form " + ransomNotes +
                " from " + magazine + " ? " + canConstruct(ransomNotes,magazine));
    }

    private static boolean canConstruct(String ransomNotes, String magazine) {
        Map<Character,Integer> counts = new HashMap<>();
        for(char c : magazine.toCharArray()){
            counts.put(c, counts.getOrDefault(c,0) + 1);
        }
        for(char c : ransomNotes.toCharArray()){
            if(!counts.containsKey(c) || counts.get(c) <= 0){
                return false;
            }
            counts.put(c,counts.get(c) - 1);
        }
        return true;
    }
}
