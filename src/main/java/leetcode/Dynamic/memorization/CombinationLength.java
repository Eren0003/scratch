package leetcode.Dynamic.memorization;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class CombinationLength {
    public static void main(String[] args) {
        int[] nums1 = {1,3,3,2};
        int [] nums2 = {2,1,3,4};
        int k = 3;
        System.out.println(combination(nums1,k,nums2));
    }
    static int combination(int[] nums1,int k,int[] nums2){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        return dfs(nums1,nums2,0,k,0,0,queue);
    }
    static int dfs(int[] nums1, int[] nums2,int index , int k, int sum, int count, PriorityQueue<Integer> queue){
        if(count == k){
            System.out.println(sum +" "+ queue.peek());
            return sum*queue.peek();
        }
        if(index == nums1.length) return 0 ;
        queue.add(nums2[index]);
        int max = dfs(nums1,nums2,index+1,k,sum+nums1[index],count+1,queue);
        queue.remove(nums2[index]);
        max = Math.max(dfs(nums1,nums2,index+1,k,sum,count,queue),max);
        return max;
    }

}
