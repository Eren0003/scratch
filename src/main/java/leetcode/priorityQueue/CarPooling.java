package leetcode.priorityQueue;


import java.util.PriorityQueue;

public class CarPooling {

    public static void main(String[] args) {
        int[][] trips = {{2,1,5},{3,3,7}};
        int capacity = 4;
        System.out.println(car(trips,capacity));
    }
    static boolean car(int [][] trips , int capacity){
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)-> a[1] - b[1]);
        for(int [] i : trips){
            queue.add(i);
        }
        int[] prev = queue.poll();
        int passenger = prev[0];
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            if(prev[2] < curr[2] ){
                passenger += curr[2]-prev[0];
            }
        }
        return true;
    }

}
