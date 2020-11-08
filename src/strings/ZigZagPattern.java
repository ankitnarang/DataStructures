package strings;

import java.util.Arrays;

public class ZigZagPattern {
    public static void main(String[] args) {
        String str = "GEEKSFORGEEKS";
        int n = 3;
        zigzag(str,n);
    }

    private static void zigzag(String str, int n) {
        if(n == 1){
            System.out.println(str);
            return;
        }

        char[] input = str.toCharArray();
        int len = str.length();
        String[] arr = new String[n];
        Arrays.fill(arr,"");
        int row = 0;
        boolean down = true;
        for(int i = 0; i < len; i++){
            arr[row] += input[i];
            if(row == n-1){
                down = false;
            } else if (row == 0){
                down = true;
            }

            if(down){
                row++;
            } else {
                row--;
            }
        }

        for(int i = 0 ; i < n; i++){
            System.out.print(arr[i]);
        }
    }
}
