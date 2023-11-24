package leetcode.priorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxSubsequenceScore {
    public static void main(String[] args) {
        int [] nums1 = {4,2,3,1,1};
        int [] nums2 = {7,5,10,9,6};
        int k = 1;
        System.out.println(max(nums1,nums2,k));
    }
    static long max(int[] nums1, int [] nums2 , int k){
        PriorityQueue<Long> outer = new PriorityQueue<>(Collections.reverseOrder());
        backTrack(nums1,nums2,0,0,k,new PriorityQueue<>(),0,outer);
        return outer.peek();
    }
    static void backTrack(int[] nums1, int[] nums2, int length , int index , int k, PriorityQueue<Integer> queue,long sum,PriorityQueue<Long> outer){
        if(length == k){
            outer.add(sum*queue.peek());
            return;
        }
        if(index >= nums1.length) return;
        queue.add(nums2[index]);
        backTrack(nums1,nums2,length+1,index+1,k,queue,sum+nums1[index],outer);
        queue.remove(nums2[index]);
        backTrack(nums1,nums2,length,index+1,k,queue,sum,outer);
    }

}
