package dynamicprogramming;

public class SubsetSum {
    public static void main(String[] args) {
        int[] set = {3,34,4,12,5,2};
        int sum = 9;
        if(isSubsetSumRecursive(set,sum,set.length) == true){
            System.out.println("Found the subset with given sum");
        } else {
            System.out.println("No subset with given sum");
        }

        set = new int[]{3,34,4,12,5,2};
        sum = 30;
        if(isSubsetSumRecursive(set,sum,set.length) == true){
            System.out.println("Found the subset with given sum");
        } else {
            System.out.println("No subset with given sum");
        }

        set = new int[]{3,34,4,12,5,2};
        sum = 9;
        if(isSubsetSumIterative(set,sum,set.length) == true){
            System.out.println("Found the subset with given sum");
        } else {
            System.out.println("No subset with given sum");
        }

        set = new int[]{3,34,4,12,5,2};
        sum = 30;
        if(isSubsetSumIterative(set,sum,set.length) == true){
            System.out.println("Found the subset with given sum");
        } else {
            System.out.println("No subset with given sum");
        }


    }

    private static boolean isSubsetSumRecursive(int[] set, int sum, int n) {
        if(sum == 0){
            return true;
        }
        if(n == 0){
            return false;
        }

        if(set[n-1] > sum){
            return isSubsetSumRecursive(set,sum,n-1);
        } else {
            return isSubsetSumRecursive(set,sum,n-1) ||
                    isSubsetSumRecursive(set,sum - set[n-1],n-1);
        }
    }

    private static boolean isSubsetSumIterative(int[] set, int sum, int n) {
        boolean[][] subset = new boolean[sum+1][n+1];

        for(int i = 0; i < n + 1; i++){
            subset[0][i] = true;
        }

        for(int i = 0; i < sum + 1; i++){
            subset[i][0] = false;
        }

        for(int i = 1; i < sum + 1; i++){
            for(int j = 1; j < n + 1; j++){
                if( set[j-1] <= i){
                    subset[i][j] = subset[i][j-1] || subset[i-set[j-1]][j-1];
                } else {
                    subset[i][j] = subset[i][j-1];
                }
            }
        }

        return subset[sum][n];
    }


}
