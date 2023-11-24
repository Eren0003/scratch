package leetcode.graph.dfs;

public class NearestExitFromMaze {
    public static void main(String[] args) {
        char[][] maze = {
                {'+','.','+','+','+','+','+'},
                {'+','.','+','.','.','.','+'},
                {'+','.','+','.','+','.','+'},
                {'+','.','.','.','+','.','+'},
                {'+','+','+','+','+','.','+'}};
        int [] entrance = {0,1};
        System.out.println(nearExit(entrance,maze));
    }
    static int nearExit(int[] entrance,char[][] maze){
        maze[entrance[0]][entrance[1]] = '0';
        int min = dfs(entrance[0]+1,entrance[1],maze,1);
        min = Math.min(dfs(entrance[0]-1,entrance[1],maze,1),min);
        min = Math.min(dfs(entrance[0],entrance[1]+1,maze,1),min);
        min = Math.min(dfs(entrance[0],entrance[1]-1,maze,1),min);
        return min;
    }
    static int dfs(int i , int j , char[][]maze,int level){
        if(i < 0 || j < 0 || i == maze.length || j == maze[0].length ||
                maze[i][j] == '+' || maze[i][j] == '0'){
            return Integer.MAX_VALUE;
        }
        if(i == 0 || j == 0 || i == maze.length-1 || j == maze[0].length-1){
            return level;
        }
        char val = maze[i][j];
        maze[i][j] = '0';
        int min = dfs(i+1,j,maze,level+1);
        min = Math.min(dfs(i-1,j,maze,level+1),min);
        min = Math.min(dfs(i,j+1,maze,level+1),min);
        min = Math.min(dfs(i,j-1,maze,level+1),min);
        maze[i][j] = val;
        return min;
    }

}
