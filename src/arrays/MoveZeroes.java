package arrays;

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] array = {0,1,0,3,12};
        System.out.println("Before moving Array");
        for(int i : array){
            System.out.print(i + " ");
        }
        move(array);
        System.out.println("\nAfter moving Array");
        for(int i : array){
            System.out.print(i + " ");
        }
    }

    private static void move(int[] array) {
        int index = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] != 0){
                array[index++] = array[i];
            }
        }
        for(int i = index; i < array.length; i++){
            array[i] = 0;
        }
    }
}
