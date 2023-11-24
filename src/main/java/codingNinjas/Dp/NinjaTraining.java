package codingNinjas.Dp;

import java.util.ArrayList;
import java.util.Arrays;

public class NinjaTraining {
    public static void main(String[] args) {
        System.out.println(minSumPath(new int[][]{
                {8,1,6},
                {4,4,16},
                {2,7,20},
                {20,7,20}}));
    }
    public static int ninjaTraining(int n, int points[][]) {
        int max = 0 ;
        for(int i = points.length-2 ; i >= 0 ; i--){
            for(int j = 0 ; j < 3 ; j++){
                if(j == 0){
                    points[i][j] += Math.max(points[i+1][1],points[i+1][2]);
                }else if(j == 1){
                    points[i][j] += Math.max(points[i+1][0],points[i+1][2]);
                }else{
                    points[i][j] += Math.max(points[i+1][1],points[i+1][0]);
                }
                if(i == 0){
                    max = Math.max(max,points[i][j]);
                }
            }
        }
        return max;
    }
    public static int minSumPath(int[][] grid) {
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(i == 0 && j == 0){
                    continue;
                }
                else if(i == 0){
                    grid[i][j] += grid[i][j-1];
                }else if(j == 0){
                    grid[i][j] += grid[i-1][j];
                }
                else{
                    grid[i][j] += Math.min(grid[i][j-1],grid[i-1][j]);
                }
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}
