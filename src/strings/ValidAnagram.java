package strings;

public class ValidAnagram {

    public static void main(String[] args) {
        String str1 = "anddgram";
        String str2 = "grdmnaad";
        System.out.println("Is " + str1 + " and " +
                str2 + " Anagrams of each other ? " + isAnagram(str1,str2));
    }

    private static boolean isAnagram(String str1, String str2) {
        if(str1.length() != str2.length()){
            return  false;
        }

        int[] counts = new int[26];

        for (int i = 0; i < str1.length(); i++){
            counts[str1.charAt(i) - 'a']++;
            counts[str2.charAt(i) - 'a'] --;
        }

        for(int num : counts){
            if(num != 0 ){
                return false;
            }
        }

        return true;
    }
}
