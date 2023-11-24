package leetcode.backTracking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class SudokuSolver {
    public static void main(String []args) {
        char [][] board = {
                {'.','.','9','7','4','8','.','.','.'},
                {'7','.','.','.','.','.','.','.','.'},
                {'.','2','.','1','.','9','.','.','.'},
                {'.','.','7','.','.','.','2','4','.'},
                {'.','6','4','.','1','.','5','9','.'},
                {'.','9','8','.','.','.','3','.','.'},
                {'.','.','.','8','.','3','.','2','.'},
                {'.','.','.','.','.','.','.','.','6'},
                {'.','.','.','2','7','5','9','.','.'}};
        solver(board);
        for(char [] i : board){
            System.out.println(Arrays.toString(i));
        }
    }
    static void solver(char[][] board){
        HashMap<Integer, HashSet<Integer>> row = new HashMap<>();
        HashMap<Integer,HashSet<Integer>> col = new HashMap<>();
        HashMap<String,HashSet<Integer>> box = new HashMap<>();
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board.length ; j++){
                String bx = (i/3)+","+(j/3);
                row.putIfAbsent(i,new HashSet<>());
                col.putIfAbsent(j,new HashSet<>());
                box.putIfAbsent(bx,new HashSet<>());
                if(board[i][j] != '.'){
                    HashSet<Integer> rSet = row.get(i);
                    rSet.add(board[i][j]-'0');
                    row.put(i,rSet);
                    HashSet<Integer> cSet = col.get(j);
                    cSet.add(board[i][j]-'0');
                    col.put(j,cSet);
                    HashSet<Integer> bSet = box.get(bx);
                    bSet.add(board[i][j]-'0');
                    box.put(bx,bSet);
                }
            }
        }
        System.out.println(row);
        System.out.println(col);
        System.out.println(box);
        dfs(board,0,0,row,col,box);
    }
    static boolean dfs(char[][] board ,int i,int j ,HashMap<Integer,HashSet<Integer>> row,HashMap<Integer,HashSet<Integer>> col,HashMap<String,HashSet<Integer>> box){
        for(int i1 = i ; i1 < board.length ; i1++){
            for(int j1 = j ; j1 < board.length ; j1++) {
                if (board[i1][j1] == '.') {
                    for(int k = 1 ; k < 10 ; k++) {
                        String bx = (i1/3)+","+(j1/3);
                        boolean r = row.get(i1).contains(k);
                        boolean c = col.get(j1).contains(k);
                        boolean b = box.get(bx).contains(k);
                        if(!r && !c && !b) {
                            board[i1][j1] = (char) (k+48);
                            System.out.println((char)(k+48)+" "+i1+","+j1);
                            HashSet<Integer> rSet = row.get(i1);
                            HashSet<Integer> cSet = col.get(j1);
                            HashSet<Integer> bSet = box.get(bx);
                            rSet.add(k);cSet.add(k);bSet.add(k);
                            row.put(i1,rSet);col.put(j1,cSet);box.put(bx,bSet);
                            if(i1 == 8 && j1 == 8){
                                return true;
                            }
                            if (dfs(board, i1, j1+1, row, col, box)) {
                                return true;
                            }
                            rSet.remove(k);cSet.remove(k);bSet.remove(k);
                            row.put(i1,rSet);col.put(j1,cSet);box.put(bx,bSet);
                            board[i1][j1] = '.';
                        }
                    }
                    if(board[i1][j1] == '.'){
                        return false;
                    }
                }
            }
            j = 0;

        }
        return false;
    }
}
