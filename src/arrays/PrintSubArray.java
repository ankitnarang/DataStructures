package arrays;

public class PrintSubArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        printSubArray(arr);
    }

    private static void printSubArray(int[] arr) {
        for (int i = 0; i < arr.length; i++){
            for (int j = i; j < arr.length; j++){
                for (int k = i; k <= j;k++){
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
        }
    }
}
