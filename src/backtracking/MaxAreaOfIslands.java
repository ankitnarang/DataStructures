package backtracking;

public class MaxAreaOfIslands {
    public static void main(String[] args) {
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        int result = maxArea(grid);
        System.out.println("Maximum aread of the island is " + result);
    }

    public static int maxArea(int[][] grid){
        int max = 0;

        if(grid == null || grid.length == 0){
            return 0;
        }

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    max = Math.max(max,dfs(grid,i,j));
                }
            }
        }

        return max;
    }

    private static int dfs(int[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length
                || j < 0 || j >= grid[0].length
                || grid[i][j] == 0){
            return 0;
        }

        grid[i][j] = 0;
        int count = 1;
        count += dfs(grid,i+1,j);
        count += dfs(grid,i-1,j);
        count += dfs(grid,i,j+1);
        count += dfs(grid,i,j-1);

        return count;
    }

}
