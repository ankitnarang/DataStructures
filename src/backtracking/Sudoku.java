package backtracking;

public class Sudoku {
    public static void main(String[] args) {
        int[][] board = new int[][] {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };

        int len = board.length;
        if(solveSudko(board,len)){
            printBoard(board,len);
        } else {
            System.out.println("No solution.");
        }
    }

    private static void printBoard(int[][] board, int len) {
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean solveSudko(int[][] board, int len){
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if(!isEmpty){
                break;
            }
        }

        if(isEmpty){
            return true;
        }

        for(int num = 1; num <= len; num++){
            if(isSafeBoard(board,row,col,num)) {
                board[row][col] = num;
                if (solveSudko(board, len)) {
                    return true;
                } else {
                    board[row][col] = 0;
                }
            }
        }

        return false;
    }

    private static boolean isSafeBoard(int[][] board, int row, int col, int num) {
        for(int i = 0; i < board.length; i++){
            if(board[row][i] == num){
                return false;
            }
        }

        for(int i = 0; i < board.length; i++){
            if(board[i][col] == num){
                return false;
            }
        }

        int sqrt = (int)Math.sqrt(board.length);
        int boxRowStart = (row/sqrt) * sqrt;
        int boxColStart = (col/sqrt) * sqrt;

        for(int i = boxRowStart; i < boxRowStart + sqrt; i++){
            for(int j = boxColStart; j < boxColStart + sqrt; j++){
                if(board[i][j] == num){
                    return false;
                }
            }
        }

        return true;
    }

}
