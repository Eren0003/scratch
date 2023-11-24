package leetcode.Dynamic.tabulation;

import java.util.Arrays;

public class NumMatrix{
    public static void main(String[] args) {
        int[][] mat =
                       {{3, 0, 1, 4, 2},
                        {5, 6, 3, 2, 1},
                        {1, 2, 0, 1, 5},
                        {4, 1, 0, 1, 7},
                        {1, 0, 3, 0, 5}};
        for (int[] i : matrix(mat)){
            System.out.println(Arrays.toString(i));
        }
        System.out.println(sumRegion(2,1,4,3,mat));
    }

    public static int[][]matrix(int[][] matrix) {
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(i-1 >= 0){
                    matrix[i][j] += matrix[i-1][j];
                }if(j-1 >= 0){
                    matrix[i][j] += matrix[i][j-1];
                }if(j-1 >= 0 && i-1 >= 0){
                    matrix[i][j] -= matrix[i-1][j-1];
                }
            }
        }
        return matrix;
    }


    static int sumRegion(int row1, int col1, int row2, int col2,int [][] mat) {
        int upperLeftSquare = 0 ;
        int upperRightSquare = 0 ;
        int lowerSquare = 0;
        int result = mat[row2][col2];
        if(row1-1 >= 0 && col1 >= 0){
            upperLeftSquare = mat[row1-1][col1-1];
        }if(row1-1 >= 0){
            upperRightSquare = mat[row1-1][col2];
        }if(col1-1 >= 0){
            lowerSquare = mat[row2][col1-1];
        }
        System.out.println(upperLeftSquare+" "+upperRightSquare+" "+lowerSquare+" "+result);
        return result + upperLeftSquare - upperRightSquare - lowerSquare;
    }
}
