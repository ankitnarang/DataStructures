package arrays;

import java.util.Arrays;
import java.util.stream.Stream;

public class FlippingAnImage {
    public static void main(String[] args) {
        //int[][] array = {{1,1,0},{1,0,1},{0,0,0}};
        int[][] array = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        System.out.println("Before Flipping the array ");
        printArray(array);
        int result[][] = solve(array);
        System.out.println("After Flipping the array ");
        printArray(result);
    }

    private static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[0].length;j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] solve(int[][] array) {
        int rowSize = array.length;
        int colSize = array[0].length;

        for(int i = 0; i < rowSize; i++){
            int j = 0;
            int k = colSize - 1;
            while (j < k){
                int temp = array[i][j];
                array[i][j] = array[i][k];
                array[i][k] = temp;
                j++;
                k--;
            }
            for(j = 0; j < colSize; j++){
                array[i][j] = array[i][j] == 0 ? 1 : 0;
            }
        }

        return array;
    }
}
