package leetcode.graph.dfs;

public class CountBattleShips {
    public static void main(String[] args) {
        char[][] board = {
                {'X','.','.','X'},
                {'.','X','.','X'},
                {'.','.','.','X'}};
        System.out.println(battleShip(board));
    }
    static int battleShip(char[][] board){
        int ships = 0 ;
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                if(board[i][j] =='X'){
                    dfs(board,i,j);
                    ships++;
                }
            }
        }
        return ships;
    }
    static void dfs(char[][] board ,int i ,int j ){
        if(i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] == '.'){
            return ;
        }
        board[i][j] = '.';
        dfs(board,i+1,j);
        dfs(board,i-1,j);
        dfs(board,i,j+1);
        dfs(board,i,j-1);
    }
}
