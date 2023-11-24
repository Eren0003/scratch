package leetcode.array;

import java.util.Arrays;

public class GameOfLife {
    public static void main(String[] args) {
        int[][] board = {{1,1},{1,0}};
        int [][] result = new int[board.length][board[0].length];
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                int ones = 0 ;
                if(i-1 >= 0){
                    if(board[i-1][j] == 1){
                        ones += 1;
                    }
                }if(i+1 < board.length){
                    if(board[i+1][j] == 1){
                        ones += 1;
                    }
                }if(j-1 >= 0){
                    if(board[i][j-1] == 1) {
                        ones += 1;
                    }
                }if(j+1 < board[0].length){
                    if(board[i][j+1] == 1){
                        ones += 1;
                    }
                }if(j+1 < board[0].length && i+1 < board.length){
                    if(board[i+1][j+1] == 1){
                        ones += 1;
                    }
                }if(j+1 < board[0].length && i-1 >= 0){
                    if(board[i-1][j+1] == 1){
                        ones += 1;
                    }
                }if(j-1 >= 0 && i-1 >= 0){
                    if(board[i-1][j-1] == 1){
                        ones += 1;
                    }
                }if(j-1 >= 0 && i+1 < board.length){
                    if(board[i+1][j-1] == 1){
                        ones += 1;
                    }
                }
                if(board[i][j] == 1){
                    if(ones == 2 || ones == 3) {
                        result[i][j] = 1;
                    }else{
                        result[i][j] = 0;
                    }
                }else{
                    if(ones == 3){
                        result[i][j] = 1;
                    }
                }
            }
        }
        for(int [] i : result){
            System.out.println(Arrays.toString(i));
        }
    }
}
