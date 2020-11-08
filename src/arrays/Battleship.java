package arrays;

public class Battleship {
    public static void main(String[] args) {
        char[][] board = {
                {'X','.','.','X'},
                {'.','.','.','X'},
                {'.','.','.','X'},
        };
        int result = countBattleships(board);
        System.out.println("The no of battleships is " + result);
    }

    private static int countBattleships(char[][] board){
        int noOfBattleships = 0;

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'X'){
                    noOfBattleships++;
                    sink(board,i,j);
                }
            }
        }

        return noOfBattleships;
    }

    private static void sink(char[][] board, int i, int j) {
        if(i < 0 || i >= board.length
                || j < 0 || j >= board[i].length || board[i][j] != 'X'){
            return;
        }

        board[i][j] = '.';
        sink(board,i+1,j);
        sink(board,i-1,j);
        sink(board,i,j+1);
        sink(board,i,j-1);

    }

}
