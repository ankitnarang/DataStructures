package arrays;

import java.util.Arrays;

public class MaximumProductOfSubsequenceOfSizeK {
    public static void main(String[] args) {
        int[] arr = {1,2,-1,-3,-6,4}; //{1,2,0,3};
        int k = 4;
        int result = maxProduct(arr,k);
        System.out.println("The max product is " + result);
    }

    public static int maxProduct(int[] arr, int k){
        int product = 1;
        Arrays.sort(arr);
        int n = arr.length;
        if((arr[n-1] == 0) && (k%2 != 0)){
            product = 0;
            return product;
        }

        if((arr[n-1] < 0) && (k%2 != 0)){
            for(int i = n-1 ; i >= n-k; i--){
                product *= arr[i];
            }
            return product;
        }

        int i = 0;
        int j = n-1;

        if(k%2 != 0){
           product *= arr[j];
           j--;
           k++;
        }

        k >>= 1;

        for(int itr = 0; itr < k; itr++){
            int leftProduct = arr[i] * arr[i+1];
            int rightProduct = arr[j] * arr[j-1];

            if(leftProduct > rightProduct){
                product *= leftProduct;
                i += 2;
            } else {
                product *= rightProduct;
                j -= 2;
            }

        }

        return product;
    }

}
