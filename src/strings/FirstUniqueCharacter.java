package strings;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println("The index of the first unique character in the \'"
                + s  + "\' is " + firstUniqueCharacter(s));

    }

    private static int firstUniqueCharacter(String s) {
        Map<Character,Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch, i);
            } else {
                map.put(ch, -1);
            }
        }

        int min = Integer.MAX_VALUE;
        for(char ch : map.keySet()){
            if(map.get(ch) > -1 && map.get(ch) < min){
                min = map.get(ch);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min ;
    }

}
