package leetcode.graph.dfs;

import java.util.HashSet;
import java.util.Set;

public class UniquePathIII {
    public static void main(String[] args) {
        int [][]grid = {{0,1},{2,0}};
        System.out.println(path(grid));
    }
    static int path(int[][]grid){
        int brick = 0 ;
        int startRow = 0 ,startCol = 0 , endRow = 0 ,endCol = 0 ;
        Set<String> set = new HashSet<>();
        for(int i = 0 ; i < grid.length ;i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == -1){
                    brick += 1;
                }
                if(grid[i][j] == 1){
                    startRow = i;
                    startCol = j;
                }if(grid[i][j] == 2){
                    endRow = i;
                    endCol = j;
                }
            }
        }
        return dfs(grid,startRow,startCol,(grid.length*grid[0].length)-brick,1,set);
    }
    static int dfs(int[][] grid  ,int i , int j,int totalLen , int curr ,Set<String> set){
        if(i == grid.length || j == grid[0].length || i < 0 || j < 0 || grid[i][j] == -1 || set.contains(i+","+j) ){
            return 0;
        }
        if(grid[i][j] == 2 && totalLen != curr){
            return 0;
        }
        if(totalLen == curr && grid[i][j] == 2){
            return 1;
        }
        set.add(i+","+j);
        int result = dfs(grid,i+1,j,totalLen,curr+1,set);
        result += dfs(grid,i-1,j,totalLen,curr+1,set);
        result += dfs(grid,i,j+1,totalLen,curr+1,set);
        result += dfs(grid,i,j-1,totalLen,curr+1,set);
        set.remove(i+","+j);
        return result;
    }
}
