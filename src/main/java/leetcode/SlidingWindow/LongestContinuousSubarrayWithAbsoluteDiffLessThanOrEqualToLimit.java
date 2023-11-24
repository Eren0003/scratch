package leetcode.SlidingWindow;

import java.util.PriorityQueue;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    public static void main(String[] args) {
        int[] nums = {4,2,2,2,4,4,2,2};
        int limit = 0 ;
        System.out.println(subArray(nums,limit));
    }
    static int subArray(int[] nums,int limit){
        int start = 0 ;
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>((a,b)->b-a);
        min.add(nums[0]);
        max.add(nums[0]);
        int result = 0 ;
        int end = 0;
        while(start <= end && end < nums.length){
            if(Math.abs(min.peek()-max.peek()) <= limit){
                result = Math.max(end-start+1,result);
                end++;
                if(end < nums.length){
                    min.offer(nums[end]);
                    max.offer(nums[end]);
                }

            }else{
                min.remove(nums[start]);
                max.remove(nums[start]);
                start++;
            }
        }
        return result;
    }
}
