package dynamicprogramming.knapsack01pattern;

public class CountSubsetProblem {
    // Question Link : https://www.geeksforgeeks.org/count-of-subsets-with-sum-equal-to-x/
    // Good Reference : https://www.youtube.com/watch?v=F7wqWbqYn9g&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=9&ab_channel=AdityaVerma
    public static void main(String[] args) {
        int[] arr = {1,2,3,3};
        int sum = 6;
        System.out.println("The count of subsets with given sum is " + countSubset(arr,sum,arr.length));

        arr = new int[]{2,3,5,6,8,10};
        sum = 12;
        System.out.println("The count of subsets with given sum is " + countSubset(arr,sum,arr.length));

        arr = new int[]{1,1,1,1};
        sum = 1;
        System.out.println("The count of subsets with given sum is " + countSubset(arr,sum,arr.length));
    }

    private static int countSubset(int[] arr, int sum, int n) {
        if(sum == 0){
            return 1;
        }
        if (n == 0) {
            return 0;
        }

        if(arr[n-1] > sum){
            return countSubset(arr,sum,n-1);
        } else {
            return countSubset(arr,sum,n-1) +
                    countSubset(arr,sum - arr[n-1],n-1);
        }
    }
}
