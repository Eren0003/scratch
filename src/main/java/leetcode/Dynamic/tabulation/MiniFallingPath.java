package leetcode.Dynamic.tabulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MiniFallingPath {
    public static void main(String[] args){
        int [][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(fallingPath(grid));
    }
    static int fallingPath(int[][] grid){
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i = grid.length-1 ; i >= 0 ; i--){
            List<Integer> list = new ArrayList<>();
            for(int j = 0 ; j < grid.length ; j++){
                if(i == grid.length-1){
                    list.add(grid[i][j]);
                }else {
                    List<Integer> temp = new ArrayList<>(map.get(i + 1));
                    temp.remove(j);
                    int min = temp.stream().min((a, b) -> a - b).get().intValue();
                    grid[i][j] += min;
                    list.add(grid[i][j]);
                }
            }
            map.put(i,list);
        }

        int min = Integer.MAX_VALUE;
        for(int  i : map.get(0)){
            min = Math.min(min,i);
        }
        return min;
    }
}
