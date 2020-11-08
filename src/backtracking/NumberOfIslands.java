package backtracking;

public class NumberOfIslands {
    public static void main(String[] args) {
//        char[][] grid = {
//                {'1','1','1','1','0'},
//                {'1','1','0','1','0'},
//                {'1','1','0','0','0'},
//                {'0','0','0','0','0'}
//        };
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        int result = numOfIslands(grid);
        System.out.println("Number of Islands are " + result);
    }

    private static int numOfIslands(char[][] grid){
        if(grid == null || grid.length == 0){
            return 0;
        }
        int numIslands = 0;

        for(int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    numIslands += dfs(grid,i,j);
                }
            }
        }

        return numIslands;
    }

    private static int dfs(char[][] grid, int i, int j) {
        if(i < 0 || i >=  grid.length
            || j < 0 || j >= grid[0].length
            || grid[i][j] == '0'){
                return 0;
        }

        grid[i][j] = '0';
        dfs(grid,i+1,j); // DOWN
        dfs(grid,i-1,j); // UP
        dfs(grid,i,j+1); // RIGHT
        dfs(grid,i,j-1); // LEFT

        return 1;
    }

}
