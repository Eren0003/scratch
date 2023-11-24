package leetcode.mathgeometry;

import java.util.Arrays;

public class ZeroOneMatrix {
    public static void main(String[] args) {
        for(int[] i : updateMatrix1(new int[][]{
                {0},
                {1}
        })){
            System.out.println(Arrays.toString(i));
        }
    }
    static int[][] updateMatrix1(int[][] mat){
        for(int i = 0 ; i < mat.length ; i++){
            for(int j = 0 ; j < mat[0].length ; j++){
                if(mat[i][j] == 1){
                    mat[i][j] = (int)1e9;
                }
            }
        }
        for(int i = 0 ; i < mat.length ; i++){
            int j = 1 , m = mat[0].length-2;
            int prevJ = mat[i][0] ;
            int prevM = mat[i][mat[0].length-1];
            while(j < mat[0].length && m >= 0 ){
                if(mat[j][i] != 0){
                    mat[j][i] = Math.min(mat[j][i],prevJ+1);
                }
                if(mat[m][i] != 0){
                    mat[m][i] = Math.min(mat[m][i],prevM+1);
                }
                prevJ = mat[j][i];
                prevM = mat[m][i];
                j++;
                m--;
            }
        }for(int i = mat.length-1 ; i >= 0 ; i--){
            int j = 1 , m = mat[0].length-2;
            int prevJ = mat[i][0];
            int prevM = mat[i][mat[0].length-1];
            while(j < mat[0].length && m >= 0 ){
                if(mat[i][j] != 0){
                    mat[i][j] = Math.min(mat[i][j],prevJ+1);
                }
                if(mat[i][m] != 0){
                    mat[i][m] = Math.min(mat[i][j],prevM+1);
                }
                prevJ = mat[i][j];
                prevM = mat[i][m];
                j++;
                m--;
            }
        }
        return mat;
    }
}
