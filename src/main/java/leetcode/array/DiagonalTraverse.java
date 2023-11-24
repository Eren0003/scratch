package leetcode.array;

import java.util.Arrays;

public class DiagonalTraverse {
    public static void main(String[] args) {
        int [][] mat = {{1,2,3},{4,5,6},{7,8,9}};
//        System.out.println(Arrays.toString(traverse(mat));
    }
//    static int[] traverse(int [][] mat){
//        int n = mat.length;
//        int m = mat[0].length;
//        int[] result = new int[n*m];
//        int i = 0 ;
//        int j = 0 ;
//        int index = 0 ;
//        String direction = "up";
//        while(i < n && j < m){
//            int prevI = 0 ;
//            int prevJ = 0 ;
//            if(direction.equals("up")){
//                while(i < n && i >= 0 && j < m && j >= 0){
//                    result[index] = mat[i][j];
//                    prevI = i;
//                    prevJ = j;
//                    i++;
//                    j--;
//                }
//                direction = "down";
//            }
//            prevI = i;
//            prevJ = j;
//            while(i < n && i >= 0 && j < m && j >= 0){
//                result[index] = mat[i][j];
//                prevI = i;
//                prevJ = j;
//                i--;
//                j++;
//            }
//        }
//    }
}
