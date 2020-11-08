package strings;

/*
    Verify the words are in lexicographically order
    Given dictionary as order of letter, fixed of 26 length
    Arrays of string as words,
 */

public class VerifyingAlienDictionary {

    public static void main(String[] args) {
        String[] words =  {"hello","leetcode"}; //{"apple","app"};// {"word","world","row"}; //;
        String order = "hlabcdefgijkmnopqrstuvwxyz"; // // "abcdefghijklmnopqrstuvwxyz"; // "worldabcefghijkmnpqstuvxyz";
        System.out.println("Are words sorted according to Alien Dictionary? " + isAlienSorted(words,order));
    }

    private static boolean isAlienSorted(String[] words, String order){
        int[] alphabets = new int[26];

        for(int i = 0; i < 26; i++){
            alphabets[order.charAt(i) - 'a'] = i;
        }

        for(int i = 0; i < words.length; i++){
            for(int j = i + 1; j < words.length; j++){
                int min = Math.min(words[i].length(),words[j].length());
                for(int k = 0; k < min; k++){
                    char iChar = words[i].charAt(k);
                    char jChar = words[j].charAt(k);
                    if(alphabets[iChar - 'a'] < alphabets[jChar - 'a']){
                        break;
                    } else if (alphabets[jChar - 'a'] < alphabets[iChar - 'a']) {
                        return false;
                    } else if(k == min - 1 && words[i].length() > words[j].length()) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

}
