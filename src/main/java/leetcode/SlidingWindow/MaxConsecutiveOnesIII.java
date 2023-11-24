package leetcode.SlidingWindow;

import com.sun.security.jgss.GSSUtil;

public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int[] nums  = {0,1,1,1,0,1,1,0,1};
        int k = 1;
        System.out.println(consecutive(nums,k));
    }
    static int consecutive(int []nums,int k){
        int start = 0 ;
        int zeros = 0 ;
        for(int i = 0 ; i < k ; i++){
            if(nums[i] == 0){
                zeros++;
            }
        }
        int result = 0 ;
        int end = k ;
        while(start<=end && end <= nums.length){
            if(zeros-k <= 0){
                if(end<nums.length && nums[end] == 0){
                    zeros++;
                }
                result = Math.max(result,end-start-1);
                end++;
            }else{
                if(nums[start] == 0){
                    zeros--;
                }
                start++;
            }
        }
        return result;
    }
}
