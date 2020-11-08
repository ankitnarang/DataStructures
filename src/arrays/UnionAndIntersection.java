package arrays;

import java.util.Arrays;

public class UnionAndIntersection {
    public static void main(String[] args) {
        int arr1[] = {7, 1, 5, 2, 3, 6};
        int arr2[] = {3, 8, 6, 20, 7};
        int m = arr1.length;
        int n = arr2.length;
        System.out.println("Union of 2 arrays is : ");
        printUnion(arr1,arr2);
        System.out.println("\nInteresction of 2 arrays is : ");
        printIntersection(arr1,arr2);
    }

    private static void printUnion(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        if(m > n){
            int[] temp = arr1;
            arr1 = arr2;
            arr2 = temp;
        }
        m = arr1.length;
        n = arr2.length;

        Arrays.sort(arr1);

        for(int i = 0; i < m; i++){
            System.out.print(arr1[i] + " ");
        }

        for(int i = 0; i < n; i++){
            if( (binarySearch(arr1,0,m-1,arr2[i])) == -1 ){
                System.out.print(arr2[i] + " ");
            }
        }


    }

    private static void printIntersection(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        if(m > n){
            int[] temp = arr1;
            arr1 = arr2;
            arr2 = temp;
        }
        m = arr1.length;
        n = arr2.length;

        Arrays.sort(arr1);

        /*
        for(int i = 0; i < m; i++){
            System.out.print(arr1[i] + " ");
        }
        */

        for(int i = 0; i < n; i++){
            if( (binarySearch(arr1,0,m-1,arr2[i])) != -1 ){
                System.out.print(arr2[i] + " ");
            }
        }


    }

    private static int binarySearch(int[] arr, int left, int right, int num) {
        if(right >= left){
            int mid = left + (right - left)/2;

            if(arr[mid] == num){
                return mid;
            }
            if (arr[mid] > num){
                //right = mid - 1;
                return binarySearch(arr,left,mid - 1, num);
            }

            return binarySearch(arr,mid + 1,right, num);
        }
        return -1;
    }

}
