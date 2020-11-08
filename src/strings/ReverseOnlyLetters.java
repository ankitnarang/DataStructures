package strings;

public class ReverseOnlyLetters {

    public static void main(String[] args) {
        String str = "Test1ng-Leet=code-Q!"; //"ab-cde"
        System.out.println("Reverse of string is " + reverse(str));
    }

    private static String reverse(String str){
       char[] characters = str.toCharArray();
       int i = 0;
       int j = characters.length - 1;
       while (i < j){
           while (i < j && !Character.isLetter(characters[i])){
               i++;
           }
           while (j > i && !Character.isLetter(characters[j])){
               j--;
           }
           char temp = characters[i];
           characters[i] = characters[j];
           characters[j] = temp;
           i++;
           j--;
       }
        return new String(characters);
    }

}
