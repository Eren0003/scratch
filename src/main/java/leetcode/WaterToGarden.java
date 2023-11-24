package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class WaterToGarden {
    public static void main(String[] args) {
        int [] ranges = {3,2,1,1,0,0};
        int n = ranges.length-1;
        System.out.println(water(ranges,n));
    }
    static int water(int [] ranges ,int n){
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->{
            if(a[0] != b[0]) {
             return a[0] - b[0];
            }else{
                return a[1]-b[1];
            }
        });
        for(int i = 0 ; i < ranges.length ; i++){
            if(ranges[i] != 0) {
                if (i - ranges[i] >= 0) {
                    queue.add(new int[]{i - ranges[i], i + ranges[i]});
                } else {
                    queue.add(new int[]{0, i + ranges[i]});
                }
            }
        }
        int max = 0 ;
        while(!queue.isEmpty()){
            int [] temp = queue.poll();
//            if(temp )
        }
        return 1;
    }
}
