package leetcode.graph.dfs;

public class findMaxFish {
    public static void main(String[] args) {
        int[][]grid = {{0,2,1,0},{4,0,0,3},{1,0,0,20},{0,3,2,0}};
        System.out.println(findFish(grid));
    }
    static int findFish(int[][] grid){
        int max = 0 ;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] > 0){
                    max = Math.max(dfs(i,j,grid,0),max);
                }
            }
        }
        return max;
    }
    static int dfs(int i , int j , int [][] grid,int max){
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == 0){
            return max;
        }
        max += grid[i][j];
        grid[i][j] = 0;
        max = Math.max(dfs(i+1,j,grid,max),max);
        max = Math.max(dfs(i-1,j,grid,max),max);
        max = Math.max(dfs(i,j-1,grid,max),max);
        max = Math.max(dfs(i,j+1,grid,max),max);
        return max;
    }
}
