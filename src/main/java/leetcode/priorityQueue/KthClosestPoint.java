package leetcode.priorityQueue;

import java.util.*;
import java.util.stream.Collectors;

public class KthClosestPoint {
    public static void main(String[] args) {
        int[][] points  = /*{{1,3},{-2,2}};*/{{3,3},{5,-1},{-2,4}};
        for(int[] a : anotherClosest(points,2)){
            for(int b : a){
                System.out.print(b+" ");
            }
            System.out.println();
        }
    }
    static int[][] closestPoint(int[][] points ,int k){
        int [][] result = new int[k][2];
        HashMap<int[],Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int [] i : points){
            int sqrt =(int)(Math.pow(i[0],2)+Math.pow(i[1],2));
            queue.add(sqrt);
            if(queue.size() > k){
                queue.poll();
            }
        }
        int index = 0 ;
        for(int [] i : points) {
            int sqrt = (int) (Math.pow(Math.abs(i[0]), 2) + Math.pow(Math.abs(i[1]), 2));
            if(queue.contains(sqrt)){
                result[index] = i;
                queue.remove(sqrt);
                index++;
            }
            if(index == k){
                return result;
            }
        }
        return result;
    }
    static int [][] anotherClosest(int[][] points ,int k){
        int[][] result = new int[k][2];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)-> ( b[0]*b[0] + b[1]*b[1] - a[0]*a[0] - a[1]*a[1] ));
        for(int[] i : points){
            queue.offer(i);
            if(queue.size() > k ){
                queue.poll();
            }
        }
        for(int i = 0 ; i <  result.length ; i++){
            result[i] = queue.poll();
        }
        return result;
    }
}