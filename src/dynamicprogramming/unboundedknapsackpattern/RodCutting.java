package dynamicprogramming.unboundedknapsackpattern;

public class RodCutting {
    //Question Link : https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
    // Reference Link : https://www.youtube.com/watch?v=SZqAQLjDsag&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=14&ab_channel=AdityaVerma
    /*
        Intuition :
        This rod cutting problem is exactly same as knapsack unbounded problem
        Here price is same as value in knapsack unbounded
        lengthOfRod is same as weight in knapsack unbounded
        L is same as W
        code is same as knapsack unbounded
     */
    public static void main(String[] args) {
        int[] price = {3,5,8,9,10,17,17,20}; // {1, 5, 8, 9, 10, 17, 17, 20};
        int[] lengthOfRod = new int[price.length];
        int L = price.length;
        int n = lengthOfRod.length;
        for(int i = 0; i < lengthOfRod.length; i++){
            lengthOfRod[i] = i+1;
        }
        int result = cutRod(price,lengthOfRod,L,n);
        System.out.println("Maximum price " + result);
    }

    private static int cutRod(int[] price, int[] lengthOfRod, int L, int n) {
        if(L == 0 || n == 0){
            return 0;
        }
        if(lengthOfRod[n-1] > L){
            return cutRod(price,lengthOfRod,L,n-1);
        } else {
            return Math.max(cutRod(price,lengthOfRod,L,n-1),
                    price[n-1] + cutRod(price,lengthOfRod,L - lengthOfRod[n-1],n));
        }
    }
}
