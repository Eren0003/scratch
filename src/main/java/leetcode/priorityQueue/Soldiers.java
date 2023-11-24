package leetcode.priorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Soldiers {
    public static void main(String[] args) {
        int[][] mat = {
                {1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}};
        System.out.println(Arrays.toString(weakestRow(mat,3)));
    }
    static int[] weakestRow(int[][] mat,int k){
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b)->{
            if(a[0] == b[0]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });
        for(int i = 0 ; i < mat.length ; i++){
            int ones = 0 ;
            for(int j : mat[i]){
                if(j == 1){
                    ones += 1;
                }
            }
            queue.offer(new int[]{ones,i});
        }
        int[] result =  new int[k];
        int counter = 0 ;
        while(counter != k){
            result[counter] = queue.poll()[1];
            counter++;
        }
        return result;
    }
}
