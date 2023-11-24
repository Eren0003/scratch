package leetcode.SlidingWindow;

import java.util.Arrays;

public class MaxFrequency {
    public static void main(String[] args) {
        System.out.println(frequency(new int[]{1,2,4},5));
    }
    static int frequency(int[] nums,int k){
        Arrays.sort(nums);
        int total = 0 ;
        int start = 0 ;
        int end = 0 ;
        long max = 0 ;
        while(start <= end && end < nums.length){
            if(total+k >= nums[end]*(end-start)){
                total += nums[end];
                end++;
                max = Math.max(max,end-start);
            }else{
                total -= nums[start];
                start++;
            }
        }
        return (int)max;
    }
}
