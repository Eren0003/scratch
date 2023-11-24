package leetcode.priorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallestPrimeFraction {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5};
        int k = 3;
        System.out.println(Arrays.toString(fraction(arr,k)));
    }
    static int[] fraction(int[] arr, int k){
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->Double.compare((double)a[0]/a[1],(double)b[0]/b[1]));
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = i+1 ; j < arr.length ; j++){
                queue.offer(new int[]{arr[i],arr[j]});
            }
        }
        while(k != 1){
            queue.poll();
            k -= 1;
        }
        return queue.peek();
    }

}
