package leetcode.binmanupulation;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.PriorityQueue;

public class SortByBit {
    public static void main(String[] args) {
        System.out.println(LocalDate.now());
//        System.out.println(Arrays.toString(sortByBits(new int[]{0,1,2,3,4,5,6,7,8})));
    }
    static int[] sortByBits(int[] arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->{
            if(Integer.bitCount(a)==Integer.bitCount(b)){
                return a-b;
            }
            return Integer.bitCount(a)-Integer.bitCount(b);
        });
        for(int i : arr){
            queue.offer(i);
        }
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = queue.poll();
        }
        return arr;
    }
}
