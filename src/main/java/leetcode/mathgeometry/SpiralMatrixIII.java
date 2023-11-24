package leetcode.mathgeometry;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class SpiralMatrixIII {
    public static void main(String[] args) {
        int rows = 5; int cols = 6 ;int rStart = 1;int cStart = 4;
        for(int [] i :matrix(rows,cols,rStart,cStart)){
            System.out.println(Arrays.toString(i));
        }
    }
    static int[][] matrix(int row ,int col,int rStart ,int cStart){
        int counter = 0 ;
        int direction = 1;
        int [][] result = new int[row*col][2];
        int i = 0 ;
        int unit = 1;
        while(col*row > counter){
            if(direction == 1 ){
                for(int j = 0 ; j < unit ; j++ ) {
                    result[i][0] = rStart;
                    result[i][1] = cStart;
                    i++;
                    rStart--;
                    counter++;
                }
                direction = 2;
            }if(direction == 2){
                for(int j = 0 ; j < unit ; j++){
                    result[i][0] = rStart;
                    result[i][1] = cStart;
                    i++;
                    cStart++;
                    counter++;
                }
                direction = 3;
            }if(direction == 3){
                for(int j = 0 ; j < unit ; j++){
                    result[i][0] = rStart;
                    result[i][1] = cStart;
                    i++;
                    rStart++;
                    counter++;
                }
                direction = 4;
            }if(direction == 4){
                for(int j = 0 ; j < unit ; j++){
                    result[i][0] = rStart;
                    result[i][1] = cStart;
                    i++;
                    cStart--;
                    counter++;
                }
                direction = 1;
            }
            unit++;
        }
        return result;
    }
}
