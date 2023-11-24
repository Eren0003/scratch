package leetcode.Dynamic.tabulation;

import java.lang.reflect.Array;
import java.util.Arrays;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(roundTwo(nums));
    }
    static boolean game(int[] nums){
        boolean[] dp = new boolean[nums.length];
        dp[nums.length-1] = true;
        for(int i = nums.length-1 ; i >= 0 ; i--){
            for(int j = i-1 ; j >= 0 ; j--){
                if(!dp[i]){
                    break;
                }
                if(dp[i] && i-j <= nums[j]){
                    dp[j] = true;
                }
            }
        }
        return dp[0];
    }
    static boolean roundTwo(int[] nums){
        boolean [] dp = new boolean[nums.length+1];
        dp[1] = true;
        for(int i = 1 ; i < dp.length ; i++){
            int counter = i+1;
            while(nums[i-1] != 0){
                if (!dp[i]) {
                    break;
                } else {
                    if(counter <= nums.length) {
                        dp[counter] = true;
                    }
                }
                counter++;
                nums[i-1] = nums[i-1]-1;
            }
        }
        return dp[nums.length];
    }
}
