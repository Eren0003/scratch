package leetcode.graph.dfs;

import java.util.HashSet;
import java.util.Set;

public class WordSearch {
    public static void main(String[] args) {
        System.out.println(search(new char[][]{{'A','B','C','E'}
                                              ,{'S','F','E','S'},
                                               {'A','D','E','E'}},"ABCEFSADEESE"));
    }
    static boolean search(char [][] board ,String word){
        int row = board.length;
        int col = board[0].length;
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board,word,i,j,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    static boolean dfs(char[][] board , String word,int row , int col ,int index ){
        boolean result = false;
        if(index == word.length()){
            return true;
        }
        if( row >= board.length || row < 0 || col < 0 || col >= board[0].length ||board[row][col] != word.charAt(index)){
            return false;
        }
        char temp = board[row][col];
        if(board[row][col] == word.charAt(index)) {
            board[row][col] = '0';
            result =  dfs(board, word, row, col + 1, index + 1);
            result = result || dfs(board,word,row+1,col,index+1);
            result = result || dfs(board,word,row-1,col,index+1);
            result = result || dfs(board,word,row,col-1,index+1);
        }
        board[row][col] = temp;
        return result;
    }
}
