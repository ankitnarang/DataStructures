package arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int [] arr = {0,1,2,2,3,0,4,2}; // {3,2,2,3};
        int value = 2;
        int lastIndex = removeElement(arr,value);
        for(int i = 0; i < lastIndex; i++){
            System.out.print(arr[i] + " ");
        }
    }

    private static int removeElement(int[] arr, int value) {
        int index = 0;
        for(int num : arr){
            if(num != value){
                arr[index] = num;
                index++;
            }
        }

        return index;
    }
}
