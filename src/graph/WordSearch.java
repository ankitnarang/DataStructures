package graph;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCCED"; //"ABCB"; //"SEE";

        boolean result = exist(board,word);
        System.out.println("The word exist in char array ? " + result);
    }

    private static boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == word.charAt(0) && dfs(i,j,0,board,word)){
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(int i, int j, int count, char[][] board, String word) {
        if(count == word.length()){
            return true;
        }

        if(i < 0 || i >= board.length
            || j < 0 || j >= board[i].length
            || board[i][j] != word.charAt(count)){
            return false;
        }

        char temp = board[i][j];
        board[i][j] = ' ';
        boolean found = dfs(i+1,j,count + 1, board,word)
                || dfs(i-1,j,count + 1, board,word)
                || dfs(i,j+1,count + 1, board,word)
                || dfs(i,j-1,count + 1, board,word);

        board[i][j] = temp;
        return found;
    }


}
