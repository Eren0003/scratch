package leetcode.Dynamic.tabulation;

import java.util.Arrays;

public class UniquePathII {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(grid(obstacleGrid));
    }
    static int grid(int[][]obstacleGrid){
        if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1) return 0;
        if(obstacleGrid[0][0] != 1) {
            obstacleGrid[0][0] = -1;
        }
        for(int i = 0 ; i < obstacleGrid.length ; i++){
            for(int j = 0 ; j < obstacleGrid[0].length ; j++){
                if(obstacleGrid[i][j] == 1){
                    continue;
                }
                if(i+1 < obstacleGrid.length &&obstacleGrid[i+1][j] != 1) {
                    obstacleGrid[i + 1][j] += obstacleGrid[i][j];
                }
                if(j+1 < obstacleGrid[0].length && obstacleGrid[i][j+1] != 1) {
                    obstacleGrid[i][j + 1] += obstacleGrid[i][j];
                }
            }
        }
        return Math.abs(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]);
    }
}
