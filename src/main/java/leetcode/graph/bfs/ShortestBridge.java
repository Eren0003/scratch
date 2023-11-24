package leetcode.graph.bfs;

import java.util.*;

public class ShortestBridge {
    public static void main(String[] args) {
        int [][]grid = {
                {0,0,0,0,0,0},
                {0,1,0,0,0,0},
                {1,1,0,0,0,0},
                {1,1,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,1,1,0,0}
        };
        System.out.println(shortestBridge(grid));
    }
    static int shortestBridge(int[][]grid){
        Queue<int[]> queue = new LinkedList<>();
        boolean flag = false;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1){
                    dfs(i,j,grid,queue);
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }
        int level = 0;
        while(!queue.isEmpty()) {
            Queue<int[]> innerQueue = new LinkedList<>(queue);
            queue.removeAll(queue);
            while (!innerQueue.isEmpty()) {
                int[] temp = innerQueue.poll();
                if (grid[temp[0]][temp[1]] == 1) {
                    return level-1;
                }
                if(grid[temp[0]][temp[1]] == -1){
                    continue;
                }
                grid[temp[0]][temp[1]] = -1;
                if (temp[0] < grid.length - 1 && grid[temp[0]+1][temp[1]] >= 0) {
                    queue.offer(new int[]{temp[0] + 1, temp[1]});
                }
                if (temp[0] > 0 && grid[temp[0]-1][temp[1]] >= 0) {
                    queue.offer(new int[]{temp[0] - 1, temp[1]});
                }
                if (temp[1] < grid[0].length - 1 && grid[temp[0]][temp[1]+1] >= 0) {
                    queue.offer(new int[]{temp[0], temp[1] + 1});
                }
                if (temp[1] > 0 && grid[temp[0]][temp[1]-1] >= 0) {
                    queue.offer(new int[]{temp[0], temp[1] - 1});
                }
            }
            level++;
        }
        return -1;
    }
    static void dfs(int i , int j , int[][] grid, Queue<int[]> queue){
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == 0){
            return ;
        }
        queue.add(new int[]{i,j});
        grid[i][j] = 0;
        dfs(i+1,j,grid,queue);
        dfs(i-1,j,grid,queue);
        dfs(i,j-1,grid,queue);
        dfs(i,j+1,grid,queue);
    }
}
