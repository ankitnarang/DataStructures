package dynamicprogramming.matrixchainmultiplicationpattern;

import java.util.HashMap;
import java.util.Map;

public class ScrambleString {
    // Reference Link :
    // Question Link :
    static Map<String,Boolean> map;
    public static void main(String[] args) {
        String str1 = "phqtrnilf"; // "we";
        String str2 = "ilthnqrpf"; // "we";
        boolean result = false;
        if(str1.length() != str2.length()){
            System.out.println("They are not scrambled string.");
        }
        result = isScrambleRecursive(str1,str2);
        if(result == true){
            System.out.println("They are scrambled string.");
        } else {
            System.out.println("They are not scrambled string.");
        }

        map = new HashMap<>();
        result = isScrambleIterative(str1,str2);
        if(result == true){
            System.out.println("They are scrambled string.");
        } else {
            System.out.println("They are not scrambled string.");
        }
    }

    private static boolean isScrambleIterative(String str1, String str2) {
        if(str1.equals(str2)){
            return true;
        }
        if(str1.length() <= 1){
            return false;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(str1);
        sb.append(" ");
        sb.append(str2);
        String key = sb.toString();
        if(map.containsKey(key)){
            return map.get(key);
        }

        int n = str1.length();
        for(int i = 1; i < n; i++){
            if( (isScrambleIterative(str1.substring(0,i),str2.substring(n-i)) == true)
                    && (isScrambleIterative(str1.substring(i),str2.substring(0,n-i)) == true) ){
                return true;
            }
            if( (isScrambleIterative(str1.substring(0,i),str2.substring(0,i)) == true)
                    && (isScrambleIterative(str1.substring(i),str2.substring(i)) == true) ){
                return true;
            }
        }
        map.put(key,false);
        return false;
    }

    private static boolean isScrambleRecursive(String str1, String str2) {
        if(str1.equals(str2)){
            return true;
        }
        if(str1.length() <= 1){
            return false;
        }

        int n = str1.length();
        for(int i = 1; i < n; i++){
            if( (isScrambleRecursive(str1.substring(0,i),str2.substring(n-i)) == true)
                && (isScrambleRecursive(str1.substring(i),str2.substring(0,n-i)) == true) ){
                return true;
            }
            if( (isScrambleRecursive(str1.substring(0,i),str2.substring(0,i)) == true)
                    && (isScrambleRecursive(str1.substring(i),str2.substring(i)) == true) ){
                return true;
            }
        }
        return false;
    }
}
