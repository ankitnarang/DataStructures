package arrays;

public class Equilibrium {
    public static void main(String[] args) {
        int[] arr = {1,2,3}; // {-7, 1, 5, 2, -4, 3, 0};
        int result = equilibrium(arr);
        if(result != -1){
            System.out.println("The equlibrium index in the array is " + result);
        } else {
            System.out.println("There's no equlibrium index in the array.");
        }
    }

    private static int equilibrium(int[] arr) {
        int index = 0;
        int sum = 0;
        for(int num : arr){
            sum += num;
        }
        int leftSum = 0;
        for(int i = 0; i < arr.length; i++){
            sum -= arr[i];
            if(sum == leftSum){
                return i;
            }
            leftSum += arr[i];
        }

        return -1;
    }
}
