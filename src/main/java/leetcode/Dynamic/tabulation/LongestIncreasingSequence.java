package leetcode.Dynamic.tabulation;

import java.util.Arrays;

public class LongestIncreasingSequence {
    public static void main(String[] args) {
        int [] nums = {0,1,0,3,2,3};
        System.out.println(table(nums));
    }
    static int table(int[] nums){
        int [] dp = new int[nums.length+1];
        int min = nums[0];
        dp[0] = 1;
        for(int i = 1 ; i < dp.length ; i++){
            if(min < nums[i-1]) {
                dp[i] = dp[i - 1] + 1;
                min = nums[i-1];
            }else{
                dp[i] = dp[i-1];
                min = nums[i-1];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[dp.length-1];
    }
}
