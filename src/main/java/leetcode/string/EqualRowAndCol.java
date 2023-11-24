package leetcode.string;

import java.util.*;

public class EqualRowAndCol {
    public static void main(String[] args) {
        int[][] grid = {{13,13},{13,13}};
        System.out.println(rowCol(grid));
    }
    static int rowCol(int[][] grid){
        HashMap<Integer,String> row = new HashMap<>();
        HashMap<Integer,String> col = new HashMap<>();
        Set<String> set = new HashSet<>();
        int result = 0 ;
        for(int i = 0 ; i < grid.length ; i++){
            StringBuilder rowSB = new StringBuilder();
            StringBuilder colSB = new StringBuilder();
            for(int j = 0 ; j < grid[0].length ; j++){
                rowSB.append(grid[i][j]).append(",");
                colSB.append(grid[j][i]).append(",");
            }
            row.put(i,rowSB.toString());
            col.put(i,colSB.toString());
        }
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(row.get(i).equals(col.get(j))){
                    result += 1;
                }
            }
        }
        return result;
    }
}
