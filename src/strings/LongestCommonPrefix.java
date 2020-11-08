package strings;

/*
    Find longest common prefix among the given strings
 */

public class LongestCommonPrefix {


    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        strs = new String[]{"doggedLT", "dogged", "doggedTr"};
        System.out.println("Longest common prefix is " + longestCommonPrefix(strs));
    }

    private static String longestCommonPrefix(String[] strs) {
        String longestCommonPrefix = "";
        if(strs == null || strs.length == 0){
            return longestCommonPrefix;
        }
        int index = 0;
        for(char c : strs[0].toCharArray()){
            for(int i = 0; i < strs.length; i++){
                if(index >= strs[i].length() || c != strs[i].charAt(index)){
                    return longestCommonPrefix;
                }
            }
            longestCommonPrefix += c;
            index++;
        }
        return longestCommonPrefix;
    }
}