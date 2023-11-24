package leetcode.graph.bfs;

public class NearestExit {
    public static void main(String[] args) {
        char[][] maze = {
                {'+','+','.','+'},
                {'.','.','.','+'},
                {'+','+','+','.'}};
        int[] entrance = {1,2};
        System.out.println(maz(maze,entrance));
    }
    static int maz(char[][] maze,int[] entrance){
        int row = maze.length;
        int col = maze[0].length;
     return    dfs(maze,entrance[0],entrance[1],row,col);
    }
    static int dfs(char[][] maze , int i ,int j , int row , int col) {
        return 0;
    }
}
