package arrays;

/*
    Array of integers is valid mountain array iff
        there exist i such that :
        A[0] < A[1] < A[2] ... < A[i]
        A[i+1] > A[i+2] > A[i+3] > .... > A[length - 1]
 */

public class ValidMountainArray {

    public static void main(String[] args) {
        int[] array = {3,5,5}; //{0,3,2,1};;//{2,1};
        System.out.println("Is this array is Valid Mountain Array ? " + validMountainArray(array));
    }

    private static boolean validMountainArray(int[] array) {
        int i = 0;
        while (i < array.length && i+1 < array.length && array[i] < array[i+1]){
            i++;
        }

        if(i == 0 || i+1 >= array.length){
            return false;
        }

        while(i  < array.length && i+1 < array.length){
            if(array[i] <= array[i+1]){
                return false;
            }
            i++;
        }

        return true;
    }
}
