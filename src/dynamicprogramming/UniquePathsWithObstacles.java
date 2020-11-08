package dynamicprogramming;

import java.util.Arrays;

public class UniquePathsWithObstacles {
    private int[][] array;
    private int[][] mem;
    public static void main(String[] args) {
        UniquePathsWithObstacles obj = new UniquePathsWithObstacles();
        int[][] array = {
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };

        int result = obj.uniquePathsRecursive(array);
        System.out.println("No. of unique paths is " + result);

        result = obj.uniquePathsNonRecursive(array);
        System.out.println("No. of unique paths is " + result);
    }

    private int uniquePathsNonRecursive(int[][] array) {
        if(array == null){
            return 0;
        }

        int m = array.length;
        int n = array[0].length;

        if(m == 0 || n == 0){
            return 0;
        }

        this.mem = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++ ){
                mem[i][j] = 0;
            }
        }

        if(array[0][0] == 0){
            mem[0][0] = 1;
        }

        this.array = array;

        for(int i = 1; i < m; i++){
            if(array[i][0] == 0){
                mem[i][0] = mem[i-1][0];
            }
        }

        for(int i = 1; i < n; i++){
            if(array[0][i] == 0){
                mem[0][i] = mem[0][i-i];
            }
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++ ){
                if(array[i][j] == 0){
                    mem[i][j] = mem[i-1][j] + mem[i][j-1];
                }
            }
        }

        return mem[m-1][n-1];
    }

    private int uniquePathsRecursive(int[][] array) {
        if(array == null){
            return 0;
        }

        int m = array.length;
        int n = array[0].length;

        if(m == 0 || n == 0){
            return 0;
        }

        this.mem = new int[m][n];

        for(int i = 0; i < m; i++){
            Arrays.fill(mem[i],-1);
        }

        this.array = array;

        if(array[0][0] == 0){
            mem[0][0] = 1;
        }

        uniquePaths(m-1,n-1);
        return mem[m-1][n-1];
    }

    private int uniquePaths(int i, int j) {
        if(i < 0 || j < 0){
            return 0;
        }

        if(mem[i][j] != -1){
            return mem[i][j];
        }

        if(array[i][j] == 1){
            mem[i][j] = 0;
            return mem[i][j];
        }

        mem[i][j] = uniquePaths(i,j-1) + uniquePaths(i-1,j);

        return mem[i][j];
    }


}
