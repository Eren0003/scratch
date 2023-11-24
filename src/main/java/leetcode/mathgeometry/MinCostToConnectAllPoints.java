package leetcode.mathgeometry;

import com.sun.source.doctree.SeeTree;

import java.util.*;

public class MinCostToConnectAllPoints {
    public static void main(String[] args) {
        int[][] points = {{2,-3},{-17,-8},{13,8},{-17,-15}};
        System.out.println(minCost(points));
    }
    static int minCost(int[][] points){
        int totalCost = 0 ;
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[0]-b[0]);
        minHeap.offer(new int[]{0,0,0});
        int num = points.length;
        while(!minHeap.isEmpty() && visited.size() < num){
            int[] curr = minHeap.poll();
            int j = curr[2];
            int currCost = curr[0];
            if(visited.contains(j)){
                continue;
            }
            visited.add(j);
            totalCost += currCost;
            for(int i = 0 ; i < num ; i++){
                if(!visited.contains(i)){
                    minHeap.add(new int[]{Math.abs(points[j][0]-points[i][0])+Math.abs(points[j][1]-points[i][1]),j,i});
                }
            }
        }
        return totalCost;
    }
}
