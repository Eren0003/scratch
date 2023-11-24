package leetcode.Dynamic.tabulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumRectangleNoLargerThanK {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int k = 2 ;
        System.out.println(maxSum(matrix,k));
    }
    static int maxSum(int[][] matrix,int k){
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(i > 0){
                    matrix[i][j] += matrix[i-1][j];
                }if(j > 0){
                    matrix[i][j] += matrix[i][j-1];
                }if(i > 0 && j > 0){
                    matrix[i][j] -= matrix[i-1][j-1];
                }
            }
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.stream().min((a,b)-> a- b);
        }
        for(int [] i : matrix){
            System.out.println(Arrays.toString(i));
        }
        return -1;
    }
}
