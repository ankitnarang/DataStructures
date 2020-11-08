package graph;

public class WallsAndGates {
    public static void main(String[] args) {
        int[][] rooms = {
                {2147483647,-1,0,2147483647},
                {2147483647,2147483647,2147483647,-1},
                {2147483647,-1,2147483647,-1},
                {0,-1,2147483647,2147483647},
        };
        System.out.println("Rooms are");
        printRooms(rooms);
        wallsAndGates(rooms);
        System.out.println("After processing, Rooms are");
        printRooms(rooms);
    }

    private static void printRooms(int[][] rooms) {
        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[i].length; j++){
                System.out.print(rooms[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0){
            return;
        }

        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[i].length; j++){
               if(rooms[i][j] == 0){
                   dfs(i,j,0,rooms);
               }
            }
        }

    }

    private static void dfs(int i, int j, int count, int[][] rooms) {
        if(i < 0 || i >= rooms.length
            || j < 0 || j >= rooms[i].length
            || rooms[i][j] < count){
            return;
        }

        rooms[i][j] = count;
        dfs(i+1,j,count+1,rooms);
        dfs(i-1,j,count+1,rooms);
        dfs(i,j+1,count+1,rooms);
        dfs(i,j-1,count+1,rooms);
    }
}
