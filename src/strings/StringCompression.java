package strings;

/*
    Given a String, compress String and length of new array
    should be less than length of Original array
    Do In place
    Extra space should be O(1)
 */
public class StringCompression {

    public static void main(String[] args) {
        String str = "aabbb";
        int len;
        len = compress(str.toCharArray());
        System.out.println("For string " + str + ", compressed length of new Array " + len);
        str = "a";
        len = compress(str.toCharArray());
        System.out.println("For string " + str + ", compressed length of new Array " + len);
        str = "abbbbbbbbbbbb";
        len = compress(str.toCharArray());
        System.out.println("For string " + str + ", compressed length of new Array " + len);
    }

    private static int compress(char[] input){
        int i = 0;
        int index = 0;
        while(i < input.length) {
            int j = i;
            while (j < input.length && input[j] == input[i]) {
                j++;
            }

            input[index++] = input[i];
            if (j - i > 1) {
                String count = j - i + "";
                for (char c : count.toCharArray()) {
                    input[index++] = c;
                }
            }
            i = j;
        }

        return index;
    }


}
