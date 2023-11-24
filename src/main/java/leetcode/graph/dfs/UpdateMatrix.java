package leetcode.graph.dfs;

import java.util.Arrays;

public class UpdateMatrix {
    public static void main(String[] args) {
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        System.out.println(Arrays.toString(update(mat)));
    }
    static int[][] update(int[][] mat){
        for(int i = 0 ; i < mat.length ; i++){
            for(int j = 0 ; j < mat[0].length ; j++){
                if(mat[i][j] == 1){
                    mat[i][j] = dfs(mat,i,j,0);
                    System.out.println(mat[i][j]+" "+i+" "+j);
                }
            }
        }
        return mat;
    }
    static int dfs(int[][]mat,int i, int j,int index){
        if(i < 0 || i == mat.length || j < 0 || j == mat[0].length ){
            return Integer.MAX_VALUE ;
        }
        if(mat[i][j] == 0){
            return index;
        }
        int result = dfs(mat,i,j+1,index+1);
        result = Math.min(result,dfs(mat,i+1,j,index+1));
        result = Math.min(result,dfs(mat,i-1,j,index+1));
        result = Math.min(result,dfs(mat,i,j-1,index+1));
        return result;
    }

}
