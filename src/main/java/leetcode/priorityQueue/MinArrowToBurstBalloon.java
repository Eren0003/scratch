package leetcode.priorityQueue;

import java.util.PriorityQueue;

public class MinArrowToBurstBalloon {
    public static void main(String[] args) {
        int[][] points = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        System.out.println(minArrow(points));
    }
    static int minArrow(int[][] points){
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->{
            if(a[0] >= 0 && b[0] >= 0){
                if(a[0] == b[0]){
                    return a[1]-b[1];
                }
                return a[0]-b[0];
            }else{
                if(b[0] == a[0]) {
                    return b[1] - a[1];
                }else{
                    return b[0] - b[0];
                }
            }
        });
        int arrow = 1 ;
        for(int [] i : points){
            queue.offer(i);
        }
        int [] prev = queue.poll();
        while(!queue.isEmpty()){
            int [] curr = queue.poll();
            if(prev[1] < curr[0]) {
                prev = curr;
                arrow++;
            }
        }
        return arrow;
    }
}
