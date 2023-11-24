package leetcode.Dynamic.tabulation;

public class GridTraveler {
    public static void main(String[] args) {
        System.out.println(travel(3,3));
    }
    static int travel(int m, int n){
        int [][] grid = new int[m+1][n+1];
        if(m >= 1 && n >= 1) {
            grid[1][1] = 1;
        }
        for(int i = 0 ; i <= m ; i++){
            for(int j = 0 ; j <= n ; j++){
                if(i+1 <= m){
                    grid[i+1][j] += grid[i][j];
                }if(j+1 <= n){
                    grid[i][j+1] += grid[i][j];
                }
            }
        }
        for(int [] i : grid){
            for(int j : i){
                System.out.print(j);
            }
            System.out.println();
        }
        return grid[m][n];
    }
}
